package com.cecdat.np.mapper;

import com.cecdat.np.dto.HospitalResourseData;
import com.cecdat.np.dto.TotalCostData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Description: 医院资源分析,床位明细
 *
 * @author: liuzihao@cecdat.com
 * Date: 2018/6/26
 * Time: 9:50
 */
@Mapper
public interface HospitalResourseMapper {

    /**
     *
     * @Description: 根据页面的日期条件,获得医院人数
     *
     */
    List<HospitalResourseData> selectDoctorCountByDate(Map paramMap);

    /**
     *
     * @Description: 根据页面的日期条件,获得护士人数
     *
     */
    List<HospitalResourseData> selectNurseCountByDate(Map paramMap);

    /**
     *
     * @Description: 根据页面的日期条件,获得医生护士比
     *
     */
    List<HospitalResourseData> selectDocNurseRatioByDate(Map paramMap);

    /**
     *
     * @Description: 根据页面的日期条件,获得医生床位比
     *
     */
    List<HospitalResourseData> selectDocBedRatioByDate(Map paramMap);

    /**
     *
     * @Description: 根据页面的日期条件,获得门急诊人次
     *
     */
    List<HospitalResourseData> selectOEManTimeByDate(Map paramMap);

    /**
     *
     * @Description: 根据页面的日期条件,获得平均开放床位数
     *
     */
    List<HospitalResourseData> selectBedOpenNumByDate(Map paramMap);

    /**
     *
     * @Description: 根据页面的日期条件,获得实际开放总床日数
     *
     */
    List<HospitalResourseData> selectBedOpenCountByDate(Map paramMap);

    /**
     *
     * @Description: 根据页面的日期条件,获得医师平均担负门急诊人次
     *
     */
    List<HospitalResourseData> selectDocAvgOeManTimeByDate(Map paramMap);

    /**
     *
     * @Description: 根据页面的日期条件,获得出院者床日数
     *
     */
    List<HospitalResourseData> selectOutBedNumByDate(Map paramMap);
    /**
     *
     * @Description: 根据页面的日期条件,获得医师平均担负住院床日数
     *
     */
    List<HospitalResourseData> selectDocLoadBedCountByDate(Map paramMap);
    /**
     *
     * @Description: 全院费用分析表格
     *
     */
    List<TotalCostData> queryTotalCostTableByDate(Map paramMap);
}
