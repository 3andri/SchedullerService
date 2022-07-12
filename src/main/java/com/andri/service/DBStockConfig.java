package com.andri.service;

import java.util.Objects;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "stockEntityManagerFactory", transactionManagerRef = "stockTransactionManager", basePackages = {
		"com.andri.service.schedule.Stock.Repo" })
public class DBStockConfig {
	@Primary
	@Bean
	@ConfigurationProperties("spring.datasource1")
	public DataSourceProperties stockDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean
	public DataSource stockDataSource() {
		return stockDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean stockEntityManagerFactory(
			@Qualifier("stockDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(stockDataSource()).packages("com.andri.service.schedule.Stock.model").build();
	}

	@Primary
	@Bean
	public PlatformTransactionManager stockTransactionManager(
			@Qualifier("stockEntityManagerFactory") LocalContainerEntityManagerFactoryBean stockEntityManagerFactory) {
		return new JpaTransactionManager(Objects.requireNonNull(stockEntityManagerFactory.getObject()));
	}
}
