package com.yashaswi.lc.controllers;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yashaswi.lc.api.EmailDTO;
import com.yashaswi.lc.api.UserInfoDTO;
import com.yashaswi.lc.service.MailServices;

@Controller
public class EmailController {

	@Autowired
	private MailServices mailServices;

	Logger logger = Logger.getLogger(EmailController.class.getName());

	@RequestMapping("/send-email")
	public String showSendMailPage(Model model) {
		EmailDTO emailInfo = new EmailDTO();
		model.addAttribute("emailInfo", emailInfo);
		return "send-email-page";
	}

	@RequestMapping("/email-status")
	public String showMailStatusPage(@ModelAttribute("emailInfo") EmailDTO emailInfo, Model model,
			HttpSession session) {

		UserInfoDTO userInfo = (UserInfoDTO) session.getAttribute("userInfo");
		String userName = userInfo.getYourName();
		String crushName = userInfo.getCrushName();
		String mailId = emailInfo.getEmailId();
		String result = userInfo.getResult();

		try {
			mailServices.sendMail(userName, crushName, mailId, result);
		} catch (Exception e) {
			logger.info(e);
		}
		return "email-status";
	}
}
