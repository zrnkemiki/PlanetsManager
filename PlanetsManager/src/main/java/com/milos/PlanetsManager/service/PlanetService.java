package com.milos.PlanetsManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milos.PlanetsManager.repository.PlanetRepository;

@Service
public class PlanetService {
	
	@Autowired
	PlanetRepository planetRepository;

}
