package com.milos.PlanetsManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milos.PlanetsManager.repository.SatelliteRepository;

@Service
public class SatelliteService {
	
	@Autowired
	SatelliteRepository satelliteRepository;

}
