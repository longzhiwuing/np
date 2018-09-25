package com.cecdat.np.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cecdat.np.dto.BootStrapTableData;
import com.cecdat.np.dto.SignBillData;
import com.cecdat.np.entity.SignBill;
import com.cecdat.np.mapper.SignBillMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @author: liuzihao@cecdat.com
 * Date: 2018/6/21
 * Time: 11:16
 */
@Service
@Slf4j
public class SignBillService {

    @Autowired
    SignBillMapper signBillMapper;

    public BootStrapTableData<SignBill> getTableData(int pageSize, int pageNumber, String sortName, String sortOrder, String searchText) {
        BootStrapTableData<SignBill> data = new BootStrapTableData<>();
        Integer count = signBillMapper.selectCount(new EntityWrapper<>());

        Page<SignBill> page = new Page<>(pageNumber, pageSize);
        Wrapper<SignBill> ew = new EntityWrapper<>();

        if (StringUtils.isNotEmpty(sortName)&&StringUtils.isNotEmpty(sortOrder)) {
            ew = ew.orderBy(sortName,sortOrder.equalsIgnoreCase("asc"));
        }

        if (StringUtils.isNotEmpty(searchText)) {
            ew.like("name", searchText);
        }

        /*ew.where("user_name={0}", "'zhangsan'").and("id=1")
                .orNew("user_status={0}", "0").or("status=1")
                .notLike("user_nickname", "notvalue")
                .andNew("new=xx").like("hhh", "ddd")
                .andNew("pwd=11").isNotNull("n1,n2").isNull("n3")
                .groupBy("x1").groupBy("x2,x3")
                .having("x1=11").having("x3=433")
                .orderBy("dd").orderBy("d1,d2");*/

        List<SignBill> signBill = signBillMapper.selectPage(page,ew);

        data.setTotal(count);
        data.setRows(signBill);
        return data;
    }

    public JSONObject getEchartData() {
        JSONObject dataObj = new JSONObject();

        List<SignBillData> signBill = signBillMapper.selectSignBillList();

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis1 = new JSONArray();
        JSONArray yAxis2 = new JSONArray();

        for (SignBillData data : signBill) {
            xAxis.add(data.getDimYear());
            yAxis1.add(data.getGetCount());
            yAxis2.add(data.getHandleCount());
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis1", yAxis1);
        dataObj.put("yAxis2", yAxis2);

//        log.info("echartData:{}",dataObj.toJSONString());
        return dataObj;
    }

    public JSONObject getEchartPieData() {
        JSONObject dataObj = new JSONObject();

        List<SignBill> signBill = signBillMapper.selectList(
                new EntityWrapper<>()
        );

        JSONArray legend = new JSONArray();
        Map<String,Object> yAxisMap = null;
        JSONArray yAxis = new JSONArray();

        for (SignBill data : signBill) {
            legend.add(data.getDimYear() + "年");
            yAxisMap = new HashMap<>();
            yAxisMap.put("value",data.getGetCount());
            yAxisMap.put("name",data.getDimYear() + "年");
            yAxis.add(yAxisMap);
        }

        dataObj.put("legend", legend);
        dataObj.put("yAxis", yAxis);

//        log.info("echartData:{}",dataObj.toJSONString());
        return dataObj;
    }
}
