package com.spredfast.api.sandbox.dao;

import com.spredfast.api.sandbox.domain.Environment;

public interface IEnvironmentDao {

	Iterable<Environment> findAll();

	Environment save(Environment environment);

	Environment findEnvironment(Long id);

	void deleteEnvironment(Long id);

}
