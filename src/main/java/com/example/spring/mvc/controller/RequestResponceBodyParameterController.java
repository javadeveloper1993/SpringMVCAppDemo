package com.example.spring.mvc.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring.mvc.model.Person;

/**
 * @author Maulik
 * 
 */
@Controller
@RequestMapping("/rqbody")
public class RequestResponceBodyParameterController {

	private Person person;

	private static final Logger logger = Logger
			.getLogger(RequestResponceBodyParameterController.class);

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	@ResponseBody
	public Person addPerson(@RequestBody Person person) {
		logger.info(person);
		this.person = person;
		return person;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public Person getPerson() {
		logger.info("In Get Person >>> " + person);
		return person;
	}

	@RequestMapping(value = "/entiry", method = RequestMethod.POST)
	public ResponseEntity<String> handle(HttpEntity<String> httpEntity) {

		String body = httpEntity.getBody();
		logger.info("Body :: " + body);
		
		logger.info("Get Request Header :: " +httpEntity.getHeaders().getFirst("entity"));

		HttpHeaders headers = httpEntity.getHeaders();
		Set<Entry<String, List<String>>> entrySet = headers.entrySet();
		Iterator<Entry<String, List<String>>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<String, List<String>> next = iterator.next();
			logger.info("Key >> " + next.getKey() + " >>> Value :: "
					+ next.getValue());
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("MyEntity", body);
		responseHeaders.add("Content-Type", "application/json");
		return new ResponseEntity<String>(body, responseHeaders, HttpStatus.OK);
	}
}
