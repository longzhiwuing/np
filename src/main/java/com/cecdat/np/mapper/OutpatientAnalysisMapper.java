package com.cecdat.np.mapper;

import com.cecdat.np.dto.HospitalResourseData;
import com.cecdat.np.dto.OutpatientAnalysisDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Create with IntelliJ IDEA.
 *
 * @author: hezhuangzhuang@cecdat.com
 * Date: 2018/6/26
 * Time: 10:18
 */
@Mapper
@Component
public interface OutpatientAnalysisMapper {
    /**
     * @Description: 日期条件查, 根据页面的日期条件, 获得门急诊人次
     */
    List<OutpatientAnalysisDTO> selectDispRegisterNumByTime(Map paramMap);

    /**
     * @Description: 日期条件查, 获得人均费用
     */
    List<OutpatientAnalysisDTO> selectAvgFeeByPeople(Map paramMap);

    /**
     * @Description: 日期条件查, 获得药占比
     */
    List<OutpatientAnalysisDTO> selectMedicineProportion(Map paramMap);

    /**
     * @Description: 日期条件查, , 耗材占比
     * checkFeeProportion
     */
    List<OutpatientAnalysisDTO> selectConsumablesProportion(Map paramMap);

    /**
     * @Description: 日期条件查, 检查费占比
     */
    List<OutpatientAnalysisDTO> selectCheckFeeProportion(Map paramMap);

    /**
     * @Description: 日期条件查, 化验费占比
     */
    List<OutpatientAnalysisDTO> selectLaboratoryFeeProportion(Map paramMap);

    /**
     * @Description: 日期条件查, 二次手术发生率
     */
    List<OutpatientAnalysisDTO> selectOperationRedoRensRatio(Map paramMap);

    /**
     * @Description: 日期条件查, 术后死亡率
     */
    List<OutpatientAnalysisDTO> selectOperationLastDeahProportion(Map paramMap);

    /**
     * @Description: 日期条件查, 门诊手术例数和
     */
    List<OutpatientAnalysisDTO> selectDisp0perationNumSum(Map paramMap);

    /**
     * @Description: 日期条件查,
     *
     */
    List<OutpatientAnalysisDTO> selectPrescribeDispNumSum(Map paramMap);

    /**
     * @Description: 日期条件查, 专家门诊和
     */
    List<OutpatientAnalysisDTO> selectDispProfessionNumSum(Map paramMap);


    /**
     *
     * @Description: 根据页面的日期条件,获得医师平均担负门急诊人次
     *
     */
    List<OutpatientAnalysisDTO> selectDocAvgOeManTimeByDate(Map paramMap);

    /**
     * @Description: 日期条件查, 费用占比图
     */
    OutpatientAnalysisDTO selectDispFeeProportion(Map paramMap);

}