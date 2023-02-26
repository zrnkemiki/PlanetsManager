package com.milos.PlanetsManager.serviceImpl;

import java.util.List;
import java.util.Optional;

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
	public Satellite fetchSatelliteById(Long satelliteId) throws EntityDoesNotExistException {
		Optional<Satellite> satellite = satelliteRepository.findById(satelliteId);
		if (satellite.isEmpty()) {
			throw new EntityDoesNotExistException(HttpStatus.BAD_REQUEST,
					"Satellite with the given ID does not exist!");
		}
		return satellite.get();

	}

	@Override
	public List<Satellite> fetchSatellits() {
		return satelliteRepository.findAll();
	}

	@Override
	public Satellite updateSatellite(Satellite updateSatellite) throws EntityDoesNotExistException {
		if (updateSatellite.getId() != null && !satelliteRepository.existsById(updateSatellite.getId())) {
			throw new EntityDoesNotExistException(HttpStatus.BAD_REQUEST,
					"Satellite you are trying to UPDATE does not exist!");
		}
		return satelliteRepository.save(updateSatellite);
	}

	@Override
	public void deleteSatellitetById(Long satelliteId) throws EntityDoesNotExistException {
		if (!satelliteRepository.existsById(satelliteId)) {
			throw new EntityDoesNotExistException(HttpStatus.BAD_REQUEST,
					"Satellite could not be deleted, because it does not exist!");
		}
		satelliteRepository.deleteById(satelliteId);

	}

}
