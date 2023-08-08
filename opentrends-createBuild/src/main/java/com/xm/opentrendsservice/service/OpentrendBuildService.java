package com.xm.opentrendsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xm.opentrendsservice.dtos.BuildDto;
import com.xm.opentrendsservice.models.Builds;
import com.xm.opentrendsservice.repository.BuildRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OpentrendBuildService {
	
	@Autowired
	private BuildRepository repoBuild;
	
	public void createBuild(BuildDto requestBuild) {
		log.debug("OpentrendBuildService");
		
		Builds models=new Builds();
		models.setName(requestBuild.getName());
		models.setPathRepo(requestBuild.getPathRepo());
		models.setVersion(requestBuild.getVersion());
		repoBuild.save(models);
		
	}

	
}
