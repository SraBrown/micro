package com.xm.opentrendsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@SpringBootApplication
public class OpentrendsCreateBuildApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpentrendsCreateBuildApplication.class, args);
	}

	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .info(new Info()
	                        .title("opentrends API -------")
	                        .version("0.11")
	                        .description("opentrends")
	                        .termsOfService("https://www.opentrends.net/es")
	                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

	    }
}
