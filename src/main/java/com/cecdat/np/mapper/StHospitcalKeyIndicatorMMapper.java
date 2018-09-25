package com.cecdat.np.mapper;

import com.cecdat.np.entity.StHospitcalKeyIndicatorM;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 记录各家医院每月每个系统的数据量 Mapper 接口
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-25
 */
@Mapper
@Component
public interface StHospitcalKeyIndicatorMMapper extends BaseMapper<StHospitcalKeyIndicatorM> {

    List<Map<String, Object>> getSystemData();

    List<Map<String, Object>> getCollectionData();

    List<Map<String, Object>> getControlData();

    List<HashMap> selectSysNameAndCount();
}
