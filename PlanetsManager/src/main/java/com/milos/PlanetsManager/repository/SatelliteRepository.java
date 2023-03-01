package com.milos.PlanetsManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milos.PlanetsManager.model.Satellite;

@Repository
public interface SatelliteRepository extends JpaRepository<Satellite, Long> {

	boolean existsByName(String name);

}
