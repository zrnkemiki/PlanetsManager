package com.milos.PlanetsManager.service;

import java.util.List;

import com.milos.PlanetsManager.model.Planet;

public interface PlanetService {
	
	Planet savePlanet(Planet newPlanet);
	List<Planet> fetchPlanetList();
	Planet updatePlanet(Planet updatePlanet);
	void deletePlanetById(Long planetId);
	
	
	
	

}
