package com.spredfast.api.sandbox.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spredfast.api.sandbox.domain.SampleEntity;
import com.spredfast.api.sandbox.service.ISampleService;

@RestController
public class SampleController {
	@Autowired
	private ISampleService sampleService;

	@RequestMapping("/sample")
	public List<SampleEntity> home() {
		return sampleService.findAllEntities();
	}
}