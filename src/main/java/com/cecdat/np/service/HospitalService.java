package com.cecdat.np.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.dto.HospitalData;
import com.cecdat.np.dto.HospitalResourseData;
import com.cecdat.np.mapper.HospitalMapper;
import com.cecdat.np.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 住院情况Service
 * @author: jcl
 * Date: 2018/06/25
 * Time: 17:20
 */
@Service
@Slf4j
public class HospitalService {

    @Autowired
    private HospitalMapper hospitalMapper;

    //根据传入起止时间，查询各家医院的入院人次，返回Echart图数据
    public JSONObject getEchartDataAdmissionNum(String startDate,String endDate){
        JSONObject dataObj = new JSONObject();

        List<HospitalData> hospitalEchart = hospitalMapper.queryAdmissionNumEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        for (HospitalData data : hospitalEchart) {
            xAxis.add(data.getHospitalName());
            yAxis.add(data.getAdmissionNum());
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院的出院人次，返回Echart图数据
    public JSONObject getEchartDataOutNum(String startDate,String endDate){
        JSONObject dataObj = new JSONObject();

        List<HospitalData> hospitalEchart = hospitalMapper.queryOutNumEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        for (HospitalData data : hospitalEchart){
            xAxis.add(data.getHospitalName());
            yAxis.add(data.getOutNum());
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院的出院者平均住院日，返回Echart图数据
    public JSONObject getEchartDataAverageHospitalDay(String startDate,String endDate){
        JSONObject dataObj = new JSONObject();

        List<HospitalData> hospitalEchart = hospitalMapper.queryAverageHospitalDayEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        DecimalFormat df=new DecimalFormat("0.00");
        for (HospitalData data : hospitalEchart){
            xAxis.add(data.getHospitalName());
            if(data.getOutNum() != 0){
                yAxis.add(df.format(data.getOutBedNum()/data.getOutNum()));
            }
//            yAxis.add(0);
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院的床位使用率，返回Echart图数据
    public JSONObject getEchartDataBedUseRatio(String startDate,String endDate){
        JSONObject dataObj = new JSONObject();

        List<HospitalData> hospitalEchart = hospitalMapper.queryBedUseRatioEchart(Util.getStringParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        DecimalFormat df=new DecimalFormat("0.00");
        for (HospitalData data : hospitalEchart) {
            xAxis.add(data.getHospitalName());
            if(data.getBedOpenNum() != 0) {
                yAxis.add(df.format((100 * data.getBedUserNum()) / data.getBedOpenNum()));
            }else{
                yAxis.add(0);
            }
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院的手术人数，返回Echart图数据
    public JSONObject getEchartDataOperatioRens(String startDate,String endDate){
        JSONObject dataObj = new JSONObject();

        List<HospitalData> hospitalEchart = hospitalMapper.queryOperatioRensEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        for (HospitalData data : hospitalEchart){
            xAxis.add(data.getHospitalName());
            yAxis.add(data.getOperationRens());
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院的死亡人数，返回Echart图数据
    public JSONObject getEchartDataDeathRens(String startDate,String endDate){
        JSONObject dataObj = new JSONObject();

        List<HospitalData> hospitalEchart = hospitalMapper.queryDeathRensEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        for (HospitalData data : hospitalEchart){
            xAxis.add(data.getHospitalName());
            yAxis.add(data.getDeathRens());
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院的实际占用总床日数，返回Echart图数据
    public JSONObject getEchartDataBedUseNum(String startDate,String endDate){
        JSONObject dataObj = new JSONObject();

        List<HospitalData> hospitalEchart = hospitalMapper.queryBedUseNumEchart(Util.getStringParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        for (HospitalData data : hospitalEchart){
            xAxis.add(data.getHospitalName());
            yAxis.add(data.getBedUserNum());
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    /**
     *
     * @Description: 出院者床日数。
     *
     * @param:
     * @return:
     */
    public JSONObject getOutBedNumEchartData(String startDate, String endDate) {

        List<HospitalData> hospitalDataList =
                hospitalMapper.selectOutBedNumByDate(Util.getStringParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalData data : hospitalDataList) {
            xAxis.add(data.getHospitalName());
            yAxis.add(data.getOutBedNum());
        }
        return new JSONObject(){
            {
                put("xAxis", xAxis);
                put("yAxis", yAxis);
            }
        };
    }
    /**
     *
     * @Description: 医师平均担负住院床日数。
     *
     * @param:
     * @return:
     */
    public JSONObject getDocLoadBedCountEchartData(String startDate, String endDate) {

        List<HospitalData> hospitalDataList =
                hospitalMapper.selectDocLoadBedCountByDate(Util.getStringParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalData data : hospitalDataList) {
            xAxis.add(data.getHospitalName());
            yAxis.add(data.getDocLoadBedCount());
        }
        return new JSONObject(){
            {
                put("xAxis", xAxis);
                put("yAxis", yAxis);
            }
        };
    }

    public JSONObject getOperationNumberSumEchartsData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();
        List<HospitalData> hospitalDatas =
                hospitalMapper.selectOperationNumberSum(Util.getParamMapByStartAndEndDate(startDate, endDate)
                );
        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalData outpatientAnalysisDTO : hospitalDatas) {
            xAxis.add(outpatientAnalysisDTO.getHospitalName());
            yAxis.add(outpatientAnalysisDTO.getOperationNumberSum());

        }
        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);
        return dataObj;
    }

}
