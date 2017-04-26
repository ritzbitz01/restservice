package com.rbp.simplespring.restservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

	public StatusController() {

	}

	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public ResponseEntity<Object> health() {
		return new ResponseEntity<>("Service is running", HttpStatus.OK);
	}

}
