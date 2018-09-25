package com.cecdat.np.mapper;

import com.cecdat.np.entity.DemoData;
import org.apache.ibatis.annotations.Mapper;

/**
 * User 表数据库控制层接口
 */
@Mapper
public interface DemoDataMapper extends SuperMapper<DemoData> {

}