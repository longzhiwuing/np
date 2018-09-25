package com.cecdat.np.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cecdat.np.base.BaseWebTest;
import com.cecdat.np.dto.HospitalData;
import com.cecdat.np.entity.DemoData;
import com.cecdat.np.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/19
 * Time: 18:04
 */
@Slf4j
public class DemoDataMapperTest extends BaseWebTest {
    @Autowired
    DemoDataMapper demoDataMapper;
    @Autowired
    HospitalMapper hospitalMapper;

    @Test
    public void test() {
        List<DemoData> demoData = demoDataMapper.selectPage(
                new Page<DemoData>(1, 5),
                new EntityWrapper<DemoData>()
        );

        log.info("demoData:{}", demoData.size());
    }

}