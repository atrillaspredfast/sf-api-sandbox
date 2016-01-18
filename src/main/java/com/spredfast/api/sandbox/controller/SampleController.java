package com.spredfast.api.sandbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spredfast.api.sandbox.service.ISampleService;

@Controller
public class SampleController {
	@Autowired
	private ISampleService sampleService;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return sampleService.findAllEntities().toString();
	}
}