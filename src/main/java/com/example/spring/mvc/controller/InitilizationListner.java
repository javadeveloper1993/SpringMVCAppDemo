package com.example.spring.mvc.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebListener
public class InitilizationListner implements ServletContextListener {
	private static final Logger logger = Logger
			.getLogger(InitilizationListner.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info(">>>>>>>>>> Context Initilized");
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(sce.getServletContext());
		logger.info(">>>> ApplicationName :: "
				+ webApplicationContext.getApplicationName());
		logger.info(" >>>>>>>>> :: BeanDefinitionCount :"
				+ webApplicationContext.getBeanDefinitionCount());
		logger.info(">>>>>>>>> :::: ID ::: " + webApplicationContext.getId());
		logger.info(">>>>>>>>> :::: DisplayName ::: "
				+ webApplicationContext.getDisplayName());
		String[] beanDefinitionNames = webApplicationContext
				.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			logger.info(name);
		}
		logger.info(" >>>>>>>>..  Startup Date :::: "
				+ webApplicationContext.getStartupDate());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info(">>>>>>>>>> Context Destroyed");
	}

}
