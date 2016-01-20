package com.spredfast.api.sandbox.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.spredfast.api.sandbox.domain.Environment;
import com.spredfast.api.sandbox.service.ISfApiDefinitionService;

@Controller
@RequestMapping("/environments/")
public class SfApiConfigurationController {

	@Autowired
	private ISfApiDefinitionService sfApiDefinitionService;

	@RequestMapping
	public ModelAndView list() {
		Iterable<Environment> environments = this.sfApiDefinitionService.findAll();
		return new ModelAndView("environments/list", "environments", environments);
	}

	@RequestMapping("{id}")
	public ModelAndView view(@PathVariable("id") Environment environment) {
		return new ModelAndView("environments/view", "environment", environment);
	}

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(@ModelAttribute Environment environment) {
		return "environments/form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@Valid Environment environment, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("environments/form", "formErrors", result.getAllErrors());
		}
		environment = this.sfApiDefinitionService.save(environment);
		redirect.addFlashAttribute("globalEnvironment", "Successfully created a new environment");
		return new ModelAndView("redirect:/{environment.id}", "environment.id", environment.getId());
	}

	@RequestMapping("foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}

	@RequestMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		this.sfApiDefinitionService.deleteEnvironment(id);
		Iterable<Environment> environments = this.sfApiDefinitionService.findAll();
		return new ModelAndView("environments/list", "environments", environments);
	}

	@RequestMapping(value = "modify/{id}", method = RequestMethod.GET)
	public ModelAndView modifyForm(@PathVariable("id") Environment environment) {
		return new ModelAndView("environments/form", "environment", environment);
	}

}
