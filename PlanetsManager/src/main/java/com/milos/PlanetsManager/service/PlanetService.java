package com.milos.PlanetsManager.service;

import java.util.List;
import java.util.Set;

import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
import com.milos.PlanetsManager.model.Planet;
import com.milos.PlanetsManager.model.Satellite;

public interface PlanetService {

	Planet savePlanet(Planet newPlanet);

	List<Planet> fetchPlanets(Integer pageNo, Integer pageSize, String planetName, boolean sortByNumOfSatelites);

	Planet updatePlanet(Planet updatePlanet) throws EntityDoesNotExistException;

	void deletePlanetById(Long planetId) throws EntityDoesNotExistException;

	Planet fetchPlanetById(Long planetId) throws EntityDoesNotExistException;

	Set<Satellite> fetchPlanetSatellites(Long planetId) throws EntityDoesNotExistException;


}
