package com.zxm.demo5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EntityScan(basePackages={"com.zxm.domain"})
@EnableJpaRepositories(basePackages= {"com.zxm.rep"})
@SpringBootApplication(scanBasePackages={"com.zxm.demo5","com.zxm.ctrl"})
public class MyDemo21Application extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		
		SpringApplication.run(MyDemo21Application.class, args);
	}
	
	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/readingList");
	
	}*/
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}
}
