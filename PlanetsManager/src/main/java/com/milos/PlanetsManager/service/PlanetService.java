package com.milos.PlanetsManager.service;

import java.util.List;

import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
import com.milos.PlanetsManager.model.Planet;

public interface PlanetService {
	
	Planet savePlanet(Planet newPlanet);
	List<Planet> fetchPlanets();
	Planet updatePlanet(Planet updatePlanet) throws EntityDoesNotExistException;
	void deletePlanetById(Long planetId) throws EntityDoesNotExistException;
	Planet fetchPlanetById(Long planetId) throws EntityDoesNotExistException;
	
	
	

}
