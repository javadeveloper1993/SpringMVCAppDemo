package com.example.spring.mvc.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Maulik
 * 
 */
public class HandlerInterceptorController extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger
			.getLogger(HandlerInterceptorController.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("In Handler Interceptor Pre Handle Method...!!! "
				+ request.getRequestURI());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("In Handler Interceptor Post Handle Method...!!! "
				+ request.getRequestURI());
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("In Handler Interceptor After Completion Method...!!! "
				+ request.getRequestURI());
		super.afterCompletion(request, response, handler, ex);
	}
}
