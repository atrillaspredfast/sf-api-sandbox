package com.spredfast.api.sandbox.dao;

import com.spredfast.api.sandbox.domain.Environment;

public interface EnvironmentRepository {

	Iterable<Environment> findAll();

	Environment save(Environment environment);

	Environment findEnvironment(Long id);

	void deleteEnvironment(Long id);

}
