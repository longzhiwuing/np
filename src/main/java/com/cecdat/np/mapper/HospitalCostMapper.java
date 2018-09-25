package com.cecdat.np.mapper;

import com.cecdat.np.dto.HospitalCostData;
import com.cecdat.np.dto.HospitalData;
import com.cecdat.np.entity.FactResiOutKpiD;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 住院费用Mapper
 * @author jcl
 * @since 2018-06-26
 */
@Mapper
@Component
public interface HospitalCostMapper extends SuperMapper<FactResiOutKpiD> {

    //查询各家医院住院人均费用
    List<HospitalCostData> queryPeopleAverageCostEchart(Map paramMap);
    //查询各家医院住院药费占比
    List<HospitalCostData> queryPhysicByHospitalCostEchart(Map paramMap);
    //查询各家医院住院耗材费占比
    List<HospitalCostData> queryMaterialByHospitalCostEchart(Map paramMap);
    //查询各家医院住院检查费占比
    List<HospitalCostData> queryCheckByHospitalCostEchart(Map paramMap);
    //查询各家医院住院化验费占比
    List<HospitalCostData> queryLaboratoryByHospitalCostEchart(Map paramMap);

    /**
     *
     * @Description: 根据页面的日期条件,获得住院费用占比图。
     *
     */
    HospitalCostData selectResFeeProportionByDate(Map paramMap);

}
