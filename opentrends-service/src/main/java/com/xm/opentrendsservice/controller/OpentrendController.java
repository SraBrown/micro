package com.xm.opentrendsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.xm.opentrendsservice.service.OpentrendService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/opend")
@RequiredArgsConstructor
@Slf4j
public class OpentrendController {

	@Autowired
	private OpentrendService service;
	
	
	@GetMapping(path = "/all/{id}")
	private void getRequest(@PathVariable Long id) {
		log.info("/api/opend/all");
	}
	
	
	@PostMapping(path = "/createRepositories/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	private String getCreateRepositories() {
		
		log.info("createRepositories");
		try {
			service.createRepository();
		} catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.BAD_REQUEST, "Error en el request", e);
		}
		
		return ResponseEntity.ok().toString();
		
	}
}
