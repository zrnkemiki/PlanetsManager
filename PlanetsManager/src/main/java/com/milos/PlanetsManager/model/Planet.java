package com.milos.PlanetsManager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "planets")
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private Long surfaceArea;
	@Column(nullable=false)
	private Long mass;
	@Column(nullable=false)
	private Long distanceFromSun;
	private Integer averageSurfacetemperature;
	@OneToMany
	private List<Satellite> satellites = new ArrayList<>();

	public Planet() {
	}

	public Planet(Long id, String name, Long surfaceArea, Long mass, Long distanceFromSun,
			int averageSurfacetemperature, List<Satellite> satellites) {
		this.id = id;
		this.name = name;
		this.surfaceArea = surfaceArea;
		this.mass = mass;
		this.distanceFromSun = distanceFromSun;
		this.averageSurfacetemperature = averageSurfacetemperature;
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

	public int getAverageSurfacetemperature() {
		return averageSurfacetemperature;
	}

	public void setAverageSurfacetemperature(int averageSurfacetemperature) {
		this.averageSurfacetemperature = averageSurfacetemperature;
	}

	public List<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}

}
