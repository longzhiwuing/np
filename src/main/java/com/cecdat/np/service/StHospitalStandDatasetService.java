package com.cecdat.np.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cecdat.np.dto.BootStrapTableData;
import com.cecdat.np.entity.StStandDrs;
import com.cecdat.np.entity.StHospitalStandardDataset;
import com.cecdat.np.mapper.StHospitalStandDatasetMapper;
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
public class StHospitalStandDatasetService extends ServiceImpl<StHospitalStandDatasetMapper, StHospitalStandardDataset>{

    @Autowired
    private StHospitalStandDatasetMapper stHospitalStandDatasetMapper;

    /**
     * 获取数据集分页查询
     * @param pageSize
     * @param pageNumber
     * @param sortName
     * @param sortOrder
     * @param searchText
     * @return
     */
    public BootStrapTableData<StHospitalStandardDataset> getTableData(int pageSize,int pageNumber,String sortName,String sortOrder,String searchText) {
        BootStrapTableData<StHospitalStandardDataset> data = new BootStrapTableData<>();
        Page<StHospitalStandardDataset> page = new Page<StHospitalStandardDataset>(pageNumber, pageSize);
        List<StHospitalStandardDataset> stHospitalDatasets = stHospitalStandDatasetMapper.selectStandDataSet(page,searchText);

        int count = stHospitalStandDatasetMapper.selectCountStandDataSet(searchText);

        data.setTotal(count);
        data.setRows(stHospitalDatasets);
        return data;
    }


    /**
     * 根据数据集查询所有数据集下的数据元
     * @param pageSize
     * @param pageNumber
     * @param sortName
     * @param sortOrder
     * @param searchText
     * @param id
     * @return
     */
    public BootStrapTableData<StStandDrs> getTableDataById(int pageSize, int pageNumber, String sortName, String sortOrder, String searchText, String id) {
        BootStrapTableData<StStandDrs> data = new BootStrapTableData<>();
        Page<StStandDrs> page = new Page<StStandDrs>(pageNumber, pageSize);
        Integer count = stHospitalStandDatasetMapper.selectCountStandDataSetById(id);
        List<StStandDrs> stHospitalDatasets = stHospitalStandDatasetMapper.selectStandDataSetById(page, id);

        data.setTotal(count);
        data.setRows(stHospitalDatasets);
        return data;
    }


    /**
     * 获取数据集描述信息
     * @param id
     * @return
     */
    public StHospitalStandardDataset getDataInfo(String id) {
        List<StHospitalStandardDataset> stHospitalDatasets = stHospitalStandDatasetMapper.selectStandDataSetInfoById(id);
        return stHospitalDatasets.get(0);
    }
}
