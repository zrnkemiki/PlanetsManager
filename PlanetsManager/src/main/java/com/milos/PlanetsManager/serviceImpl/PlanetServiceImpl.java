package com.milos.PlanetsManager.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.milos.PlanetsManager.exception.EntityAlreadyExistsException;
import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
import com.milos.PlanetsManager.model.Planet;
import com.milos.PlanetsManager.model.Satellite;
import com.milos.PlanetsManager.repository.PlanetRepository;
import com.milos.PlanetsManager.service.PlanetService;

@Service
public class PlanetServiceImpl implements PlanetService {

	@Autowired
	PlanetRepository planetRepository;

	@Override
	public Planet savePlanet(Planet newPlanet) {
		if (planetRepository.existsByName(newPlanet.getName())) {
			throw new EntityAlreadyExistsException(HttpStatus.BAD_REQUEST, "Planet with given name already exists!");
		}
		if (newPlanet.getId() != null && planetRepository.existsById(newPlanet.getId())) {
			throw new EntityAlreadyExistsException(HttpStatus.BAD_REQUEST, "Planet with given ID already exists!");
		}

		return planetRepository.save(newPlanet);
	}

	@Override
	public Planet updatePlanet(Planet updatePlanet) throws EntityDoesNotExistException {
		if (updatePlanet.getId() != null && !planetRepository.existsById(updatePlanet.getId())) {
			throw new EntityDoesNotExistException(HttpStatus.BAD_REQUEST,
					"Planet you are trying to UPDATE does not exist!");
		}
		return planetRepository.save(updatePlanet);

	}

	@Override
	public void deletePlanetById(Long planetId) throws EntityDoesNotExistException {
		if (!planetRepository.existsById(planetId)) {
			throw new EntityDoesNotExistException(HttpStatus.BAD_REQUEST,
					"Planet could not be deleted, because it does not exist!");
		}
		planetRepository.deleteById(planetId);
	}

	@Override
	public Planet fetchPlanetById(Long planetId) throws EntityDoesNotExistException {
		Optional<Planet> planet = planetRepository.findById(planetId);
		if (planet.isEmpty()) {
			throw new EntityDoesNotExistException(HttpStatus.BAD_REQUEST, "Planet with the given ID does not exist!");
		}
		return planet.get();

	}

	@Override
	public Set<Satellite> fetchPlanetSatellites(Long planetId) throws EntityDoesNotExistException {
		Optional<Planet> planet = planetRepository.findById(planetId);
		if (planet.isEmpty()) {
			throw new EntityDoesNotExistException(HttpStatus.BAD_REQUEST, "Planet with the given ID does not exist!");
		}
		return planet.get().getSatellites();

	}

	// filter by planet name and sortBy number of satellites
	@Override
	public List<Planet> fetchPlanets(Integer pageNo, Integer pageSize, String planetName,
			String sortBy) {
		Pageable paging;
		paging = PageRequest.of(pageNo, pageSize);
		//List<Planet> planets = new ArrayList<>();
		if(planetName==null) {
			if(sortBy.equalsIgnoreCase("ASC")) {
				return planetRepository.findAndSortBySatellitesASC(paging).getContent();
			}
			else {
				return planetRepository.findAndSortBySatellitesDESC(paging).getContent();
			}
		}
		else {
			return planetRepository.findAllByNameContainingIgnoreCase(planetName, paging);
		}
		
		
		

	}

}
