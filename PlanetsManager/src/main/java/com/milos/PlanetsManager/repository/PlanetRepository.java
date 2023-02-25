package com.milos.PlanetsManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milos.PlanetsManager.model.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

}
