package com.yashaswi.lc.service;

import javax.mail.MessagingException;

public interface FeedBackMailServices {
	void sendMailToUser(String userName, String mailId);
	void sendMailToAdmin(String mailId, String userName, String feedback) throws MessagingException;
}
