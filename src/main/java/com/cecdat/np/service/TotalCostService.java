package com.cecdat.np.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.dto.HospitalCostData;
import com.cecdat.np.dto.MedicalRateData;
import com.cecdat.np.dto.OutpatientAnalysisDTO;
import com.cecdat.np.dto.TotalCostData;
import com.cecdat.np.mapper.HospitalCostMapper;
import com.cecdat.np.mapper.OutpatientAnalysisMapper;
import com.cecdat.np.mapper.TotalCostMapper;
import com.cecdat.np.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全院费用Service
 * @author: jcl
 * Date: 2018/06/28
 * Time: 10:31
 */
@Service
@Slf4j
public class TotalCostService {

    @Autowired
    private TotalCostMapper totalCostMapper;
    @Autowired
    OutpatientAnalysisMapper outpatientAnalysisMapper;
    @Autowired
    private HospitalCostMapper hospitalCostMapper;


    public JSONObject getHosFeeRate(String InOrOut) {
        String startDate = "1970-01-01";
        String endDate = Util.getDateTimeWithDate(new Date());
        JSONObject jsonObject = new JSONObject();
        JSONObject series = new JSONObject();
        JSONArray xAxis = new JSONArray();
        JSONArray arr1 = new JSONArray();
        if ("out".equals(InOrOut)) {
            List<HospitalCostData> hospitalCostEchartOfFHKD = hospitalCostMapper.queryPeopleAverageCostEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));
            List<MedicalRateData> rateDataList = new ArrayList<>();
            for (HospitalCostData data : hospitalCostEchartOfFHKD) {
                if (data != null) {
                    MedicalRateData medicalRateData = new MedicalRateData();
                    medicalRateData.setHosName(data.getHospitalName());
                    if (data.getOutNum()  != 0) {
                        double rate = new BigDecimal((float) data.getIncomeResi()/data.getOutNum()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        medicalRateData.setRate(rate);
                    } else {
                        medicalRateData.setRate(0);
                    }
                    rateDataList.add(medicalRateData);
                }
            }
            rateDataList = rateDataList.stream().limit(10).sorted(Comparator.comparingDouble(MedicalRateData::getRate).reversed()).collect(Collectors.toList());
            for (MedicalRateData rateData : rateDataList) {
                xAxis.add(rateData.getHosName());
                arr1.add(rateData.getRate());
            }
        } else if ("in".equals(InOrOut)) {
            List<OutpatientAnalysisDTO> outpatientAnalysisDTOS = outpatientAnalysisMapper.selectAvgFeeByPeople(Util.getParamMapByStartAndEndDate(startDate, endDate));
            List<MedicalRateData> rateDataList = new ArrayList<>();
            for (OutpatientAnalysisDTO costData : outpatientAnalysisDTOS) {
                if (costData != null) {
                    MedicalRateData medicalRateData = new MedicalRateData();
                    medicalRateData.setHosName(costData.getHospitalName());
                    medicalRateData.setRate(costData.getAvgFeeByPeople());
                    rateDataList.add(medicalRateData);
                }
            }
            rateDataList = rateDataList.stream().limit(10).sorted(Comparator.comparingDouble(MedicalRateData::getRate).reversed()).collect(Collectors.toList());
            for (MedicalRateData rateData : rateDataList) {
                xAxis.add(rateData.getHosName());
                arr1.add(rateData.getRate());
            }

        }
        series.put("in", arr1);
        jsonObject.put("yAxis", xAxis);
        jsonObject.put("series", series);
        return jsonObject;
    }

    //根据传入起止时间，查询各家医院药费占比，返回Echart图数据
    public JSONObject getEchartDataOfPhysicByTotal(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();

        List<TotalCostData> totalCostEchart = totalCostMapper.queryPhysicByTotalEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        DecimalFormat df = new DecimalFormat("0.00");
        for (TotalCostData data : totalCostEchart) {
            xAxis.add(data.getHospitalName());
            if (data.getIncomeTotal() != 0) {
                yAxis.add(df.format((100 * data.getIncomePhysic()) / data.getIncomeTotal()));
            } else {
                yAxis.add(0);
            }
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院耗材费占比，返回Echart图数据
    public JSONObject getEchartDataOfMaterialByTotal(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();

        List<TotalCostData> totalCostEchart = totalCostMapper.queryMaterialByTotalEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        DecimalFormat df = new DecimalFormat("0.00");
        for (TotalCostData data : totalCostEchart) {
            xAxis.add(data.getHospitalName());
            if (data.getIncomeTotal() != 0) {
                yAxis.add(df.format((100 * data.getIncomeMaterial()) / data.getIncomeTotal()));
            } else {
                yAxis.add(0);
            }
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院检查费占比，返回Echart图数据
    public JSONObject getEchartDataOfCheckByTotal(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();

        List<TotalCostData> totalCostEchart = totalCostMapper.queryCheckByTotalEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        DecimalFormat df = new DecimalFormat("0.00");
        for (TotalCostData data : totalCostEchart) {
            xAxis.add(data.getHospitalName());
            if (data.getIncomeTotal() != 0) {
                yAxis.add(df.format((100 * data.getIncomeCheck()) / data.getIncomeTotal()));
            } else {
                yAxis.add(0);
            }
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询各家医院化验费占比，返回Echart图数据
    public JSONObject getEchartDataOfLaboratoryByTotal(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();

        List<TotalCostData> totalCostEchart = totalCostMapper.queryLaboratoryByTotalEchart(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();

        DecimalFormat df = new DecimalFormat("0.00");
        for (TotalCostData data : totalCostEchart) {
            xAxis.add(data.getHospitalName());
            if (data.getIncomeTotal() != 0) {
                yAxis.add(df.format((100 * data.getIncomeLaboratory()) / data.getIncomeTotal()));
            } else {
                yAxis.add(0);
            }
        }

        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);

        return dataObj;
    }

    //根据传入起止时间，查询所有医院各项费用占比，返回Echart图数据
    public JSONObject getEchartPieDataTotalCost(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();

        TotalCostData totalCostData = totalCostMapper.queryTotalCostEchartPie(Util.getParamMapByStartAndEndDate(startDate, endDate));

        dataObj.put("incomePhysic", totalCostData.getIncomePhysic());
        dataObj.put("incomeMaterial", totalCostData.getIncomeMaterial());
        dataObj.put("incomeTreat", totalCostData.getIncomeTreat());
        dataObj.put("incomeCheck", totalCostData.getIncomeCheck());
        dataObj.put("incomeLaboratory", totalCostData.getIncomeLaboratory());
        dataObj.put("incomeOperation", totalCostData.getIncomeOperation());
        dataObj.put("incomeOther", totalCostData.getIncomeOther());
        dataObj.put("incomeBed", totalCostData.getIncomeBed());

        return dataObj;
    }

}
