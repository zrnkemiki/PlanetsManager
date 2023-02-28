package com.milos.PlanetsManager.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.milos.PlanetsManager.model.Planet;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PlanetControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	HttpHeaders headers = new HttpHeaders();

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void testCreatePlanet() {
		Planet planet = new Planet(1L, "Planet test", 111L, 111L, 111L, 111, new HashSet<>());
		ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(createURLWithPort("/planet"), planet,
				String.class);
		String expected = "{\"id\":1,\"name\":\"Planet test\",\"surfaceArea\":111,\"mass\":111,\"distanceFromSun\""
				+ ":111,\"averageSurfaceTemperature\":111,\"satellites\":[]}";
		assertEquals(expected, responseEntity.getBody());
		assertEquals(201, responseEntity.getStatusCodeValue());

	}

	@Test
	public void testCreatePlanetWithExistingName() {
		Planet planet = new Planet(1234L, "Earth", 111L, 111L, 111L, 111, new HashSet<>());
		ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(createURLWithPort("/planet"), planet,
				String.class);
		String expected = "Planet with given name already exists!";
		assertEquals(expected, responseEntity.getBody());
		assertEquals(400, responseEntity.getStatusCodeValue());

	}
	
	@Test
	public void testFetchPlanetsByName() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(createURLWithPort("/planet?planetName=earth"), HttpMethod.GET,
				entity, String.class);
		String expected = "[{\"id\":111,\"name\":\"Earth\",\"surfaceArea\":123,\"mass\":1111,\"distanceFromSun\":111,\""
				+ "averageSurfaceTemperature\":11,\"satellites\":[{\"id\":111,\"name\":\"Moon\",\"surfaceArea\":1111,\""
				+ "mass\":11,\"naturalSatellite\":true}]}]";
		System.out.println(responseEntity.getBody());
		assertEquals(expected, responseEntity.getBody());

	}

	@Test
	public void testFetchPlanetById() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(createURLWithPort("/planet/111"), HttpMethod.GET,
				entity, String.class);
		String expected = "{\"id\":111,\"name\":\"Earth\",\"surfaceArea\":123,\"mass\":1111,\"distanceFromSun\":111,\""
				+ "averageSurfaceTemperature\":11,\"satellites\":[{\"id\":111,\"name\":\"Moon\",\"surfaceArea\":1111,\""
				+ "mass\":11,\"naturalSatellite\":true}]}";
		assertEquals(expected, responseEntity.getBody());
	}

}
