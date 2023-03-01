package com.milos.PlanetsManager.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.milos.PlanetsManager.model.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

	boolean existsByName(String planetName);

	@Query(value = "SELECT planets.*, COUNT(satellites.id) AS num_satellites " + "FROM planets "
			+ "LEFT JOIN satellites ON planets.id = satellites.planet_id " + "GROUP BY planets.id "
			+ "ORDER BY num_satellites ASC", nativeQuery = true)
	Page<Planet> findAndSortBySatellitesASC(Pageable pageable);

	@Query(value = "SELECT planets.*, COUNT(satellites.id) AS num_satellites " + "FROM planets "
			+ "LEFT JOIN satellites ON planets.id = satellites.planet_id " + "GROUP BY planets.id "
			+ "ORDER BY num_satellites DESC", nativeQuery = true)
	Page<Planet> findAndSortBySatellitesDESC(Pageable pageable);

	@Query(value = "SELECT planets.*, COUNT(satellites.id) AS num_satellites " + "FROM planets "
			+ "LEFT JOIN satellites ON planets.id = satellites.planet_id "
			+ "WHERE LOWER(planets.name) LIKE LOWER(concat('%', :name, '%')) " + "GROUP BY planets.id "
			+ "ORDER BY num_satellites DESC", nativeQuery = true)
	List<Planet> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

	@Query(value = "SELECT planets.*, COUNT(satellites.id) AS num_satellites " + "FROM planets "
			+ "LEFT JOIN satellites ON planets.id = satellites.planet_id "
			+ "WHERE LOWER(planets.name) LIKE LOWER(concat('%', :name, '%')) " + "GROUP BY planets.id "
			+ "ORDER BY num_satellites DESC", nativeQuery = true)
	List<Planet> findAllByNameContainingIgnoreCaseDESC(String name, Pageable pageable);

	@Query(value = "SELECT planets.*, COUNT(satellites.id) AS num_satellites " + "FROM planets "
			+ "LEFT JOIN satellites ON planets.id = satellites.planet_id "
			+ "WHERE LOWER(planets.name) LIKE LOWER(concat('%', :name, '%')) " + "GROUP BY planets.id "
			+ "ORDER BY num_satellites ASC", nativeQuery = true)
	List<Planet> findAllByNameContainingIgnoreCaseASC(String name, Pageable pageable);

}
