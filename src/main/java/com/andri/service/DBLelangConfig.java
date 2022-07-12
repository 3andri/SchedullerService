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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "lelangEntityManagerFactory", transactionManagerRef = "lelangTransactionManager", basePackages = {
		"com.andri.service.lelang.Repo" })
public class DBLelangConfig {
	@Bean
	@ConfigurationProperties("spring.datasource2")
	public DataSourceProperties lelangDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	public DataSource lelangDataSource() {
		return lelangDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean lelangEntityManagerFactory(
			@Qualifier("lelangDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(lelangDataSource()).packages("com.andri.service.lelang.Model").build();
	}

	@Bean
	public PlatformTransactionManager lelangTransactionManager(
			@Qualifier("lelangEntityManagerFactory") LocalContainerEntityManagerFactoryBean lelangEntityManagerFactory) {
		return new JpaTransactionManager(Objects.requireNonNull(lelangEntityManagerFactory.getObject()));
	}
}
