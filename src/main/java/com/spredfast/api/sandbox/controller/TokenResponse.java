package com.spredfast.api.sandbox.controller;

import java.util.Map;
import java.util.Optional;

/**
 * {"data":{"sfEntityType":"Token","accessToken":"7u2ak645vxtkfumrrph72nbk","expiryTime":1515615742162},"status":{"succeeded":true}}
 */
public class TokenResponse {
	private Map<String, String> data;
	private Map<String, Boolean> status;

	public TokenResponse() {
	}

	public TokenResponse(Map<String, String> data, Map<String, Boolean> status) {
		this.data = data;
		this.status = status;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public Map<String, Boolean> getStatus() {
		return status;
	}

	public void setStatus(Map<String, Boolean> status) {
		this.status = status;
	}

	public Optional<String> getAccessToken() {
		return Optional.<String>ofNullable((data != null && data.get("accessToken") != null) ? data.get("accessToken") : null);
	}

	public Boolean isSuccess() {
		return (status != null) ? Boolean.TRUE.equals(status.get("succeeded")) : false;
	}
}
