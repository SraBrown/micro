package com.xm.opentrendsservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Builds {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUILD_ID")
	private Long build;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PATH_REPO")
	private String pathRepo;
	@Column(name = "VERSION")
	private String version;

}
