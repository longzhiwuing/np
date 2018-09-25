package com.cecdat.np.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cecdat.np.dto.BootStrapTableData;
import com.cecdat.np.entity.DemoData;
import com.cecdat.np.entity.StEcologicalDataset;
import com.cecdat.np.mapper.StEcologicalDatasetMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * st_ecological_dataset 

2018年6月28日 星期四【新增】 服务实现类
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-28
 */
@Service
public class StEcologicalDatasetService extends ServiceImpl<StEcologicalDatasetMapper, StEcologicalDataset>{

    @Autowired
    private StEcologicalDatasetMapper stEcologicalDatasetMapper;

    public BootStrapTableData<StEcologicalDataset> getTableData(int pageSize, int pageNumber, String sortName, String sortOrder, String searchText) {
        BootStrapTableData<StEcologicalDataset> data = new BootStrapTableData<>();
        Integer count = stEcologicalDatasetMapper.selectCount(new EntityWrapper<>());

        Page<StEcologicalDataset> page = new Page<>(pageNumber, pageSize);
        Wrapper<StEcologicalDataset> ew = new EntityWrapper<StEcologicalDataset>();
        if (StringUtils.isNotEmpty(sortName)&&StringUtils.isNotEmpty(sortOrder)) {
            ew = ew.orderBy(sortName,sortOrder.equalsIgnoreCase("asc"));
        }
        if (StringUtils.isNotEmpty(searchText)) {
            ew.like("medical_org_name", searchText);
            ew.or();
            ew.like("de_code", searchText);
            ew.or();
            ew.like("de_innercode", searchText);
            ew.or();
            ew.like("de_define", searchText);
            ew.or();
            ew.like("de_type", searchText);
            ew.or();
            ew.like("de_format", searchText);
            ew.or();
            ew.like("de_desc", searchText);

        }
        ew.isNotNull("de_code");
        ew.isNotNull("de_innercode");
        List<StEcologicalDataset> demoData = stEcologicalDatasetMapper.selectPage(page,ew);

        data.setTotal(count);
        data.setRows(demoData);
        return data;
    }

}
