package com.spredfast.api.sandbox.dao;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import com.spredfast.api.sandbox.domain.Environment;

public class InMemoryEnvironmentRepository implements EnvironmentRepository {

	private static AtomicLong counter = new AtomicLong();

	private final ConcurrentMap<Long, Environment> environments = new ConcurrentHashMap<Long, Environment>();

	@Override
	public Iterable<Environment> findAll() {
		return this.environments.values();
	}

	@Override
	public Environment save(Environment environment) {
		Long id = environment.getId();
		if (id == null) {
			id = counter.incrementAndGet();
			environment.setId(id);
		}
		this.environments.put(id, environment);
		return environment;
	}

	@Override
	public Environment findEnvironment(Long id) {
		return this.environments.get(id);
	}

	@Override
	public void deleteEnvironment(Long id) {
		this.environments.remove(id);
	}

}
