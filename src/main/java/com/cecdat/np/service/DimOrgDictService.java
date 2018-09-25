package com.cecdat.np.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cecdat.np.entity.DimOrgDict;
import com.cecdat.np.mapper.DimOrgDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 机构字典 服务实现类
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-28
 */
@Service
public class DimOrgDictService extends ServiceImpl<DimOrgDictMapper, DimOrgDict>{

    @Autowired
    private DimOrgDictMapper orgDictMapper;

    String getOrgNameByOrgCode(String orgCode) {

        DimOrgDict dimOrgDict = orgDictMapper.selectByOrgCode(orgCode);
        if(dimOrgDict != null) {
            return  dimOrgDict.getOrgName();
        } else {
            return "";
        }
    }


}
