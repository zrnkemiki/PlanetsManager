package com.milos.PlanetsManager.service;

import java.util.List;
import java.util.Set;

import com.milos.PlanetsManager.exception.EntityAlreadyExistsException;
import com.milos.PlanetsManager.exception.EntityCouldNotBeDeletedException;
import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
import com.milos.PlanetsManager.model.Planet;
import com.milos.PlanetsManager.model.Satellite;

public interface PlanetService {

	Planet createPlanet(Planet newPlanet) throws EntityAlreadyExistsException;

	List<Planet> fetchPlanets(Integer pageNo, Integer pageSize, String planetName, String sortByNumOfSatelites);

	Planet updatePlanet(Planet updatePlanet) throws EntityDoesNotExistException;

	void deletePlanetById(Long planetId) throws EntityDoesNotExistException, EntityCouldNotBeDeletedException;

	Planet fetchPlanetById(Long planetId) throws EntityDoesNotExistException;

	Set<Satellite> fetchPlanetSatellites(Long planetId) throws EntityDoesNotExistException;


}
