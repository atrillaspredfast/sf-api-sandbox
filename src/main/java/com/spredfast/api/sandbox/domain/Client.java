package com.spredfast.api.sandbox.domain;

public class Client {

	private Long id;

	private String name;

	private String authClientId;

	private String authSecret;

	public Client() {
	}

	public Client(Long id, String name, String authClientId, String authSecret) {
		this.id = id;
		this.name = name;
		this.authClientId = authClientId;
		this.authSecret = authSecret;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthClientId() {
		return authClientId;
	}

	public void setAuthClientId(String authClientId) {
		this.authClientId = authClientId;
	}

	public String getAuthSecret() {
		return authSecret;
	}

	public void setAuthSecret(String authSecret) {
		this.authSecret = authSecret;
	}
}
