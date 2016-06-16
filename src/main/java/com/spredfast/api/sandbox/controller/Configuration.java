package com.spredfast.api.sandbox.controller;

public class Configuration {

	private String clientId;

	private String clientSecret;

	private String apiHost;

	private String apiBasePath;

	public Configuration() {
	}

	public Configuration(String clientId, String clientSecret, String apiHost, String apiBasePath) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.apiHost = apiHost;
		this.apiBasePath = apiBasePath;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getApiHost() {
		return apiHost;
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}

	public String getApiBasePath() {
		return apiBasePath;
	}

	public void setApiBasePath(String apiBasePath) {
		this.apiBasePath = apiBasePath;
	}
}
