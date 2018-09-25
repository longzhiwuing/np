package com.cecdat.np.mapper;

import com.cecdat.np.dto.HospitalData;
import com.cecdat.np.dto.TotalCostData;
import com.cecdat.np.entity.FactResiOutKpiD;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 全院费用Mapper
 * @author jcl
 * @since 2018-06-26
 */
@Mapper
@Component
public interface TotalCostMapper extends SuperMapper<FactResiOutKpiD> {
    //查询每家医院药费占比
    List<TotalCostData> queryPhysicByTotalEchart(Map paramMap);
    //查询每家医院耗材费占比
    List<TotalCostData> queryMaterialByTotalEchart(Map paramMap);
    //查询每家医院检查费占比
    List<TotalCostData> queryCheckByTotalEchart(Map paramMap);
    //查询每家医院化验费占比
    List<TotalCostData> queryLaboratoryByTotalEchart(Map paramMap);
    //查询所有医院费用占比
    TotalCostData queryTotalCostEchartPie(Map paramMap);

    /**
     *
     * @Description: 计算查询结果总数。
     *
     */
    Integer selectCount(Map paramMap);

    /**
     *
     * @Description: 全院费用分析表格。
     *
     */
    List<TotalCostData> queryTotalCostTableByDate(Map paramMap);

}
