package com.milos.PlanetsManager.service;

import java.util.List;

import com.milos.PlanetsManager.dto.SatelliteDto;
import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
import com.milos.PlanetsManager.model.Satellite;

public interface SatelliteService {
	Satellite saveSatellite(SatelliteDto satelliteDto) throws EntityDoesNotExistException;

	List<Satellite> fetchSatellits();

	Satellite updateSatellite(Satellite updateSatellite);

	void deleteSatellitetById(Long satelliteId);

	Satellite saveSatellite(Satellite newSatellite);

}
