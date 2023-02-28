package com.milos.PlanetsManager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	public void fetchSatellites() {
		Satellite moonSatellite = new Satellite(1L, "Moon", 1111L, 1111L, true);
		Satellite phobosSatellite = new Satellite(2L, "Phobos", 2222L, 2222L, true);
		List<Satellite> satellites = new ArrayList<>();
		satellites.add(moonSatellite);
		satellites.add(phobosSatellite);
		
		when(satelliteRepository.findAll()).thenReturn(satellites);
		assertEquals(satellites, satelliteService.fetchSatellits());
		
	}
	
	@Test
	public void fetchSatelliteById() throws EntityDoesNotExistException {
		Satellite moonSatellite = new Satellite(1L, "Moon", 1111L, 1111L, true);		
		when(satelliteRepository.findById(moonSatellite.getId())).thenReturn(Optional.of(moonSatellite));
		assertEquals(moonSatellite, satelliteService.fetchSatelliteById(moonSatellite.getId()));
		
	}
}