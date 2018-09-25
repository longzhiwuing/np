package com.cecdat.np.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cecdat.np.dto.BootStrapTableData;
import com.cecdat.np.entity.DemoData;
import com.cecdat.np.mapper.DemoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/20
 * Time: 13:05
 */
@Service
@Slf4j
public class DemoDataService {
    @Autowired
    DemoDataMapper demoDataMapper;

    public BootStrapTableData<DemoData> getTableData(int pageSize,int pageNumber,String sortName,String sortOrder,String searchText) {
        BootStrapTableData<DemoData> data = new BootStrapTableData<>();
        Integer count = demoDataMapper.selectCount(new EntityWrapper<>());

        Page<DemoData> page = new Page<>(pageNumber, pageSize);
        Wrapper<DemoData> ew = new EntityWrapper<DemoData>();

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

        List<DemoData> demoData = demoDataMapper.selectPage(page,ew);

        data.setTotal(count);
        data.setRows(demoData);
        return data;
    }

    public JSONObject getEchartData() {
        JSONObject dataObj = new JSONObject();

        List<DemoData> demoData = demoDataMapper.selectList(
                new EntityWrapper<DemoData>()
        );

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        for (DemoData data : demoData) {
            xAxis.add(data.getName());
            yAxis.add(data.getCount());
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }
}
