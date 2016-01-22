package com.spredfast.api.sandbox.controller;

public class SessionData {
	private String authorizationURL = "https://infralogin.spredfast.com/v1/oauth/authorize";
	private String tokenURL = "https://infralogin.spredfast.com/v1/oauth/token";
	private String accecssToken;
	private String clientSecret;
	private String clientId;

	public String getAuthorizationURL() {
		return authorizationURL;
	}

	public void setAuthorizationURL(String authorizationURL) {
		this.authorizationURL = authorizationURL;
	}

	public String getTokenURL() {
		return tokenURL;
	}

	public void setTokenURL(String tokenURL) {
		this.tokenURL = tokenURL;
	}

	public String getAccecssToken() {
		return accecssToken;
	}

	public void setAccecssToken(String accecssToken) {
		this.accecssToken = accecssToken;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
}
