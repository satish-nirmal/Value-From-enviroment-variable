package com.verivaxx.app.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	@Bean
	public DataSource getDataSource() {
		Map<String, String> env = System.getenv();
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.postgresql.Driver");

		dataSourceBuilder.url(env.get("SPRING_DATASOURCE_URL"));
		dataSourceBuilder.username(env.get("SPRING_DATASOURCE_USERNAME"));
		dataSourceBuilder.password(env.get("SPRING_DATASOURCE_PASSWORD"));
		
//		dataSourceBuilder.url("jdbc:postgresql://10.0.1.136:5432/verivaxdb?createDatabaseIfNotExist=true");
//		dataSourceBuilder.username("satish");
//		dataSourceBuilder.password("heaptrace");

		return dataSourceBuilder.build();
	}
}
