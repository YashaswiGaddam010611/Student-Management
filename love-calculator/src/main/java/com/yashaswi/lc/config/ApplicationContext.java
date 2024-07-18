package com.yashaswi.lc.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.yashaswi.lc.formatters.PhoneNumberFormatter;
import com.yashaswi.lc.service.MailServices;
import com.yashaswi.lc.service.MailServicesImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"com.yashaswi.lc.controllers","com.yashaswi.lc.service"})
@PropertySource("classpath:email.properties")
public class ApplicationContext implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;
	
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("inside addFormatters method");
		registry.addFormatter(new PhoneNumberFormatter());
	}
	
	public Validator getValidator() {
		return validator();
	}
	
	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		
		return localValidatorFactoryBean;
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		
		return messageSource;
	}
	
	//mail sender beans
	
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		//testing
		System.out.println("form env "+env.getProperty("mail.host"));
		
		mailSender.setHost(env.getProperty("mail.host"));
		mailSender.setUsername(env.getProperty("mail.userName"));
		mailSender.setPassword(env.getProperty("mail.password"));
		mailSender.setPort(getIntProperty("mail.port"));
		
		mailSender.setJavaMailProperties(getMailProperties());
		
		return mailSender;
	}
	
	public int getIntProperty(String key) {
		String property = env.getProperty(key);
		
		return Integer.parseInt(property);
	}
	
	public Properties getMailProperties() {
		
		Properties mailProperties = new Properties();
		
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		return mailProperties;
	}

}
