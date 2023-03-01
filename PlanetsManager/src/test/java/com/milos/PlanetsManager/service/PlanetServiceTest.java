package com.milos.PlanetsManager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

import com.milos.PlanetsManager.exception.EntityAlreadyExistsException;
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
		assertEquals(planet.getName(), planetService.savePlanet(planet).getName());
	}

	@Test
	public void testCreatePlanetWithExistingName() {
		Satellite moonSatellite = new Satellite(1L, "Moon", 1111L, 1111L, true);
		Set<Satellite> earthSatellites = new HashSet<>();
		earthSatellites.add(moonSatellite);
		Planet planet = new Planet(1L, "Earth", 123L, 123L, 123L, 15, earthSatellites);
		when(planetRepository.existsByName(planet.getName())).thenReturn(true);
		Exception exception = assertThrows(EntityAlreadyExistsException.class, () -> {
			planetService.savePlanet(planet);
		});
		String expectedMessage = "Planet with given name already exists!";
		assertTrue(expectedMessage.contains(exception.getMessage()));
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

	@Test()
	public void testPlanetNotFound() throws EntityDoesNotExistException {
		Long planetId = 12345L;
		when(planetRepository.findById(planetId)).thenReturn(Optional.empty());
		Exception exception = assertThrows(EntityDoesNotExistException.class, () -> {
			planetService.fetchPlanetById(planetId);
		});
		String expectedMessage = "Planet with the given ID does not exist!";
		assertTrue(expectedMessage.contains(exception.getMessage()));

	}

	@Test()
	public void testDeleteNotExistingPlanet() {
		Long planetId = 12345L;
		when(planetRepository.findById(planetId)).thenReturn(Optional.empty());
		Exception exception = assertThrows(EntityDoesNotExistException.class, () -> {
			planetService.deletePlanetById(planetId);
		});
		System.out.println(exception.getMessage());
		String expectedMessage = "Planet could not be deleted, because it does not exist!";
		assertTrue(expectedMessage.contains(exception.getMessage()));

	}
}