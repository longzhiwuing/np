package com.cecdat.np.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.dto.HospitalCostData;
import com.cecdat.np.mapper.HospitalCostMapper;
import com.cecdat.np.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 住院费用Service
 * @author: jcl
 * Date: 2018/06/26
 * Time: 20:15
 */
@Service
@Slf4j
public class HospitalCostService {


    private final String[] fee = {"住院费用","药品费用","材料费用","治疗费用","检查费用","化验费","手术费","其他费","床位费用"};

    @Autowired
    private HospitalCostMapper hospitalCostMapper;

    //根据传入起止时间，查询各家医院的住院人均费用，返回Echart图数据
    public JSONObject getEchartDataPeopleAverageCost(String startDate, String endDate){
        JSONObject dataObj = new JSONObject();

        List<HospitalCostData> hospitalCostEchart = hospitalCostMapper.queryPeopleAverageCostEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        DecimalFormat df = new DecimalFormat("0.00");
        for (HospitalCostData data : hospitalCostEchart) {
            xAxis.add(data.getHospitalName());
            if(data.getOutNum() != 0){
                yAxis.add(df.format(data.getIncomeResi()/data.getOutNum()));
            }else{
                yAxis.add(0);
            }
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院住院药费占比，返回Echart图数据
    public JSONObject getEchartDataPhysicByHospitalCost(String startDate, String endDate){
        JSONObject dataObj = new JSONObject();

        List<HospitalCostData> hospitalCostEchartOfFHKD = hospitalCostMapper.queryPhysicByHospitalCostEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        DecimalFormat df = new DecimalFormat("0.00");
        for (HospitalCostData data : hospitalCostEchartOfFHKD) {
            xAxis.add(data.getHospitalName());
            if(data.getIncomeResi() != 0){
                yAxis.add(df.format((100*data.getIncomePhysicResi())/data.getIncomeResi()));
            }else{
                yAxis.add(0);
            }
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院住院耗材费占比，返回Echart图数据
    public JSONObject getEchartDataMaterialByHospitalCost(String startDate, String endDate){
        JSONObject dataObj = new JSONObject();

        List<HospitalCostData> hospitalCostEchartOfFHKD = hospitalCostMapper.queryMaterialByHospitalCostEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        DecimalFormat df = new DecimalFormat("0.00");
        for (HospitalCostData data : hospitalCostEchartOfFHKD) {
            xAxis.add(data.getHospitalName());
            if(data.getIncomeResi() != 0){
                yAxis.add(df.format((100*data.getIncomeMaterialResi())/data.getIncomeResi()));
            }else{
                yAxis.add(0);
            }
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院住院检查费占比，返回Echart图数据
    public JSONObject getEchartDataCheckByHospitalCost(String startDate, String endDate){
        JSONObject dataObj = new JSONObject();

        List<HospitalCostData> hospitalCostEchartOfFHKD = hospitalCostMapper.queryCheckByHospitalCostEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        DecimalFormat df = new DecimalFormat("0.00");
        for (HospitalCostData data : hospitalCostEchartOfFHKD) {
            xAxis.add(data.getHospitalName());
            if(data.getIncomeResi() != 0){
                yAxis.add(df.format((100*data.getIncomeCheckResi())/data.getIncomeResi()));
            }else{
                yAxis.add(0);
            }
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院住院化验费占比，返回Echart图数据
    public JSONObject getEchartDataLaboratoryByHospitalCost(String startDate, String endDate){
        JSONObject dataObj = new JSONObject();

        List<HospitalCostData> hospitalCostEchartOfFHKD = hospitalCostMapper.queryLaboratoryByHospitalCostEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        DecimalFormat df = new DecimalFormat("0.00");
        for (HospitalCostData data : hospitalCostEchartOfFHKD) {
            xAxis.add(data.getHospitalName());
            if(data.getIncomeResi() != 0){
                yAxis.add(df.format((100*data.getIncomeLaboratoryResi())/data.getIncomeResi()));
            }else{
                yAxis.add(0);
            }
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }
    /**
     *
     * @Description: 住院费用占比图。
     *
     * @param:
     * @return:
     */
    public JSONObject getResFeeProportionEchartPieData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();

        HospitalCostData hospitalCostData =
                hospitalCostMapper.selectResFeeProportionByDate(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray legend = (JSONArray) JSONArray.toJSON(fee);
        Map<String,Object> yAxisMap = null;
        JSONArray yAxis = new JSONArray();

        List<Object> feeList = null;


        if(hospitalCostData != null){
            feeList = new ArrayList<Object>(){
                {
                    add(hospitalCostData.getOutStayFee());
                    add(hospitalCostData.getOutPhysicFee());
                    add(hospitalCostData.getOutMaterialFee());
                    add(hospitalCostData.getOutClinicFee());
                    add(hospitalCostData.getOutCheckFee());
                    add(hospitalCostData.getOutAssayFee());
                    add(hospitalCostData.getOutOperationFee());
                    add(hospitalCostData.getOutOtherFee());
                    add(hospitalCostData.getOutBedFee());
                }
            };
        }else{
            return dataObj;
        }

        for(int i=0;i<feeList.size();i++){
            yAxisMap = new HashMap<>();
            yAxisMap.put("name",fee[i]);
            yAxisMap.put("value",feeList.get(i));
            yAxis.add(yAxisMap);
        }
        dataObj.put("legend", legend);
        dataObj.put("yAxis", yAxis);

        log.info("echartData:{}",dataObj.toJSONString());
        return dataObj;
    }
}
