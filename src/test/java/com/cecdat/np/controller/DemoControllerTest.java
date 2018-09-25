package com.cecdat.np.controller;

import com.cecdat.np.base.BaseWebTest;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/19
 * Time: 15:45
 */
@Slf4j
public class DemoControllerTest extends BaseWebTest{

    @Test
    public void tableData() throws Exception{
        String content = getMvc().perform(get("/api/demo/table.json?pageNumber=1&pageSize=10&sortOrder=asc")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(13))
                .andExpect(jsonPath("$.rows", Matchers.hasSize(10)))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        log.info("content:{}",content);
    }

}