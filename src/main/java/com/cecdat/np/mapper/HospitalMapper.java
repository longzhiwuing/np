package com.cecdat.np.mapper;

import com.cecdat.np.dto.HospitalData;
import com.cecdat.np.dto.HospitalResourseData;
import com.cecdat.np.entity.FactResiOutKpiD;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 住院情况Mapper
 * @author jcl
 * @since 2018-06-26
 */
@Mapper
public interface HospitalMapper extends SuperMapper<FactResiOutKpiD> {

    //查询各家医院入院人次
    List<HospitalData> queryAdmissionNumEchart(Map paramMap);
    //查询各家医院出院人次
    List<HospitalData> queryOutNumEchart(Map paramMap);
    //查询各家医院手术人数
    List<HospitalData> queryOperatioRensEchart(Map paramMap);
    //查询各家医院死亡人数
    List<HospitalData> queryDeathRensEchart(Map paramMap);
    //查询各家医院床位使用率
    List<HospitalData> queryBedUseRatioEchart(Map paramMap);
    //查询各家医院出院者平均住院日
    List<HospitalData> queryAverageHospitalDayEchart(Map paramMap);
    //查询各家医院实际占用总床日数
    List<HospitalData> queryBedUseNumEchart(Map paramMap);

    /**
     *
     * @Description: 根据页面的日期条件,获得出院者床日数。
     *
     */
    List<HospitalData> selectOutBedNumByDate(Map paramMap);
    /**
     *
     * @Description: 根据页面的日期条件,获得医师平均担负住院床日数。
     *
     */
    List<HospitalData> selectDocLoadBedCountByDate(Map paramMap);
    /**
     * @Description: 日期条件查, 手术人次。
     */
    List<HospitalData> selectOperationNumberSum(Map paramMap);

    public List<HospitalData> queryHospitalTable(Map paramMap);

}
