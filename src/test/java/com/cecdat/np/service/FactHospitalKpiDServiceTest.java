package com.cecdat.np.service;

import com.cecdat.np.base.BaseWebTest;
import com.cecdat.np.mapper.FactHospitalKpiDMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/25
 * Time: 18:07
 */
@Slf4j
public class FactHospitalKpiDServiceTest extends BaseWebTest{

    @Autowired
    FactHospitalKpiDService factHospitalKpiDService;

    @Autowired
    FactHospitalKpiDMapper factHospitalKpiDMapper;

    @Test
    public void test1() {
        List<HashMap> hashMaps = factHospitalKpiDMapper.countByHospitalCodeForCharts();
    }

    @Test
    public void test() {
//        int count = factHospitalKpiDService.selectCount(new EntityWrapper<>());

//        log.info("count:{}", count);

        factHospitalKpiDService.HospitalCodeForCharts();
    }

}