package com.milos.PlanetsManager.dto;

import java.util.HashSet;
import java.util.Set;

import com.milos.PlanetsManager.model.Satellite;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PlanetDto {

	private Long id;
	@NotBlank(message = "Planet name field can cannot be blank!")
	private String name;
	@NotNull(message = "Planet surfaceArea field cannot not be blank!")
	private Long surfaceArea;
	@NotNull(message = "Planet mass field may cannot blank!")
	private Long mass;
	@NotNull(message = "Planet distanceFromSun field cannot be blank!")
	private Long distanceFromSun;
	private Integer averageSurfaceTemperature;
	private Set<Satellite> satellites = new HashSet<Satellite>();

	public PlanetDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlanetDto(Long id, String name, Long surfaceArea, Long mass, Long distanceFromSun,
			Integer averageSurfaceTemperature, Set<Satellite> satellites) {
		super();
		this.id = id;
		this.name = name;
		this.surfaceArea = surfaceArea;
		this.mass = mass;
		this.distanceFromSun = distanceFromSun;
		this.averageSurfaceTemperature = averageSurfaceTemperature;
		this.satellites = satellites;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Long surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Long getMass() {
		return mass;
	}

	public void setMass(Long mass) {
		this.mass = mass;
	}

	public Long getDistanceFromSun() {
		return distanceFromSun;
	}

	public void setDistanceFromSun(Long distanceFromSun) {
		this.distanceFromSun = distanceFromSun;
	}

	public Integer getAverageSurfaceTemperature() {
		return averageSurfaceTemperature;
	}

	public void setAverageSurfaceTemperature(Integer averageSurfaceTemperature) {
		this.averageSurfaceTemperature = averageSurfaceTemperature;
	}

	public Set<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(Set<Satellite> satellites) {
		this.satellites = satellites;
	}

}
