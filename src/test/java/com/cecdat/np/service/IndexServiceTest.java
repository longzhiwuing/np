package com.cecdat.np.service;

import com.cecdat.np.base.BaseWebTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/26
 * Time: 10:48
 */
@Slf4j
public class IndexServiceTest extends BaseWebTest{

    @Autowired
    IndexService indexService;

    @Test
    public void getIndexData() {
        ResponseEntity indexData = new ResponseEntity(indexService.getIndexData(), HttpStatus.OK);
        log.info("indexData:{}",indexData);
    }

    @Test
    public void testApi() throws Exception{
        String content = getMvc().perform(get("/api/indexData.json")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hos").value(2))
                .andExpect(jsonPath("$.total").value(64645))
                .andExpect(jsonPath("$.metadata").value(0))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        log.info("content:{}",content);
    }
}