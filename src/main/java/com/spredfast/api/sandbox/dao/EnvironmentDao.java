package com.spredfast.api.sandbox.dao;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.spredfast.api.sandbox.domain.Environment;

@Repository
public class EnvironmentDao implements IEnvironmentDao {

	@Override
	public Iterable<Environment> findAll() {
		return new ArrayList<>();
	}

	@Override
	public Environment save(Environment environment) {
		return new Environment();
	}

	@Override
	public Environment findEnvironment(Long id) {
		return new Environment();
	}

	@Override
	public void deleteEnvironment(Long id) {

	}
}
