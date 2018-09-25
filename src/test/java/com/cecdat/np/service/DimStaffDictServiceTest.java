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
 * Time: 9:17
 */
@Slf4j
public class DimStaffDictServiceTest extends BaseWebTest{

    @Autowired
    DimStaffDictService dimStaffDictService;

    @Test
    public void test() {
        int count = dimStaffDictService.selectCount(new EntityWrapper<>());
        log.info("count:{}", count);
    }
}