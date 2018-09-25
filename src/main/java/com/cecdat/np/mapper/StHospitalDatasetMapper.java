package com.cecdat.np.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cecdat.np.entity.StHospitalDataset;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * st_hospital_dataset Mapper 接口
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-29
 */
@Mapper
@Repository
public interface StHospitalDatasetMapper extends BaseMapper<StHospitalDataset> {
}
