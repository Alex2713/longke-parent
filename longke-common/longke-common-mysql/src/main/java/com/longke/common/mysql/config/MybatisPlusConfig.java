package com.longke.common.mysql.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MybatisPlus 配置
 * @author Alex
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {MybatisPlusConfig.BASE_MAPPER_PACKAGES, MybatisPlusConfig.BASE_DAO_PACKAGES})
public class MybatisPlusConfig {
    /**
     * BASE_MAPPER_PACKAGES
     *  Mybatis Plus 接口扫描
     */
    public static final String BASE_MAPPER_PACKAGES = "com.longke.mapper";
    /**
     * BASE_DAO_PACKAGES
     *  自定义接口扫描
     */
    public static final String BASE_DAO_PACKAGES = "com.longke.dao";

    /**
     * mybatisPlusInterceptor：
     * @return PaginationInterceptor
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor paginationInterceptor = new MybatisPlusInterceptor();

        // 乐观锁配置
        paginationInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());

        // 防止全表删除
        paginationInterceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());

        return paginationInterceptor;
    }
}
