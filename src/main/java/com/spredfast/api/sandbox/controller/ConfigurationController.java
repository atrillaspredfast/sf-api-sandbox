package com.spredfast.api.sandbox.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/configuration")
public class ConfigurationController {
	@Autowired
	private SessionData sessionData;

	@RequestMapping
	public ModelAndView getClientSessionData() {
		Configuration configuration = new Configuration(sessionData.getClientId(), sessionData.getClientSecret());

		return new ModelAndView("configuration/form", "configuration", configuration);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@Valid Configuration configuration, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("configuration/form", "formErrors", result.getAllErrors());
		}
		sessionData.setClientId(configuration.getClientId());
		sessionData.setClientSecret(configuration.getClientSecret());
		redirect.addFlashAttribute("globalConfiguration", "Successfully saved");
		return new ModelAndView("configuration/form", "configuration", configuration);
	}
}
