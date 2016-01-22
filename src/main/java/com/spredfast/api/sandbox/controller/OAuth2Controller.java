package com.spredfast.api.sandbox.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.spredfast.api.sandbox.dao.EnvironmentRepository;
import com.spredfast.api.sandbox.service.ISfApiDefinitionService;

@RestController
public class OAuth2Controller {

	@Autowired
	private ISfApiDefinitionService sfApiDefinitionService;

	@Autowired
	private EnvironmentRepository environmentRepository;

	@Autowired
	private SessionData sessionData;

	@RequestMapping("/definition/o2c.html")
	public String fetchDefinition(@RequestParam(name = "state") String state,
			@RequestParam(name = "code") String code) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> params = new HashMap<>();
		Configuration configuration = new Configuration(sessionData.getClientId(), sessionData.getClientSecret());

		params.put("client_id", configuration.getClientId());
		params.put("client_secret", configuration.getClientSecret());
		//FIXME : add SessionData.uriRedirect
//		params.put("redirect_uri", sessionData.getUriRedirect());
		params.put("code", code);

		// FIXME : add post method call
//		TokenResponse tokenResponse = restTemplate.postForObject(sessionData.getTokenURL(), TokenResponse.class, params);
		TokenResponse tokenResponse = null;

		if (tokenResponse.isSuccess() && tokenResponse.getAccessToken().isPresent()) {
			sessionData.setAccecssToken(tokenResponse.getAccessToken().get());
		}
		return "";
	}
}
