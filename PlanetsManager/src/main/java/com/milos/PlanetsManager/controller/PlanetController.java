package com.milos.PlanetsManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milos.PlanetsManager.serviceImpl.PlanetServiceImpl;

@RestController
@RequestMapping("/planet")
public class PlanetController {

	@Autowired
	PlanetServiceImpl planetService;

	
}
