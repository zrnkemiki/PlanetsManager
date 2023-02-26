package com.milos.PlanetsManager.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.milos.PlanetsManager.dto.PlanetDto;

@Entity
@Table(name = "planets")
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Planet name field may not be blank!")
	private String name;
	@NotNull(message = "Planet surfaceArea field may not be blank!")
	private Long surfaceArea;
	@NotNull(message = "Planet mass field may not be blank!")
	private Long mass;
	@NotNull(message = "Planet distanceFromSun field may not be blank!")
	private Long distanceFromSun;
	@Column
	private Integer averageSurfaceTemperature;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "planet_id", referencedColumnName = "id")
	private Set<Satellite> satellites = new HashSet<Satellite>();

	public Planet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Planet(Long id, String name, Long surfaceArea, Long mass, Long distanceFromSun,
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

	public Planet(PlanetDto updatePlanetDto) {
		this.id = updatePlanetDto.getId();
		this.name = updatePlanetDto.getName();
		this.surfaceArea = updatePlanetDto.getSurfaceArea();
		this.mass = updatePlanetDto.getMass();
		this.distanceFromSun = updatePlanetDto.getDistanceFromSun();
		this.averageSurfaceTemperature = updatePlanetDto.getAverageSurfaceTemperature();
		this.satellites = updatePlanetDto.getSatellites();
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
