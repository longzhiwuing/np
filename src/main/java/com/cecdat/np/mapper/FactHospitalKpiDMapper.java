package com.cecdat.np.mapper;

import com.cecdat.np.dto.HospitalResourseData;
import com.cecdat.np.entity.FactHospitalKpiD;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 医院指标汇总日表 Mapper 接口
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-25
 */
@Mapper
@Component
public interface FactHospitalKpiDMapper extends BaseMapper<FactHospitalKpiD> {

    List<HashMap> countByHospitalCodeForCharts();
//    HashMap countByHospitalCodeForCharts();

}
