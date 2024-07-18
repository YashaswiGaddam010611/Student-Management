package com.yashaswi.lc.controllers;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yashaswi.lc.api.RegistrationDTO;
import com.yashaswi.lc.propertyEditors.CustomNameEditor;

@Controller
public class RegistrationController {

	@RequestMapping("/registration")
	public String showRegistrationPage(@ModelAttribute("registrationInfo") RegistrationDTO registrationInfo) {
		System.out.println("inside showRegistrationPage method");
		return "register";
	}

	@RequestMapping("/registration-sucess")
	public String showSucessPage(@Valid @ModelAttribute("registrationInfo") RegistrationDTO registrationInfo,
			BindingResult result) {
		System.out.println("inside showSucessPage method");
		
		System.out.println("|"+registrationInfo.getUser()+"|");

		if (result.hasErrors())
			return "register";

		return "regiSucess";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("inside initBinder method");
		//binder.setDisallowedFields("user");
		
		
		
		  StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		  binder.registerCustomEditor(String.class, "user", trimmer);
		 
		 
		 CustomNameEditor nameEditor = new CustomNameEditor();
		 binder.registerCustomEditor(String.class,"user", nameEditor);
		 
		 binder.addValidators(new com.yashaswi.lc.validators.UserNameValidator());
		 
		 binder.addValidators(new com.yashaswi.lc.validators.EmailValidator());
		 
	}

}
