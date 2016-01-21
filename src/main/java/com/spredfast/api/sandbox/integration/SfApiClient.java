package com.spredfast.api.sandbox.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.spredfast.api.sandbox.domain.Environment;

@Component
public class SfApiClient implements ISfApiClient {

	@Override
	public String fetchDefinition(Environment environment) {
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject(getFetchDefinitionURI(environment), String.class);
	}

	private String getFetchDefinitionURI(Environment environment) {
		//FIXME : build uri using client attributes
		return "http://localhost:8092/swagger.json";
	}
}
