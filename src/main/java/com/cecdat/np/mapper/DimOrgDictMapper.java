package com.cecdat.np.mapper;

import com.cecdat.np.entity.DimOrgDict;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 机构字典 Mapper 接口
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-28
 */
@Mapper
@Component
public interface DimOrgDictMapper extends BaseMapper<DimOrgDict> {

    DimOrgDict selectByOrgCode(String orgCode);

}
