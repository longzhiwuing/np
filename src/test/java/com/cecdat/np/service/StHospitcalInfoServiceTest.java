package com.cecdat.np.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cecdat.np.base.BaseWebTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/25
 * Time: 19:17
 */
@Slf4j
public class StHospitcalInfoServiceTest extends BaseWebTest{

    @Autowired
    StHospitcalInfoService stHospitcalInfoService;

    @Autowired
    TotalCostService totalCostService;

    @Test
    public void test() {
//        int count = stHospitcalInfoService.selectCount(new EntityWrapper<>());
//
//        log.info("count:{}", count);

    }
}