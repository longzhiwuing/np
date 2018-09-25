package com.cecdat.np.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.dto.BootStrapTableData;
import com.cecdat.np.dto.HospitalResourseData;
import com.cecdat.np.dto.TotalCostData;
import com.cecdat.np.mapper.HospitalCostMapper;
import com.cecdat.np.mapper.HospitalResourseMapper;
import com.cecdat.np.mapper.TotalCostMapper;
import com.cecdat.np.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 医院资源分析,床位明细Service
 * @author: liuzihao@cecdat.com
 * Date: 2018/6/25
 * Time: 23:42
 */
@Service
@Slf4j
public class HospitalResourseService {

    @Autowired
    HospitalResourseMapper hospitalResourseMapper;


    /**
     * @Description: 医生数
     * @param:
     * @return:
     */
    public JSONObject getDoctorCountEchartData(String startDate, String endDate) {
        JSONObject dataObj = new JSONObject();

        List<HospitalResourseData> hospitalResourseDataList =
                hospitalResourseMapper.selectDoctorCountByDate(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalResourseData data : hospitalResourseDataList) {
            if(data != null) {
                xAxis.add(data.getHospitalName());
                yAxis.add(data.getDoctorCount());
            }
        }
        dataObj.put("xAxis", xAxis);
        dataObj.put("yAxis", yAxis);
        log.info(dataObj.toJSONString());
        return dataObj;
    }

    /**
     * @Description: 护士数
     * @param:
     * @return:
     */
    public JSONObject getNurseCountEchartData(String startDate, String endDate) {

        List<HospitalResourseData> hospitalResourseDataList =
                hospitalResourseMapper.selectNurseCountByDate(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalResourseData data : hospitalResourseDataList) {
            if(data != null) {
                xAxis.add(data.getHospitalName());
                yAxis.add(data.getNurseCount());
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
     *
     * @Description: 医生护士比
     *
     * @param:
     * @return:
     */
    public JSONObject getDocNurseRatioEchartData(String startDate, String endDate) {

        List<HospitalResourseData> hospitalResourseDataList =
                hospitalResourseMapper.selectDocNurseRatioByDate(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalResourseData data : hospitalResourseDataList) {
            if(data != null){
                xAxis.add(data.getHospitalName());
                yAxis.add(data.getDocNurseRatio());
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
     *
     * @Description: 医生床位比
     *
     * @param:
     * @return:
     */
    public JSONObject getDocBedRatioEchartData(String startDate, String endDate) {

        List<HospitalResourseData> hospitalResourseDataList =
                hospitalResourseMapper.selectDocBedRatioByDate(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalResourseData data : hospitalResourseDataList) {
            if(data != null) {
                xAxis.add(data.getHospitalName());
                yAxis.add(data.getDocBedRatio());
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
     *
     * @Description: 门急诊人次
     *
     * @param:
     * @return:
     */
    public JSONObject getOEManTimeEchartData(String startDate, String endDate) {

        List<HospitalResourseData> hospitalResourseDataList =
                hospitalResourseMapper.selectOEManTimeByDate(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalResourseData data : hospitalResourseDataList) {
            if(data != null) {
                xAxis.add(data.getHospitalName());
                yAxis.add(data.getOeManTime());
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
     *
     * @Description: 平均开放床位数
     *
     * @param:
     * @return:
     */
    public JSONObject getBedOpenNumEchartData(String startDate, String endDate) {

        List<HospitalResourseData> hospitalResourseDataList =
                hospitalResourseMapper.selectBedOpenNumByDate(Util.getStringParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalResourseData data : hospitalResourseDataList) {
            if(data != null) {
                xAxis.add(data.getHospitalName());
                yAxis.add(data.getBedOpenNum());
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
     *
     * @Description: 实际开放总床日数
     *
     * @param:
     * @return:
     */
    public JSONObject getBedOpenCountEchartData(String startDate, String endDate) {

        List<HospitalResourseData> hospitalResourseDataList =
                hospitalResourseMapper.selectBedOpenCountByDate(Util.getStringParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalResourseData data : hospitalResourseDataList) {
            if(data != null) {
                xAxis.add(data.getHospitalName());
                yAxis.add(data.getBedOpenCount());
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
     *
     * @Description: 医师平均担负门急诊人次
     *
     * @param:
     * @return:
     */
    public JSONObject getDocAvgOeManTimeEchartData(String startDate, String endDate) {

        List<HospitalResourseData> hospitalResourseDataList =
                hospitalResourseMapper.selectDocAvgOeManTimeByDate(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalResourseData data : hospitalResourseDataList) {
            if(data != null) {
                xAxis.add(data.getHospitalName());
                yAxis.add(data.getDocAvgOeManTime());
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
     *
     * @Description: 出院者床日数
     *
     * @param:
     * @return:
     */
    public JSONObject getOutBedNumEchartData(String startDate, String endDate) {

        List<HospitalResourseData> hospitalResourseDataList =
                hospitalResourseMapper.selectOutBedNumByDate(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalResourseData data : hospitalResourseDataList) {
            if(data != null) {
                xAxis.add(data.getHospitalName());
                yAxis.add(data.getDocAvgOeManTime());
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
     *
     * @Description: 医师平均担负住院床日数
     *
     * @param:
     * @return:
     */
    public JSONObject getDocLoadBedCountEchartData(String startDate, String endDate) {

        List<HospitalResourseData> hospitalResourseDataList =
                hospitalResourseMapper.selectDocLoadBedCountByDate(Util.getParamMapByStartAndEndDate(startDate, endDate));

        JSONArray xAxis = new JSONArray();
        JSONArray yAxis = new JSONArray();
        for (HospitalResourseData data : hospitalResourseDataList) {
            if(data != null) {
                xAxis.add(data.getHospitalName());
                yAxis.add(data.getDocAvgOeManTime());
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
     *
     * @Description: 全院费用分析表格
     *
     * @param:
     * @return:
     */
    public BootStrapTableData<TotalCostData> getTotalCostTableData(String startDate, String endDate, int pageSize, int pageNumber, String sortName, String sortOrder, String searchText) {
        BootStrapTableData<TotalCostData> data = new BootStrapTableData<>();

        List<TotalCostData> totalCostDataList = hospitalResourseMapper.queryTotalCostTableByDate(Util.getParamMapOfBootStrapTable(startDate, endDate,pageSize,pageNumber,sortName,sortOrder,searchText));

        Integer count = totalCostDataList.size();
        data.setTotal(count);
        /*
            将TotalCostData中不需要的字段剔除
         */
        List<Object> returnList = new ArrayList<>();
        data.setRows(totalCostDataList);
        return data;
    }

}
