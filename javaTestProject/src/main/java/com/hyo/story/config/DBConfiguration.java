package com.hyo.story.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.Getter;
import lombok.Setter;


@PropertySource("classpath:/application.properties")
@EnableTransactionManagement
@Configuration
public class DBConfiguration {

	@Autowired @Setter @Getter
    DataSource dataSource;
	
	 @Autowired
    JdbcTemplate jdbcTemplate;
	
	@Bean public PlatformTransactionManager transactionManager() throws Exception {
		return new DataSourceTransactionManager(getDataSource());
	}

	
}
