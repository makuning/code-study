package org.example.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;

/**
 * @author makun
 * @project spring
 * @description Mybatis配置类
 * @date 2022/12/08 21:00:19
 * version 1.0
 */
public class MybatisConfig {
    // 在属性中填写的应用类型参数，Spring会帮忙注入
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置实体类的包
        sqlSessionFactoryBean.setTypeAliasesPackage("org.example.domain");
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 设置sql映射的包
        mapperScannerConfigurer.setBasePackage("org.example.dao");
        return mapperScannerConfigurer;
    }
}
