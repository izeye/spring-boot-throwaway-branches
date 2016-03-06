package com.izeye.throwaway.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.sql.DataSource;

/**
 * Created by izeye on 15. 2. 22..
 */
@Configuration
@EnableConfigurationProperties(MyBatisProperties.class)
// FIXME: See https://github.com/mybatis/spring/issues/58
@Lazy
public class PersistenceConfig {

	@Autowired
	private MyBatisProperties myBatisProperties;

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(myBatisProperties.getConfigLocation());
		sqlSessionFactoryBean.setMapperLocations(myBatisProperties.getMapperLocations());
		sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
		return sqlSessionFactoryBean;
	}

	@Bean
	public SqlSession sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
