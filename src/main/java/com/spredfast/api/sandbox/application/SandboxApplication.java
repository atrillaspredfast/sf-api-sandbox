package com.spredfast.api.sandbox.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;
import com.spredfast.api.sandbox.dao.EnvironmentRepository;
import com.spredfast.api.sandbox.dao.InMemoryEnvironmentRepository;
import com.spredfast.api.sandbox.domain.Environment;

@SpringBootApplication
@ComponentScan(basePackages = "com.spredfast.api.sandbox")
public class SandboxApplication {
	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}

	@Bean
	public EnvironmentRepository messageRepository() {
		return new InMemoryEnvironmentRepository();
	}

	@Bean
	public Converter<String, Environment> messageConverter() {
		return new Converter<String, Environment>() {
			@Override
			public Environment convert(String id) {
				return messageRepository().findEnvironment(Long.valueOf(id));
			}
		};
	}
}
