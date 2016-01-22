package com.spredfast.api.sandbox.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

	Logger log = Logger.getLogger(OAuth2Controller.class);

	@RequestMapping("/definition/o2c.html")
	public RedirectView fetchDefinition(@RequestParam(name = "state") String state,
			@RequestParam(name = "code") String code) {
		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> list = new LinkedList<>();
		list.add(new FormHttpMessageConverter());
		list.add(new MappingJackson2HttpMessageConverter());
		restTemplate.setMessageConverters(list);
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		// FIXME
		String tokenUrl = sessionData.getTokenURL();
		if (tokenUrl == null) {
			tokenUrl = "https://infralogin.spredfast.com/v1/oauth/token";
		}
		String clientId = sessionData.getClientId();
		if (clientId == null) {
			clientId = "39zn2zrtfehncfpemzq7ak9r";
		}
		String clientSecret = sessionData.getClientSecret();
		if (clientSecret == null) {
			clientSecret = "heKxvEhxaC";
		}
		params.add("client_id", clientId);
		params.add("client_secret", clientSecret);
		//FIXME : use the same URL here and in Swagger UI's initial request
		Properties props = new Properties();
		String serverPort = "8080";
		try {
			props.load(ClassLoader.getSystemResourceAsStream("application.properties"));
			serverPort = props.getProperty("server.port");
		} catch (IOException e) {
			e.printStackTrace();
		}
		params.add("redirect_uri", "http://localhost:" + serverPort + "/definition/o2c.html");
		params.add("code", code);		

		TokenResponse tokenResponse = null;
		try {
			tokenResponse = restTemplate.postForObject(tokenUrl, params, TokenResponse.class);
		}
		catch (Throwable t) {
			t.printStackTrace(System.err);
		}

		if (tokenResponse != null && tokenResponse.isSuccess() && tokenResponse.getAccessToken().isPresent()) {
			sessionData.setAccessToken(tokenResponse.getAccessToken().get());
			log.info("Access token is: " + sessionData.getAccessToken());
			return new RedirectView(MessageFormat.format("/definition/auth_completed.html?access_token={0}&state={1}", sessionData.getAccessToken(), state));
		}
		else {
			return new RedirectView("/");
		}
	}
}
