package com.spredfast.api.sandbox.service;

import com.spredfast.api.sandbox.domain.Environment;

public interface ISfApiDefinitionService {

	String fetchDefinition();

	void updateServerConfiguration(String host, String scheme, String urlPrefix, String apiVersion);

	Iterable<Environment> findAll();

	Environment save(Environment environment);

	Environment findEnvironment(Long id);

	void deleteEnvironment(Long id);
}
