package com.xm.opentrendsservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BuildDto {

	private String name;
	private String pathRepo;
	private String version;
	
}
