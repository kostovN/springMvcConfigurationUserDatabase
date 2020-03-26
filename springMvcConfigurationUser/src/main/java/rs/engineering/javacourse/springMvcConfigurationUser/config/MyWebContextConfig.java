package rs.engineering.javacourse.springMvcConfigurationUser.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import rs.engineering.javacourse.springMvcConfigurationUser.controller.BackController;
import rs.engineering.javacourse.springMvcConfigurationUser.controller.UserController;


@Configuration
@ComponentScan(basePackages = {
		"rs.engineering.javacourse.springMvcConfigurationUser.repository",
		"rs.engineering.javacourse.springMvcConfigurationUser.service"
})
public class MyWebContextConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/engineering.spring");
		dataSource.setUsername("admin");
		dataSource.setPassword("admin");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public UserController userController() {
		return new UserController();
	}
	
	@Bean
	public BackController backController() {
		return new BackController();
	}
	
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		return new RequestMappingHandlerMapping();
	}
	
	@Bean
	public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
		SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
		Map<String,Object> urlMap = new HashMap<String, Object>(); 
		simpleUrlHandlerMapping.setUrlMap(urlMap);
		return simpleUrlHandlerMapping;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
