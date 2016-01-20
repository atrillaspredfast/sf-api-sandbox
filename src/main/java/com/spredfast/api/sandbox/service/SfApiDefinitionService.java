package com.spredfast.api.sandbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spredfast.api.sandbox.dao.IEnvironmentDao;
import com.spredfast.api.sandbox.dao.ISfApiDefinitionDao;
import com.spredfast.api.sandbox.domain.Environment;

@Service("sfApiDefinitionService")
public class SfApiDefinitionService implements ISfApiDefinitionService {

	@Autowired
	private ISfApiDefinitionDao sfApiDefinitionDao;

	@Autowired
	private IEnvironmentDao environmentDao;

	@Override
	public String fetchDefinition() {
		return sfApiDefinitionDao.fetchDefinition();
	}

	@Override
	public void updateServerConfiguration(String host, String scheme, String urlPrefix, String apiVersion) {
	}

	@Override
	public Iterable<Environment> findAll() {
		return environmentDao.findAll();
	}

	@Override
	public Environment save(Environment environment) {
		return environmentDao.save(environment);
	}

	@Override
	public Environment findEnvironment(Long id) {
		return environmentDao.findEnvironment(id);
	}

	@Override
	public void deleteEnvironment(Long id) {
		environmentDao.deleteEnvironment(id);
	}
}
