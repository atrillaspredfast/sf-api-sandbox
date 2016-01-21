package com.spredfast.api.sandbox.integration;

import com.spredfast.api.sandbox.domain.Environment;

public interface ISfApiClient {

	String fetchDefinition(Environment environment);
}
