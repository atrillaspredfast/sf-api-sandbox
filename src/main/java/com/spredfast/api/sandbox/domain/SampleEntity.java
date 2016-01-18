package com.spredfast.api.sandbox.domain;

public class SampleEntity {
	private String id;
	private String name;

	public SampleEntity() {
	}

	public SampleEntity(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
