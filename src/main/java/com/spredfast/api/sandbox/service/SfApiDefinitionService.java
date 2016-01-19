package com.spredfast.api.sandbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spredfast.api.sandbox.dao.ISfApiDefinitionDao;

@Service("sfApiDefinitionService")
public class SfApiDefinitionService implements ISfApiDefinitionService {

	@Autowired
	private ISfApiDefinitionDao sfApiDefinitionDao;

	@Override
	public String fetchDefinition() {
		return sfApiDefinitionDao.fetchDefinition();
	}
}
