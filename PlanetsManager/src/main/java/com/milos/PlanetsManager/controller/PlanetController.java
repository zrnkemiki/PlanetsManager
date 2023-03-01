package com.milos.PlanetsManager.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.milos.PlanetsManager.exception.EntityAlreadyExistsException;
import com.milos.PlanetsManager.exception.EntityCouldNotBeDeletedException;
import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
import com.milos.PlanetsManager.model.Planet;
import com.milos.PlanetsManager.model.Satellite;
import com.milos.PlanetsManager.serviceImpl.PlanetServiceImpl;

@RestController
@RequestMapping("/planet")
public class PlanetController {

	@Autowired
	PlanetServiceImpl planetService;

	@PostMapping
	public ResponseEntity<Planet> createPlanet(@Valid @RequestBody Planet newPlanet) {
		Planet planet = planetService.savePlanet(newPlanet);
		return new ResponseEntity<Planet>(planet, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Planet>> fetchPlanets(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(required = false) String planetName,
			@RequestParam(defaultValue = "ASC", required = false) String sortBy) {
		List<Planet> planets = planetService.fetchPlanets(pageNo, pageSize, planetName, sortBy);
		return new ResponseEntity<List<Planet>>(planets, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Planet> fetchPlanet(@PathVariable("id") Long planetId) throws EntityDoesNotExistException {
		Planet planet = planetService.fetchPlanetById(planetId);
		return new ResponseEntity<Planet>(planet, HttpStatus.OK);

	}

	@GetMapping(value = "/{id}/satellites")
	public ResponseEntity<Set<Satellite>> fetchPlanetSatellites(@PathVariable("id") Long planetId)
			throws EntityDoesNotExistException {
		Set<Satellite> satellites = planetService.fetchPlanetSatellites(planetId);
		return new ResponseEntity<Set<Satellite>>(satellites, HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Planet> updatePlanet(@Valid @RequestBody Planet updatePlanet)
			throws EntityDoesNotExistException {
		Planet updatedPlanet = planetService.updatePlanet(updatePlanet);
		return new ResponseEntity<Planet>(updatedPlanet, HttpStatus.OK);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deletePlanet(@PathVariable("id") Long planetId)
			throws EntityDoesNotExistException, EntityCouldNotBeDeletedException {
		planetService.deletePlanetById(planetId);
		return new ResponseEntity<>("Planet deleted successfully", HttpStatus.OK);
	}

	@ExceptionHandler(value = EntityAlreadyExistsException.class)
	public ResponseEntity<String> handleEntityAlreadyExistsException(
			EntityAlreadyExistsException entityAlreadyExistsException) {
		return new ResponseEntity<String>(entityAlreadyExistsException.getMessage(),
				entityAlreadyExistsException.getHttpStatus());
	}

	@ExceptionHandler(value = EntityDoesNotExistException.class)
	public ResponseEntity<String> handleDoesNotExistsException(
			EntityDoesNotExistException entityDoesNotExistException) {
		return new ResponseEntity<String>(entityDoesNotExistException.getMessage(),
				entityDoesNotExistException.getHttpStatus());
	}

	@ExceptionHandler(value = EntityCouldNotBeDeletedException.class)
	public ResponseEntity<String> handleEntityCouldNotBeDeletedException(
			EntityCouldNotBeDeletedException entityCouldNotBeDeletedException) {
		return new ResponseEntity<String>(entityCouldNotBeDeletedException.getMessage(),
				entityCouldNotBeDeletedException.getHttpStatus());
	}

}
