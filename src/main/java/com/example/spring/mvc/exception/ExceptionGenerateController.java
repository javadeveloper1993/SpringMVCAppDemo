package com.example.spring.mvc.exception;

import javax.management.RuntimeErrorException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Maulik
 * 
 */
@Controller
public class ExceptionGenerateController {

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

}
