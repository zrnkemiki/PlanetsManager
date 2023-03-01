package com.milos.PlanetsManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.milos.PlanetsManager.dto.SatelliteDto;

@Entity
@Table(name = "satellites")
public class Satellite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Satellite name field cannot be blank!")
	private String name;
	@NotBlank(message = "Satellite surfaceArea field cannot be blank!")
	private Long surfaceArea;
	@NotBlank(message = "Satellite mass field may cannot blank!")
	private Long mass;
	@Column
	private Boolean naturalSatellite;

	public Satellite() {
	}

	public Satellite(Long id, String name, Long surfaceArea, Long mass, Boolean naturalSatellite) {
		super();
		this.id = id;
		this.name = name;
		this.surfaceArea = surfaceArea;
		this.mass = mass;
		this.naturalSatellite = naturalSatellite;
	}

	public Satellite(SatelliteDto satelliteDto) {
		this.id = satelliteDto.getId();
		this.name = satelliteDto.getName();
		this.surfaceArea = satelliteDto.getSurfaceArea();
		this.mass = satelliteDto.getMass();
		this.naturalSatellite = satelliteDto.getNaturalSatellite();
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

	public Boolean getNaturalSatellite() {
		return naturalSatellite;
	}

	public void setNaturalSatellite(Boolean naturalSatellite) {
		this.naturalSatellite = naturalSatellite;
	}

}
