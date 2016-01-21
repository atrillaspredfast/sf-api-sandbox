package com.spredfast.api.sandbox.dao;

import com.spredfast.api.sandbox.domain.Environment;

public interface ISfApiDefinitionDao {
	String fetchDefinition(Environment environment);
}
