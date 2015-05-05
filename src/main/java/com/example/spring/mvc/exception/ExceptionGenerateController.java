package com.example.spring.mvc.exception;

import java.util.Date;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author Maulik
 * 
 */
@Controller
public class ExceptionGenerateController {

	Logger logger = Logger.getLogger(ExceptionGenerateController.class);

	@RequestMapping(value = "/customeError", method = RequestMethod.GET)
	public ModelAndView generateCustomeException()
			throws CustomGenericException {
		throw new CustomGenericException(HttpStatus.BAD_REQUEST.toString(),
				"This is Custome Request");
	}

	@RequestMapping(value = "/runTimeError", method = RequestMethod.GET)
	public ModelAndView generateRunTimeException() {
		throw new RuntimeErrorException(new Error("RunTime Error"),
				"This Is Runtime Expetion...!!!");
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView generate404NotFoundException(
			NoHandlerFoundException ex, HttpServletRequest httpServletRequest) {
		logger.info("In No Handler found Exeption Method...!!! "
				+ httpServletRequest.getRequestURI());
		ModelAndView model = new ModelAndView("error/generic_error");
		String status = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()
				+ " :: " + HttpStatus.INTERNAL_SERVER_ERROR.value();
		model.addObject("errCode", status);
		model.addObject("errMsg", ex.getMessage());
		model.addObject("stackTrace", ex.getStackTrace());
		model.addObject("className", ex.getClass());
		model.addObject("date", new Date());
		model.addObject("url", httpServletRequest.getRequestURI());
		return model;
	}

}
