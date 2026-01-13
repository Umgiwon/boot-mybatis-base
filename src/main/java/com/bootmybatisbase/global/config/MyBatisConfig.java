package com.bootmybatisbase.global.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * DB Cluster 이중화 작업에 의해서 DataSource를 직접 정의했기 때문에,
 * SqlSessionFactory가 직접 정의한 DataSource 를 사용할 수 있도록 정의
 */
@MapperScan(basePackages = "com.bootmybatisbase", sqlSessionFactoryRef = "sqlSessionFactory")
@Configuration
public class MyBatisConfig {

    /**
     * 반드시 Lazy + Routing DataSource 사용
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath:/mapper/**/*.xml")
        );

        return factoryBean.getObject();
    }

    /**
     * Spring TransactionManager와 MyBatis를 연결하는 포인트
     * 트랜잭션 동기화에 필수 설정
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
