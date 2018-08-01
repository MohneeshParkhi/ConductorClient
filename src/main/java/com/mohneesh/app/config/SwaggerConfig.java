package com.mohneesh.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * This is Configuration class for Swagger version 2
 * 
 * @author mohneesh.p
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// creates bean of type Docket

	/**
	 * Configuring Swagger for API documentation
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mohneesh.app")).paths(regex("/api.*")).build()
				.apiInfo(metaData());
	}

	/**
	 * This fucntion provide metadata information for documentation
	 * 
	 * @return apiInfo
	 *
	 */

	public ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Springboot REST API", "Springboot Application for conductor client", "1.0",
				"Terms of Service", new Contact("HCL Technologies", "http://localhost:8080","mohneesh.p@hcl.com"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0"

		);

		return apiInfo;

	}

}
