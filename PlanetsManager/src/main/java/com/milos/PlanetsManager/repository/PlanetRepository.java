package com.milos.PlanetsManager.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milos.PlanetsManager.model.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
	
	boolean existsByName(String planetName);
	List<Planet> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

}
