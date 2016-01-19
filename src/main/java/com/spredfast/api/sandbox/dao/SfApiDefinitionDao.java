package com.spredfast.api.sandbox.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spredfast.api.sandbox.integration.SfApiClient;

@Repository
public class SfApiDefinitionDao implements ISfApiDefinitionDao {

	@Autowired
	private SfApiClient sfApiClient;


	@Override
	public String fetchDefinition() {
		return sfApiClient.fetchDefinition();
	}
}
