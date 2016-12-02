package com.example.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class FlywayConfig {
	@Bean(initMethod = "migrate")
	Flyway flyway() {
		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setLocations("classpath:db/migration");
		flyway.setDataSource(dataSource());
		return flyway;
	}

	@Bean
	@DependsOn("flyway")
	EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		// other configurations
		return bean.getObject();
	}

	@Bean
	DataSource dataSource() {
		DataSource dataSource = new BasicDataSource();
		// data source configuration
		return dataSource;
	}
}
