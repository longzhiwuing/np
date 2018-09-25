package com.cecdat.np.mapper;

import com.cecdat.np.entity.DataResourceBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by roy on 2018/6/30.
 */
@Mapper
@Component
public interface DataResourceBaseInfoMapper extends SuperMapper<DataResourceBaseInfo>{

    HashMap getResourceData();

}
