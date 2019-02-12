package com.sudip.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//used instead of spring.xml
@Configuration
// com.sudip is base package
@ComponentScan(basePackages = "com.sudip")
// to recognize the application.properties file
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfig {

	// to recognize properties used in application.properties
	// to automatically inject
	@Autowired
	private Environment env;

	@Bean
	// equivalent to bean id tag in spring.xml
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		/*
		 * dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 * dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
		 * dataSource.setUrl("root"); dataSource.setPassword("root");
		 */
		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driver.ClassName"));
		dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("jdbc.password"));

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// to reflect changes in database to Java class also
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}
}
