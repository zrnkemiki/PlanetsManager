package com.milos.PlanetsManager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
import com.milos.PlanetsManager.model.Planet;
import com.milos.PlanetsManager.model.Satellite;
import com.milos.PlanetsManager.repository.PlanetRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PlanetServiceTest {

	@MockBean
	PlanetRepository planetRepository;

	@Autowired
	PlanetService planetService;

	@Test
	public void testCreatePlanet() {
		Satellite moonSatellite = new Satellite(1L, "Moon", 1111L, 1111L, true);
		Set<Satellite> earthSatellites = new HashSet<>();
		earthSatellites.add(moonSatellite);
		Planet planet = new Planet(1L, "Earth", 123L, 123L, 123L, 15, earthSatellites);
		when(planetRepository.save(planet)).thenReturn(planet);
		assertEquals(planet, planetService.savePlanet(planet));
	}

	@Test
	public void testFetchPlanetById() throws EntityDoesNotExistException {
		Satellite moonSatellite = new Satellite(1L, "Moon", 1111L, 1111L, true);
		Set<Satellite> earthSatellites = new HashSet<>();
		earthSatellites.add(moonSatellite);
		Planet planet = new Planet(1L, "Earth", 123L, 123L, 123L, 15, earthSatellites);
		when(planetRepository.findById(planet.getId())).thenReturn(Optional.of(planet));
		assertEquals("Earth", planetService.fetchPlanetById(1L).getName());

	}
}