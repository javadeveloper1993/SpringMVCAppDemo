package com.example.spring.mvc.main;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

@WebListener
public class SpringMVCApplicationListner implements ServletContextListener {
	private static final Logger logger = Logger
			.getLogger(SpringMVCApplicationListner.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info(">>>>>>>>>> Context Initilized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info(">>>>>>>>>> Context Destroyed");
	}

}
