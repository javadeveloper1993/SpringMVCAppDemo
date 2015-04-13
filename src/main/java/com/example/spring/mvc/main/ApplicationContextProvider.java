package com.example.spring.mvc.main;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

	Logger logger = Logger.getLogger(ApplicationContextProvider.class);
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		logger.info("-----------------------------ApplicationContext---------------------------");

		ApplicationContextProvider.applicationContext = applicationContext;

		WebApplicationContext webApplicationContext = (WebApplicationContext) applicationContext;

		logger.info("getRealPath -------------->> "
				+ webApplicationContext.getServletContext().getRealPath(""));
		/*
		 * List down all Bean ....
		 */
		getBeanListFromWAC(webApplicationContext);
		/*
		 * List down all requestMapping
		 */
		getRequestMappingUrlFromWAC(webApplicationContext);

	}

	private void getBeanListFromWAC(WebApplicationContext webApplicationContext) {
		String[] all = webApplicationContext.getBeanDefinitionNames();

		logger.info("-------------->>> Start List Bean size :---- >>>>-------------"
				+ all.length);

		for (String string : all) {
			logger.info(string);
		}

		logger.info("-------------->>> End List Bean :---- >>>>-------------");
	}

	private void getRequestMappingUrlFromWAC(
			WebApplicationContext webApplicationContext) {
		RequestMappingHandlerMapping requestMappingHandlerMapping = webApplicationContext
				.getBean(RequestMappingHandlerMapping.class);

		Set<RequestMappingInfo> rmSet = requestMappingHandlerMapping
				.getHandlerMethods().keySet();

		logger.info("-------------->>> Start List URL size :---- >>>>-------------"
				+ rmSet.size());

		for (RequestMappingInfo rm : rmSet) {
			logger.info(rm.getPatternsCondition().toString());
		}

		logger.info("-------------->>> End List URL >>>>-------------");
	}

	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

}
