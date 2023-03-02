package com.milos.PlanetsManager.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.milos.PlanetsManager.model.Satellite;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SatelliteControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	HttpHeaders headers = new HttpHeaders();

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void testCreateSatelliteWithNoName() {
		Satellite satellite = new Satellite(1L, "", 1111L, 1111L, true);
		ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(createURLWithPort("/satellite"),
				satellite, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}

	@Test
	public void testFetchSatelliteById() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(createURLWithPort("/satellite/111"),
				HttpMethod.GET, entity, String.class);
		String expected = "{\"id\":111,\"name\":\"Moon\",\"surfaceArea\""
				+ ":1111,\"mass\":11,\"naturalSatellite\":true}";
		assertEquals(expected, responseEntity.getBody());

	}

	@Test
	public void testFetchSatelliteByNonExistingId() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(createURLWithPort("/satellite/1"), HttpMethod.GET,
				entity, String.class);
		String expected = "Satellite with the given ID does not exist!";
		assertEquals(expected, responseEntity.getBody());
		assertEquals(400, responseEntity.getStatusCodeValue());
	}

	public void testFetchSatellites() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(createURLWithPort("/satellite"), HttpMethod.GET,
				entity, String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	}

}
