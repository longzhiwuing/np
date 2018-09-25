package com.cecdat.np.service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.dto.OutpatientAnalysisDTO;
import com.cecdat.np.mapper.OutpatientAnalysisMapper;
import com.cecdat.np.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create with IntelliJ IDEA.
 *
 * @author: hezhuangzhuang@cecdat.com
 * Date: 2018/6/25
 * Time: 14:27
 */
@Service
@Slf4j
public class OutpatientAnalysisService {

    final String[] fee = {"门诊费用","药品费用","材料费用","治疗费用","检查费用","化验费","手术费","其他费","床位费用"};

    @Autowired
    OutpatientAnalysisMapper outpatientAnalysisMapper;

    /**
     * 门急诊人次
     * @param startDate
     * @param endDate
     * @return
     */
    public JSONObject getDispRegisterNumByTimeEchartData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();
        List<OutpatientAnalysisDTO> outpatientAnalysisDTOS =
                outpatientAnalysisMapper.selectDispRegisterNumByTime(Util.getParamMapByStartAndEndDate(startDate, endDate)
                );
        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (OutpatientAnalysisDTO outpatientAnalysisDTO : outpatientAnalysisDTOS) {
            xAxis.add(outpatientAnalysisDTO.getHospitalName());
            if (outpatientAnalysisDTO.getDispRegisterNumByTime()!=null){
                yAxis.add(outpatientAnalysisDTO.getDispRegisterNumByTime());
            }else{
                yAxis.add(0);
            }

        }
        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);
        return dataObj;
    }

    /**
     * 人均费用
     * @param startDate
     * @param endDate
     * @return
     */
    public JSONObject getAvgFeeByPeopleEchartData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();
        List<OutpatientAnalysisDTO> outpatientAnalysisDTOS =
                outpatientAnalysisMapper.selectAvgFeeByPeople(Util.getParamMapByStartAndEndDate(startDate, endDate)
                );
        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (OutpatientAnalysisDTO outpatientAnalysisDTO : outpatientAnalysisDTOS) {
            xAxis.add(outpatientAnalysisDTO.getHospitalName());
            yAxis.add(outpatientAnalysisDTO.getAvgFeeByPeople());

        }
        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);
        return dataObj;
    }

    /**
     *  药占比
     * @param startDate
     * @param endDate
     * @return
     */
    public JSONObject getMedicineProportionEchartData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();
        List<OutpatientAnalysisDTO> outpatientAnalysisDTOS =
                outpatientAnalysisMapper.selectMedicineProportion(Util.getParamMapByStartAndEndDate(startDate, endDate)
                );
        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (OutpatientAnalysisDTO outpatientAnalysisDTO : outpatientAnalysisDTOS) {
            xAxis.add(outpatientAnalysisDTO.getHospitalName());
            Double rate = new BigDecimal((float) outpatientAnalysisDTO.getMedicineProportion()*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if(rate!=null){
                yAxis.add(rate);
            }else {
                yAxis.add(0);
            }


        }
        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);
        return dataObj;
    }

    /**
     * 耗材占比
     * @param startDate
     * @param endDate
     * @return
     */
    public JSONObject getConsumablesProportionEchartsData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();
        List<OutpatientAnalysisDTO> outpatientAnalysisDTOS =
                outpatientAnalysisMapper.selectConsumablesProportion(Util.getParamMapByStartAndEndDate(startDate, endDate)
                );
        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (OutpatientAnalysisDTO outpatientAnalysisDTO : outpatientAnalysisDTOS) {
            xAxis.add(outpatientAnalysisDTO.getHospitalName());
            Double rate = new BigDecimal((float) outpatientAnalysisDTO.getConsumablesProportion()*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (rate!=null){
                yAxis.add(rate);
            }else {
                yAxis.add(0);
            }


        }
        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);
        return dataObj;
    }

    /**
     * 检查费占比
     * @param startDate
     * @param endDate
     * @return
     */
    public JSONObject getCheckFeeProportionEchartsData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();
        List<OutpatientAnalysisDTO> outpatientAnalysisDTOS =
                outpatientAnalysisMapper.selectCheckFeeProportion(Util.getParamMapByStartAndEndDate(startDate, endDate)
                );
        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (OutpatientAnalysisDTO outpatientAnalysisDTO : outpatientAnalysisDTOS) {
            xAxis.add(outpatientAnalysisDTO.getHospitalName());
            Double rate = new BigDecimal((float) outpatientAnalysisDTO.getCheckFeeProportion()*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
          if (rate!=null){
              yAxis.add(rate);
          }else {
              yAxis.add(0);
          }

        }
        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);
        return dataObj;
    }

    /**
     * 化验费占比
     * @param startDate
     * @param endDate
     * @return
     */
    public JSONObject getLaboratoryFeeProportionEchartsData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();
        DecimalFormat df = new DecimalFormat(".00");
        List<OutpatientAnalysisDTO> outpatientAnalysisDTOS =
                outpatientAnalysisMapper.selectLaboratoryFeeProportion(Util.getParamMapByStartAndEndDate(startDate, endDate)
                );
        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (OutpatientAnalysisDTO outpatientAnalysisDTO : outpatientAnalysisDTOS) {
            xAxis.add(outpatientAnalysisDTO.getHospitalName());
            Double rate = new BigDecimal((float) outpatientAnalysisDTO.getLaboratoryFeeProportion()*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (rate!=null){
                yAxis.add(rate);
            }else {
                yAxis.add(0);
            }

        }
        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);
        return dataObj;
    }


    /**
     * 门诊手术例数和
     * @param startDate
     * @param endDate
     * @return
     */
    public JSONObject getDisp0perationNumSumEchartsData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();
        List<OutpatientAnalysisDTO> outpatientAnalysisDTOS =
                outpatientAnalysisMapper.selectDisp0perationNumSum(Util.getParamMapByStartAndEndDate(startDate, endDate)
                );
        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (OutpatientAnalysisDTO outpatientAnalysisDTO : outpatientAnalysisDTOS) {
            xAxis.add(outpatientAnalysisDTO.getHospitalName());
            if(outpatientAnalysisDTO.getDisp0perationNumSum()!=null){
                yAxis.add(outpatientAnalysisDTO.getDisp0perationNumSum());
            }else{
                yAxis.add(0);
            }

        }
        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);
        return dataObj;
    }

    /**
     * 门急诊手术处方数和
     * @param startDate
     * @param endDate
     * @return
     */
    public JSONObject getPrescribeDispNumSumEchartsData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();
        List<OutpatientAnalysisDTO> outpatientAnalysisDTOS =
                outpatientAnalysisMapper.selectPrescribeDispNumSum(Util.getParamMapByStartAndEndDate(startDate, endDate)
                );
        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (OutpatientAnalysisDTO outpatientAnalysisDTO : outpatientAnalysisDTOS) {
            xAxis.add(outpatientAnalysisDTO.getHospitalName());
            yAxis.add(outpatientAnalysisDTO.getPrescribeDispNumSum());

        }
        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);
        return dataObj;
    }

    /**
     * 专家门诊和
     * @param startDate
     * @param endDate
     * @return
     */
    public JSONObject getDispProfessionNumSumEchartsData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();
        List<OutpatientAnalysisDTO> outpatientAnalysisDTOS =
                outpatientAnalysisMapper.selectDispProfessionNumSum(Util.getParamMapByStartAndEndDate(startDate, endDate)
                );
        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (OutpatientAnalysisDTO outpatientAnalysisDTO : outpatientAnalysisDTOS) {
            xAxis.add(outpatientAnalysisDTO.getHospitalName());
            if (outpatientAnalysisDTO.getDispProfessionNumSum()!=null){
                yAxis.add(outpatientAnalysisDTO.getDispProfessionNumSum());
            }else {
                yAxis.add(0);
            }


        }
        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);
        return dataObj;
    }

    /**
     *
     * @Description: 医师平均担负门急诊人次
     *
     * @param:
     * @return:
     */
    public JSONObject getDocAvgOeManTimeEchartData(String startDate, String endDate) {

        List<OutpatientAnalysisDTO> outpatientAnalysisDTOList =
                outpatientAnalysisMapper.selectDocAvgOeManTimeByDate(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (OutpatientAnalysisDTO data : outpatientAnalysisDTOList) {
            xAxis.add(data.getHospitalName());
            if(data.getDocAvgOeManTime()!=null){
                yAxis.add(data.getDocAvgOeManTime());
            }else {
                yAxis.add(0);
            }
        }
        return new JSONObject(){
            {
                put("xAxis", xAxis);
                put("yAxis", yAxis);
            }
        };
    }

    /**
     * 门诊费用占比图
     * @param startDate
     * @param endDate
     * @return
     */
    public JSONObject getDispFeeProportionEchartPieData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();

        OutpatientAnalysisDTO outpatientAnalysisDTO =
                outpatientAnalysisMapper.selectDispFeeProportion(Util.getParamMapByStartAndEndDate(startDate, endDate));

        // 列表转为JSONArray
        JSONArray legend = (JSONArray) JSONArray.toJSON(fee);

        Map<String,Object> yAxisMap = null;
        JSONArray yAxis = new JSONArray();

        List<Object> feeList = new ArrayList<Object>(){
            {
                add(outpatientAnalysisDTO.getIncomeDisp());
                add(outpatientAnalysisDTO.getIncomePhysicDisp());
                add(outpatientAnalysisDTO.getIncomeMaterialDisp());
                add(outpatientAnalysisDTO.getIncomeTreatDisp());
                add(outpatientAnalysisDTO.getIncomeCheckDisp());
                add(outpatientAnalysisDTO.getIncomeLaboratoryDisp());
                add(outpatientAnalysisDTO.getIncomeOperationDisp());
                add(outpatientAnalysisDTO.getIncomeOperationDisp());
                add(outpatientAnalysisDTO.getIncomeBedDisp());
            }
        };

        for(int i=0;i<feeList.size();i++){
            yAxisMap = new HashMap<>();
            yAxisMap.put("name",fee[i]);
            yAxisMap.put("value",feeList.get(i));
            yAxis.add(yAxisMap);
        }
        dataObj.put("legend", legend);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }
}
