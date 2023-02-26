package com.milos.PlanetsManager.service;

import java.util.List;

import com.milos.PlanetsManager.dto.SatelliteDto;
import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
import com.milos.PlanetsManager.model.Satellite;

public interface SatelliteService {
	Satellite saveSatellite(SatelliteDto satelliteDto) throws EntityDoesNotExistException;

	List<Satellite> fetchSatellits();

	Satellite fetchSatelliteById(Long satelliteId) throws EntityDoesNotExistException;

	Satellite updateSatellite(Satellite updateSatellite) throws EntityDoesNotExistException;

	void deleteSatellitetById(Long satelliteId) throws EntityDoesNotExistException;

}
