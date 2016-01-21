package com.spredfast.api.sandbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spredfast.api.sandbox.dao.EnvironmentRepository;
import com.spredfast.api.sandbox.domain.Environment;
import com.spredfast.api.sandbox.service.ISfApiDefinitionService;

@RestController
public class SfApiDefinitionController {

	@Autowired
	private ISfApiDefinitionService sfApiDefinitionService;

	@Autowired
	private EnvironmentRepository environmentRepository;

	@Autowired
	private SessionData sessionData;

	@RequestMapping("/sf-api-definition.json")
	public String fetchDefinition() {
		Environment environment = environmentRepository.findAll().iterator().next();

		// TODO parse Httpresponse and set authorizationURL and tokenURL (sessionData)
		return sfApiDefinitionService.fetchDefinition(environment);
	}
}
