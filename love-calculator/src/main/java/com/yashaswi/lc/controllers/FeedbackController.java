package com.yashaswi.lc.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yashaswi.lc.api.FeedbackDTO;
import com.yashaswi.lc.service.FeedBackMailServices;

@Controller
public class FeedbackController {
	
	@Autowired
	private FeedBackMailServices feedbackmailServices;
	
	Logger logger = Logger.getLogger(FeedbackController.class.getName());
	
	@RequestMapping("/feedback")
	public String showFeedbackPage(@ModelAttribute("feedbackInfo") FeedbackDTO feedbackInfo) {
		
		return "feedback-page";
	}
	
	@RequestMapping("/feedback-success")
	public String processFeedback(@ModelAttribute("feedbackInfo") FeedbackDTO feedbackInfo) {
		
		try {
			feedbackmailServices.sendMailToAdmin(feedbackInfo.getEmail(), feedbackInfo.getName(),
					feedbackInfo.getFeedback());
			
			feedbackmailServices.sendMailToUser(feedbackInfo.getName(), feedbackInfo.getEmail());
		} catch (Exception e) {
			logger.info(e);
		}
		
		return "feedback-success";
	}
}
