package com.cecdat.np.mapper;

import com.cecdat.np.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * User 表数据库控制层接口
 */
@Mapper
public interface UserMapper extends SuperMapper<User> {

}