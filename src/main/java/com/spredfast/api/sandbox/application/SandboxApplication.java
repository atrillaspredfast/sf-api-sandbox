package com.spredfast.api.sandbox.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;
import com.spredfast.api.sandbox.domain.Environment;
import com.spredfast.api.sandbox.service.ISfApiDefinitionService;

@SpringBootApplication
@ComponentScan(basePackages = "com.spredfast.api.sandbox")
public class SandboxApplication {
	@Autowired
	private ISfApiDefinitionService sfApiDefinitionService;

	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}

	@Bean
	public Converter<String, Environment> environmentConverter() {
		return new Converter<String, Environment>() {
			@Override
			public Environment convert(String id) {
				return sfApiDefinitionService.findEnvironment(Long.valueOf(id));
			}
		};
	}
}
