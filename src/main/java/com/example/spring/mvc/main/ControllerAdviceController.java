package com.example.spring.mvc.main;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.mvc.exception.CustomGenericException;

/**
 * @author Maulik
 * 
 */
@ControllerAdvice
public class ControllerAdviceController {

	private static final Logger logger = Logger
			.getLogger(ControllerAdviceController.class);

	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex,
			HttpServletRequest httpServletRequest) {
		logger.info("In CustomeGenericExeption Method...!!! "
				+ httpServletRequest.getRequestURI());
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
		model.addObject("stackTrace", ex.getStackTrace());
		model.addObject("className", ex.getClass());
		model.addObject("date", new Date());
		model.addObject("url", httpServletRequest.getRequestURI());
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest httpServletRequest,
			Exception ex) {
		logger.info("In Exeption Method...!!! "
				+ httpServletRequest.getRequestURI());
		ModelAndView model = new ModelAndView("error/generic_error");
		String status = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() + " :: "
				+ HttpStatus.INTERNAL_SERVER_ERROR.value();
		model.addObject("errCode", status);
		model.addObject("errMsg", ex.getMessage());
		model.addObject("stackTrace", ex.getStackTrace());
		model.addObject("className", ex.getClass());
		model.addObject("date", new Date());
		model.addObject("url", httpServletRequest.getRequestURI());
		return model;
	}
}
