package com.cecdat.np.mapper;

import com.cecdat.np.entity.StHospitcalInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 记录医院的基本信息 Mapper 接口
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-25
 */
@Mapper
@Component
public interface StHospitcalInfoMapper extends BaseMapper<StHospitcalInfo> {

    int getTotalHospitalData();

    int getTopThreeHospitalData();

    List<HashMap> selectNameAndCount();

}
