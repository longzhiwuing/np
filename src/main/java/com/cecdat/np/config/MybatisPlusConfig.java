package com.cecdat.np.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 开启 PageHelper 的支持
        paginationInterceptor.setLocalPage(true);
        return paginationInterceptor;
    }

    @Bean
    public MetaObjectHandler metaObjectHandler(){
        return new FieldFillHandler();
    }

    /**
     * 注入主键生成器
     */
/*    @Bean
    public IKeyGenerator keyGenerator(){
        return new H2KeyGenerator();
    }*/

    /**
     * 注入sql注入器
     */
/*
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
*/

}
