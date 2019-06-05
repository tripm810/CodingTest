package com.coding.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coding.test.model.User;
import com.coding.test.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/registration", "/" }, method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.addObject("status", " ");
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else if (userService.findByMobileNumber(user.getMobileNumber()).size() > 0) {
			modelAndView.addObject("uniquevalidate", "Mobile number already exist");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else if (userService.findByEmail(user.getEmail()).size() > 0) {
			modelAndView.addObject("uniquevalidate", "Email already exist");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {
			userService.saveUser(user);
			modelAndView.addObject("status", "disabled");
			modelAndView.addObject("show", "show");
			modelAndView.addObject("hidden", "hidden");
			modelAndView.addObject("successMessage", "User is registered successfully!");
		}
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

}
