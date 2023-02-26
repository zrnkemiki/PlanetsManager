package com.milos.PlanetsManager.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.milos.PlanetsManager.dto.SatelliteDto;
import com.milos.PlanetsManager.exception.EntityAlreadyExistsException;
import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
import com.milos.PlanetsManager.model.Planet;
import com.milos.PlanetsManager.model.Satellite;
import com.milos.PlanetsManager.repository.SatelliteRepository;
import com.milos.PlanetsManager.service.SatelliteService;

@Service
public class SatelliteServiceImpl implements SatelliteService {

	@Autowired
	SatelliteRepository satelliteRepository;

	@Autowired
	PlanetServiceImpl planetService;

	@Override
	public Satellite saveSatellite(SatelliteDto satelliteDto) throws EntityDoesNotExistException {
		Satellite satellite = new Satellite(satelliteDto);
		if (satelliteDto.getId() != null && satelliteRepository.existsById(satelliteDto.getId())) {
			throw new EntityAlreadyExistsException(HttpStatus.BAD_REQUEST, "Satellite with given ID already exists!");
		}
		Planet planet = planetService.fetchPlanetById(satelliteDto.getPlanetId());
		planet.getSatellites().add(satellite);
		planetService.updatePlanet(planet); // Saving the planet, the new satellite will be saved too!

		return satellite;
	}

	@Override
	public List<Satellite> fetchSatellits() {
		return satelliteRepository.findAll();
	}

	@Override
	public Satellite updateSatellite(Satellite updateSatellite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSatellitetById(Long satelliteId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Satellite saveSatellite(Satellite newSatellite) {
		// TODO Auto-generated method stub
		return null;
	}

}
