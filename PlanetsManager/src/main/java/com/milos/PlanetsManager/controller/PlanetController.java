package com.milos.PlanetsManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milos.PlanetsManager.dto.PlanetDto;
import com.milos.PlanetsManager.model.Planet;
import com.milos.PlanetsManager.serviceImpl.PlanetServiceImpl;

@RestController
@RequestMapping("/planet")
public class PlanetController {

	@Autowired
	PlanetServiceImpl planetService;

	@PostMapping
	public ResponseEntity<Planet> createPlanet(@RequestBody Planet newPlanet) {
		// TODO Auto-generated catch block
		return null;
	}

	@GetMapping
	public ResponseEntity<List<Planet>> fetchPlanets() {
		// TODO Auto-generated catch block
		return null;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Planet> fetchPlanet(@PathVariable Long id) {
		// TODO Auto-generated catch block
		return null;
	}

	@PutMapping
	public ResponseEntity<Planet> updatePlanet(@RequestBody PlanetDto updatePlanetDto) {
		// TODO Auto-generated catch block
		return null;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletePlanet(@PathVariable Long id) {
		// TODO Auto-generated catch block
		return null;
	}

}
