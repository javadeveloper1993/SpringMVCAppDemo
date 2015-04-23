package com.example.spring.mvc.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Maulik
 * 
 */
@Controller
@RequestMapping("/rqparameter")
public class RequestParameterController {

	private static final Logger logger = Logger
			.getLogger(RequestParameterController.class);

	@RequestMapping(value = "/demo1", method = RequestMethod.GET)
	private void requestDemo(
			@RequestParam(value = "name") String firstName,
			@RequestParam(required = false, value = "age") Integer age,
			@RequestParam(required = false, value = "gender", defaultValue = "Male") String gender) {
		logger.info(" >>>> In Request Parameter Demo 1");
		logger.info(" >>>> Data :: Name >>> " + firstName + " :: Age >>> "
				+ age + ":: Gender >>> " + gender);
	}

	@RequestMapping(value = "/map", method = RequestMethod.GET)
	private void requestWithMapDemo(@RequestParam Map<String, String> map) {
		logger.info(" >>>> In Request Parameter Demo With Map");
		logger.info(" >>>> Map Size Is :: " + map.size());
		if (map != null && !map.isEmpty()) {
			for (Entry<String, String> entry : map.entrySet()) {
				logger.info(entry.getKey() + " >>> " + entry.getValue());
			}
		}
	}

	@RequestMapping(value = "/multiMap", method = RequestMethod.GET)
	private void requestWithMultiMapDemo(
			@RequestParam MultiValueMap<String, String> multiValueMap) {
		logger.info(" >>>> In Request Parameter Demo With Multi Map");
		logger.info(" >>>> Multi Map Size Is :: " + multiValueMap.size());
		if (multiValueMap != null && !multiValueMap.isEmpty()) {
			Set<Entry<String, List<String>>> entrySet = multiValueMap
					.entrySet();
			Iterator<Entry<String, List<String>>> iterator = entrySet
					.iterator();
			while (iterator.hasNext()) {
				Entry<String, List<String>> entry = iterator.next();
				logger.info(entry.getKey() + " >>> " + entry.getValue());
			}
		}
	}
}
