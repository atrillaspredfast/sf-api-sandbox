package com.spredfast.api.sandbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spredfast.api.sandbox.dao.ISfApiDefinitionDao;
import com.spredfast.api.sandbox.domain.Environment;

@Service("sfApiDefinitionService")
public class SfApiDefinitionService implements ISfApiDefinitionService {

	@Autowired
	private ISfApiDefinitionDao sfApiDefinitionDao;

	@Override
	public String fetchDefinition(Environment environment) {
		return sfApiDefinitionDao.fetchDefinition(environment);
	}
}
