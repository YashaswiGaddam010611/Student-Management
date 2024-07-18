package com.yashaswi.lc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yashaswi.lc.api.UserInfoDTO;
import com.yashaswi.lc.service.LoveCalculationService;

@Controller
@SessionAttributes("userInfo")
public class AppController {
	
	@Autowired
	private LoveCalculationService loveCalculationService;

	public AppController() {
		System.out.println("AppController detected");
	}

	@RequestMapping("/")
	public String showHomePage(Model model) {
		model.addAttribute("userInfo",new UserInfoDTO());
		return "home";
	}

	@RequestMapping("/result")
	public String showResult(@Valid UserInfoDTO userInfo,
			BindingResult result, Model model, HttpServletRequest request) {
		
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX+"userInfo",result);
		
		if (result.hasErrors()) {
			return "home";
		}
		
		//getting love calculation results
		String resultString = loveCalculationService.calculateLove(userInfo.getYourName(), 
				userInfo.getCrushName());
		
		userInfo.setResult(resultString);
		model.addAttribute("userInfo",userInfo);
		
		HttpSession session = request.getSession();
		session.setAttribute("userInfo",userInfo);

		return "result";
	}
}
