package com.springdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
@EnableWebMvc
public class SwaggerConfig {
	private SpringSwaggerConfig  springSwaggerConfig;

	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}
	
	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
				.apiInfo(apiInfo())
				.includePatterns(".*")
				.swaggerGroup("XmPlatform")
				.apiVersion("1.0.0");
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"swagger原生API文档","后台RESTful API",
				"My Apps API terms of service","https://xx.xx.xx.com",
				"My Apps API Type","My Apps API Url");
		return apiInfo;
	}
	
}
