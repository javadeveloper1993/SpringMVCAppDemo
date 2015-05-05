package com.example.spring.mvc.exception;

import java.util.Date;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("404Error")
	public String generate404NotFoundException(
			HttpServletRequest httpServletRequest, Model model, Exception ex) {
		logger.info("In No Handler found Exeption Method...!!! "
				+ httpServletRequest.getRequestURI());
		String status = HttpStatus.NOT_FOUND.getReasonPhrase() + " :: "
				+ HttpStatus.NOT_FOUND.value();
		model.addAttribute("errCode", status);
		model.addAttribute("errMsg", ex.getMessage());
		model.addAttribute("stackTrace", ex.getStackTrace());
		model.addAttribute("className", ex.getClass());
		model.addAttribute("date", new Date());
		model.addAttribute("url", httpServletRequest.getRequestURI());
		return "error/generic_error";
	}

}
