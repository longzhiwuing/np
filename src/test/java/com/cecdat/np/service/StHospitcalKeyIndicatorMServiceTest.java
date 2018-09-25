package com.cecdat.np.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cecdat.np.base.BaseWebTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/25
 * Time: 19:22
 */
@Slf4j
public class StHospitcalKeyIndicatorMServiceTest extends BaseWebTest {

    @Autowired
    StHospitcalKeyIndicatorMService stHospitcalKeyIndicatorMService;

    @Test
    public void test() {
        stHospitcalKeyIndicatorMService.getResourceData();

    }

    @Test
    public void testSum() {
        Wrapper wp = new EntityWrapper();
        wp.setSqlSelect("sum(other_count_month)");
        Object selectObj = stHospitcalKeyIndicatorMService.selectObj(wp);

        Double data = (Double)selectObj;

        Integer datai = data.intValue();

        log.info("data:{}",data);

        log.info("selectObj:{}",selectObj);


    }
}