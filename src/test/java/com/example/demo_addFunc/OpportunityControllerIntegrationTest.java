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

import com.example.demo_addFunc.model.OpportunityEntity;
import com.example.demo_addFunc.service.OpportunityService;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoAddFuncApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OpportunityControllerIntegrationTest {
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

	/*@Test
	public void getOpportunityById() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/Opportunitys",
				HttpMethod.GET, entity, String.class);
		assert (response.getBody()) != null;
	}

*/
	@Test
	public void testGetVoluteerById() {
		OpportunityEntity opportunity = restTemplate.getForObject(getRootUrl() + "/Opportunitys/1", OpportunityEntity.class);
		System.out.println(opportunity.getOppDescription());
		assert (opportunity) != null;
	}

	@Test
	public void testCreateOpportunity() {
		OpportunityEntity Opportunity = new OpportunityEntity();
		Opportunity.setOppDescription("description");
		Opportunity.setOppLocation("location");
		Opportunity.setOppNumberNeeded(4321);

		ResponseEntity<OpportunityEntity> postResponse = restTemplate.postForEntity(getRootUrl() + "/Opportunities", Opportunity, OpportunityEntity.class);
		assert (postResponse) != null;
		assert (postResponse.getBody()) != null;
	}

	@Test
	public void testUpdateOpportunity() {
		int id = 1;
		OpportunityEntity opportunity = restTemplate.getForObject(getRootUrl() + "/Opportunitys/" + id, OpportunityEntity.class);
		opportunity.setOppDescription("new description");
		opportunity.setOppLocation("new location");
		opportunity.setOppNumberNeeded(1234);

		restTemplate.put(getRootUrl() + "/Opportunitys/" + id, opportunity);

		OpportunityEntity updatedOpportunity = restTemplate.getForObject(getRootUrl() + "/Opportunities/" + id, OpportunityEntity.class);
		assert (updatedOpportunity) != null;
	}

	@Test
	public void testDeleteOpportunityById() {
		int id = 2;
		OpportunityEntity opportunity = restTemplate.getForObject(getRootUrl() + "/Opportunities/" + id, OpportunityEntity.class);
		assert (opportunity) != null;

		restTemplate.delete(getRootUrl() + "/Opportunitys/" + id);

		try {
			opportunity = restTemplate.getForObject(getRootUrl() + "/Opportunitiess/" + id, OpportunityEntity.class);
		} catch (final HttpClientErrorException e) {
			//assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
