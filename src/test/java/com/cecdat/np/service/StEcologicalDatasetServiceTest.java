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
 * Date: 2018/6/28
 * Time: 16:40
 */
@Slf4j
public class StEcologicalDatasetServiceTest extends BaseWebTest{

    @Autowired
    StEcologicalDatasetService stEcologicalDatasetService;

    @Test
    public void test() {
        int count = stEcologicalDatasetService.selectCount(new EntityWrapper<>());
        log.info("count:{}", count);
    }

}