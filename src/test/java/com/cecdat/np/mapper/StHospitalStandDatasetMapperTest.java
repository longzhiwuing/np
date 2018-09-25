package com.cecdat.np.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.cecdat.np.base.BaseWebTest;
import com.cecdat.np.entity.StHospitalDataset;
import com.cecdat.np.entity.StHospitalStandardDataset;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/7/1
 * Time: 20:50
 */
@Slf4j
public class StHospitalStandDatasetMapperTest extends BaseWebTest{

    @Autowired
    StHospitalStandDatasetMapper stHospitalStandDatasetMapper;

    @Test
    public void selectStandDataSet() {
        String id = "4525";
        Page<StHospitalDataset> page = new Page<StHospitalDataset>(1, 10);
        String searchText = "中电";
        List<StHospitalStandardDataset> stHospitalDatasets = stHospitalStandDatasetMapper.selectStandDataSet(page,searchText);

        log.info("count:{}", stHospitalDatasets.size());
    }
}