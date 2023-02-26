package com.milos.PlanetsManager.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milos.PlanetsManager.dto.PlanetDto;
import com.milos.PlanetsManager.model.Planet;
import com.milos.PlanetsManager.repository.PlanetRepository;
import com.milos.PlanetsManager.service.PlanetService;

@Service
public class PlanetServiceImpl implements PlanetService {

	@Autowired
	PlanetRepository planetRepository;

	@Override
	public Planet savePlanet(Planet newPlanet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planet> fetchPlanetList() {
		return planetRepository.findAll();
	}

	@Override
	public Planet updatePlanet(PlanetDto updatePlanetDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deletePlanetById(Long planetId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Planet fetchPlanetById(Long planetId) {
		// TODO Auto-generated method stub
		return null;
	}

}
