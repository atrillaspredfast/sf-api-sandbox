package com.spredfast.api.sandbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.spredfast.api.sandbox.dao.ClientRepository;
import com.spredfast.api.sandbox.dao.EnvironmentRepository;
import com.spredfast.api.sandbox.service.ISfApiDefinitionService;

@RestController
public class OAuth2Controller {

	@Autowired
	private ISfApiDefinitionService sfApiDefinitionService;

	@Autowired
	private EnvironmentRepository environmentRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private SessionData sessionData;

	@RequestMapping("/definition/o2c.html")
	public String fetchDefinition(@RequestParam(name = "state") String state,
			@RequestParam(name = "code") String code) {
		RestTemplate restTemplate = new RestTemplate();
		AuthorizationResponse authorizationResponse = restTemplate.getForObject(sessionData.getAuthorizationURL(), AuthorizationResponse.class);
		return "0";
	}
}
