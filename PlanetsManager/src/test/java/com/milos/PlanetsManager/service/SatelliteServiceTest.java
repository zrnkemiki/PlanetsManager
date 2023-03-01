package com.milos.PlanetsManager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.milos.PlanetsManager.dto.SatelliteDto;
import com.milos.PlanetsManager.exception.EntityAlreadyExistsException;
import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
import com.milos.PlanetsManager.model.Satellite;
import com.milos.PlanetsManager.repository.SatelliteRepository;
import com.milos.PlanetsManager.serviceImpl.SatelliteServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SatelliteServiceTest {

	@MockBean
	SatelliteRepository satelliteRepository;
	
	@Autowired
	SatelliteServiceImpl satelliteService;
	
	@Test
	public void testFetchSatellites() {
		Satellite moonSatellite = new Satellite(1L, "Moon", 1111L, 1111L, true);
		Satellite phobosSatellite = new Satellite(2L, "Phobos", 2222L, 2222L, true);
		List<Satellite> satellites = new ArrayList<>();
		satellites.add(moonSatellite);
		satellites.add(phobosSatellite);
		
		when(satelliteRepository.findAll()).thenReturn(satellites);
		assertEquals(satellites, satelliteService.fetchSatellits());
		
	}
	
	@Test
	public void testCreateSatelliteWithExistingName() {
		SatelliteDto moonSatelliteDto = new SatelliteDto(1L, "Phobos", 1L, 1L, true, null);
		when(satelliteRepository.existsByName(moonSatelliteDto.getName())).thenReturn(true);
		Exception exception = assertThrows(EntityAlreadyExistsException.class, () -> {
			satelliteService.saveSatellite(moonSatelliteDto);
		});
		String expectedMessage = "Satellite with given name already exists!";
		System.out.println(exception.getMessage());
		assertTrue(expectedMessage.contains(exception.getMessage()));
	}
	
	@Test
	public void testFetchSatelliteById() throws EntityDoesNotExistException {
		Satellite moonSatellite = new Satellite(1L, "Moon", 1111L, 1111L, true);		
		when(satelliteRepository.findById(moonSatellite.getId())).thenReturn(Optional.of(moonSatellite));
		assertEquals(moonSatellite, satelliteService.fetchSatelliteById(moonSatellite.getId()));
		
	}
	
	@Test
	public void testFetchSatelliteByNonExistingId() throws EntityDoesNotExistException {		
		when(satelliteRepository.findById(1L)).thenReturn(Optional.empty());
		Exception exception = assertThrows(EntityDoesNotExistException.class, () -> {
			satelliteService.fetchSatelliteById(1L);
		});
		String expectedMessage = "Satellite with the given ID does not exist!";
		assertTrue(expectedMessage.contains(exception.getMessage()));
		
	}
	
	@Test()
	public void testDeleteNotExistingSatellite() {
		Long satelliteId = 12345L;
		when(satelliteRepository.findById(satelliteId)).thenReturn(Optional.empty());
		Exception exception = assertThrows(EntityDoesNotExistException.class, () -> {
			satelliteService.deleteSatellitetById(satelliteId);
		});
		String expectedMessage = "Satellite could not be deleted, because it does not exist!";
		assertTrue(expectedMessage.contains(exception.getMessage()));

	}
}