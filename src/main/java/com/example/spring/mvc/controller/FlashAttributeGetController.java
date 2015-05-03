package com.example.spring.mvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.spring.mvc.model.Person;

/**
 * @author Maulik
 * 
 */
@Controller
public class FlashAttributeGetController {

	private static final Logger logger = Logger
			.getLogger(FlashAttributeGetController.class);

	@RequestMapping(value = "/flashGet", method = RequestMethod.GET)
	private String getFlashAttribute(HttpServletRequest httpServletRequest,
			RedirectAttributes redirectAttributes) {
		Map<String, ?> inputFlashMap = RequestContextUtils
				.getInputFlashMap(httpServletRequest);
		Person flashAttribute = null;
		if (inputFlashMap != null) {
			flashAttribute = (Person) inputFlashMap.get("person");
			logger.info("In Get Flash Attribure Controller >> Flash Attribute :: "
					+ flashAttribute);
			redirectAttributes.addFlashAttribute("get1", flashAttribute);
		}
		return "redirect:/flashGet1";
	}

	@RequestMapping(value = "/flashGet1", method = RequestMethod.GET)
	@ResponseBody
	private Person getFlash1Attribute(HttpServletRequest httpServletRequest) {
		Map<String, ?> inputFlashMap = RequestContextUtils
				.getInputFlashMap(httpServletRequest);
		Person flashAttribute = null;
		if (inputFlashMap != null) {
			flashAttribute = (Person) inputFlashMap.get("get1");
			logger.info("In Get Flash Attribure Controller >> Flash Attribute :: "
					+ flashAttribute);
		} else {
			logger.info("Flash Attribute Getting Null...!!!");
		}
		return flashAttribute;
	}

}
