package com.milos.PlanetsManager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milos.PlanetsManager.dto.SatelliteDto;
import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
import com.milos.PlanetsManager.model.Satellite;
import com.milos.PlanetsManager.serviceImpl.SatelliteServiceImpl;

@RestController
@RequestMapping("/satellite")
public class SatelliteController {

	@Autowired
	SatelliteServiceImpl satelliteService;
	
	@PostMapping
	public ResponseEntity<Satellite> createSatellite(@Valid @RequestBody SatelliteDto satelliteDto)
			throws EntityDoesNotExistException {
		Satellite satellite = satelliteService.saveSatellite(satelliteDto);
		return new ResponseEntity<Satellite>(satellite, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Satellite>> fetchSatellites() {
		return new ResponseEntity<List<Satellite>>(satelliteService.fetchSatellits(), HttpStatus.OK);
	}


}
