package com.tsystems.coe.techunicorn.config;

import java.util.function.Supplier;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.tsystems.coe.techunicorn.properties.EntityManagerProperties;
import com.tsystems.coe.techunicorn.repository.BaseRepositoryImpl;
import com.tsystems.coe.techunicorn.repository.ReadOnlyRepository;

/**
 * Datasource configuration class.
 */
@Configuration
@ConditionalOnProperty("spring.datasource.url")
@EnableJpaRepositories(basePackages = "com.tsystems.coe.techunicorn.repository",
		excludeFilters = @ComponentScan.Filter(ReadOnlyRepository.class),
		entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager",
		repositoryBaseClass = BaseRepositoryImpl.class)
@EnableJpaAuditing
public class DatasourceConfig {

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource")
	@ConditionalOnProperty("spring.datasource.url")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.entitymanager")
	@ConditionalOnProperty("spring.datasource.url")
	public EntityManagerProperties entityManagerProperties() {
		return new EntityManagerProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.jpa.hibernate")
	public HibernateProperties hibernateProperties() {
		return new HibernateProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.jpa")
	public JpaProperties jpaProperties() {
		return new JpaProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource")
	@ConditionalOnProperty("spring.datasource.url")
	public DataSource dataSource() {
		return dataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	@Primary
	@ConditionalOnProperty("spring.datasource.url")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource,
			@Qualifier("entityManagerProperties") EntityManagerProperties entityManagerProperties) {
		Supplier<String> ddlAutoSupplier = () -> "none";
		HibernateSettings settings = new HibernateSettings().ddlAuto(ddlAutoSupplier);
		return builder.dataSource(dataSource).packages(entityManagerProperties.getPackagesToScan())
				.persistenceUnit("main")
				.properties(
						hibernateProperties().determineHibernateProperties(jpaProperties().getProperties(), settings))
				.build();
	}

	@Bean
	@Primary
	@ConditionalOnProperty("spring.datasource.url")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource,
			@Qualifier("entityManagerProperties") EntityManagerProperties entityManagerProperties) {
		return new JpaTransactionManager(
				entityManagerFactory(builder, dataSource, entityManagerProperties).getObject());
	}

}
