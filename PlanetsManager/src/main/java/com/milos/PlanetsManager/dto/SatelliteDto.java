package com.milos.PlanetsManager.dto;

public class SatelliteDto {

	private Long id;
	private String name;
	private Long surfaceArea;
	private Long mass;
	private Boolean naturalSatellite;
	private Long planetId;

	public SatelliteDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SatelliteDto(Long id, String name, Long surfaceArea, Long mass, Boolean naturalSatellite, Long planetId) {
		super();
		this.id = id;
		this.name = name;
		this.surfaceArea = surfaceArea;
		this.mass = mass;
		this.naturalSatellite = naturalSatellite;
		this.planetId = planetId;
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

	public Long getPlanetId() {
		return planetId;
	}

	public void setPlanetId(Long planetId) {
		this.planetId = planetId;
	}

}
