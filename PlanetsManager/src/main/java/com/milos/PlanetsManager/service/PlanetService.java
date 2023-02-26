package com.milos.PlanetsManager.service;

import java.util.List;

import com.milos.PlanetsManager.dto.PlanetDto;
import com.milos.PlanetsManager.exception.CustomException;
import com.milos.PlanetsManager.model.Planet;

public interface PlanetService {
	
	Planet savePlanet(Planet newPlanet);
	List<Planet> fetchPlanetList();
	Planet updatePlanet(PlanetDto updatePlanetDto);
	Boolean deletePlanetById(Long planetId);
	Planet fetchPlanetById(Long planetId) throws CustomException;
	
	
	

}
