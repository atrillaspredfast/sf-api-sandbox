package com.spredfast.api.sandbox.controller;

public class SessionData {
	private String authorizationURL = "https://infralogin.spredfast.com/v1/oauth/authorize";

	private String tokenURL = "https://infralogin.spredfast.com/v1/oauth/token";

	private String accecssToken;

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
}
