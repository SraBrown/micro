package com.xm.opentrendsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/opend")
@RequiredArgsConstructor
@Slf4j
public class OpentrendController {

	@GetMapping(path = "/all/{id}")
	private void getRequest(@PathVariable Long id) {
		log.info("/api/opend/all");
	}
	
}
