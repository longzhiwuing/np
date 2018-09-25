package com.cecdat.np.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.cecdat.np.entity.StEcologicalDataset;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * st_ecological_dataset 

2018年6月28日 星期四【新增】 Mapper 接口
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-28
 */
@Mapper
@Repository
public interface StEcologicalDatasetMapper extends BaseMapper<StEcologicalDataset> {
    Page<StEcologicalDataset> selectDataSetPage(Page<StEcologicalDataset> page);

}
