package com.example.demo_addFunc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo_addFunc.model.VolunteerEntity;
import com.example.demo_addFunc.service.VolunteerService;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoAddFuncApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VolunteerControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetVoluteerById() {
		VolunteerEntity volunteer = restTemplate.getForObject(getRootUrl() + "/volunteers/1", VolunteerEntity.class);
		System.out.println(volunteer.getVolFullName());
		assert (volunteer) != null;
	}

	@Test
	public void testCreateVolunteer() {
		VolunteerEntity volunteer = new VolunteerEntity();
		volunteer.setVolEmail("admin@gmail.com");
		volunteer.setVolFullName("admin");
		volunteer.setVolLocation("admin");

		ResponseEntity<VolunteerEntity> postResponse = restTemplate.postForEntity(getRootUrl() + "/volunteers", volunteer, VolunteerEntity.class);
		assert (postResponse) != null;
		assert (postResponse.getBody()) != null;
	}

	@Test
	public void testUpdateVolunteer() {
		int id = 1;
		VolunteerEntity volunteer = restTemplate.getForObject(getRootUrl() + "/volunteers/" + id, VolunteerEntity.class);
		volunteer.setVolFullName("admin1");
		volunteer.setVolLocation("admin2");

		restTemplate.put(getRootUrl() + "/volunteers/" + id, volunteer);

		VolunteerEntity updatedVolunteer = restTemplate.getForObject(getRootUrl() + "/volunteers/" + id, VolunteerEntity.class);
		assert (updatedVolunteer) != null;
	}

	@Test
	public void testDeleteVolunteerById() {
		int id = 2;
		VolunteerEntity volunteer = restTemplate.getForObject(getRootUrl() + "/volunteers/" + id, VolunteerEntity.class);
		assert (volunteer) != null;

		restTemplate.delete(getRootUrl() + "/volunteers/" + id);

		try {
			volunteer = restTemplate.getForObject(getRootUrl() + "/volunteers/" + id, VolunteerEntity.class);
		} catch (final HttpClientErrorException e) {
			//assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}







