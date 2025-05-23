package com.oraclejava.spring.sample1;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.oraclejava.spring.sample1.repo")
@ComponentScan(basePackages = "com.oraclejava.spring.sample1")
@EnableTransactionManagement
public class DataServiceConfig {

	@Bean
	public DataSource dataSource() throws Exception {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setURL("jdbc:oracle:thin:@localhost:8521/freepdb1");
		dataSource.setUser("airport");
		dataSource.setPassword("airport1234");
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.oraclejava.spring.sample1.entity");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		props.put("hibernate.hbd2ddl.auto", "none");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		emf.setJpaProperties(props);
		return emf;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() throws Exception{
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}
}
