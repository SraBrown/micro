package com.xm.opentrendsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.xm.opentrendsservice.dtos.BuildDto;
import com.xm.opentrendsservice.service.OpentrendBuildService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/opend")
@RequiredArgsConstructor
@Slf4j
public class OpentrendController {

	@Autowired
	private OpentrendBuildService service;
	
	
	@GetMapping(path = "/getPin/{id}")
	private void getPin(@PathVariable Long id) {
		log.info("/api/getPin/all");
	}
	
	
	@PostMapping(value = "CreateBuild", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	private String CreateBuild(@Validated @RequestBody BuildDto requestBuild){
		
		log.info("CreateBuild");
		try {
			service.createBuild(requestBuild);
		} catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.BAD_REQUEST, "Error en el request", e);
		}
		
		return ResponseEntity.ok().toString();
		
	}
}
