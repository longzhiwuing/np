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
 * Date: 2018/7/17
 * Time: 19:29
 */
@Slf4j
public class PermissionServiceTest extends BaseWebTest{

    @Autowired
    PermissionService permissionService;

    @Test
    public void test() {
        int count = permissionService.selectCount(new EntityWrapper<>());
        log.info("count:{}", count);
    }

}