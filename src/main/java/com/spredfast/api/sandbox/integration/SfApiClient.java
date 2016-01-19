package com.spredfast.api.sandbox.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SfApiClient implements ISfApiClient {

	//FIXME : inject attribute values from properties
	private String scheme;

	private String host;

	private String port;

	private String urlPrefix;

	@Override
	public String fetchDefinition() {
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject(getFetchDefinitionURI(), String.class);
	}

	private String getFetchDefinitionURI() {
		//FIXME : build uri using client attributes
		return "http://localhost:8092/swagger.json";
	}
}
