package com.cecdat.np.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cecdat.np.dto.BootStrapTableData;
import com.cecdat.np.entity.StHospitalDataset;
import com.cecdat.np.mapper.StHospitalDatasetMapper;
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
public class StHospitalDatasetService extends ServiceImpl<StHospitalDatasetMapper, StHospitalDataset>{

    @Autowired
    private StHospitalDatasetMapper stHospitalDatasetMapper;

    public BootStrapTableData<StHospitalDataset> getTableData(int pageSize, int pageNumber, String sortName, String sortOrder, String searchText) {
        BootStrapTableData<StHospitalDataset> data = new BootStrapTableData<>();
        Integer count = stHospitalDatasetMapper.selectCount(new EntityWrapper<>());

        Page<StHospitalDataset> page = new Page<>(pageNumber, pageSize);
        Wrapper<StHospitalDataset> ew = new EntityWrapper<StHospitalDataset>();
        if (StringUtils.isNotEmpty(sortName)&&StringUtils.isNotEmpty(sortOrder)) {
            ew = ew.orderBy(sortName,sortOrder.equalsIgnoreCase("asc"));
        }
        if (StringUtils.isNotEmpty(searchText)) {
            ew.like("dataset_name", searchText);
            ew.or();
            ew.like("business_system", searchText);
            ew.or();
            ew.like("application_theme", searchText);
            ew.or();
            ew.like("medical_org_name", searchText);
        }
        List<StHospitalDataset> demoData = stHospitalDatasetMapper.selectPage(page,ew);

        data.setTotal(count);
        data.setRows(demoData);
        return data;
    }

}
