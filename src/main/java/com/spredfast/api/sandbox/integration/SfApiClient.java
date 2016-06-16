package com.spredfast.api.sandbox.integration;

import java.text.MessageFormat;
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
		String url = environment.getUrlPrefix();
		if (url == null) {
			url = "swagger.json";
		}
		else if (url.startsWith("/")) {
			url = url.substring(1);
		}
		return MessageFormat.format("{0}://{1}:{2}/{3}",
				environment.getScheme(), environment.getHost(),
				environment.getPort(), url);
	}
}
