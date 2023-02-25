package com.milos.PlanetsManager.service;

import java.util.List;

import com.milos.PlanetsManager.model.Satellite;

public interface SatelliteService {
	Satellite saveSatellite(Satellite newSatellite);
	List<Satellite> fetchSatelliteList();
	Satellite updateSatellite(Satellite updateSatellite);
	void deleteSatellitetById(Long satelliteId);
	
}
