package com.landq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.landq.bean.Employee;
import com.landq.controller.MVCController;
import com.landq.dao.EmpDAO;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.landq")
//@PropertySource("db-info.properties")
public class MyConfig extends WebMvcConfigurerAdapter {
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        System.out.println("Enters view resolver method");
        return viewResolver;
    }
    /*@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/
	@Bean
	public DriverManagerDataSource getDataSource() {
		
		DriverManagerDataSource bds = new DriverManagerDataSource();
		bds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		bds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=test");
		bds.setUsername("sa");
		bds.setPassword("sa123");

		return bds;
	}
	@Bean
	public JdbcTemplate getJdbcTemplate(){
		JdbcTemplate jdbcTemplate =new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean
	public EmpDAO empDAOBean(){
        System.out.println("empDao bean created");
        EmpDAO empDao=new EmpDAO();
        empDao.setTemplate(getJdbcTemplate());
		return empDao;
	}
	
	@Bean
	public Employee empBean(){

        System.out.println("empbean bean created");
		return new Employee();
	}
}
