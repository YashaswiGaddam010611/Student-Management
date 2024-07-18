package com.yashaswi.lc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?>[] configClasses = {ApplicationContext.class};
		return configClasses;
	}

	@Override
	protected String[] getServletMappings() {
		String[] urlMappings = new String[1];
		urlMappings[0] = "/";
		return urlMappings;
	}

}
