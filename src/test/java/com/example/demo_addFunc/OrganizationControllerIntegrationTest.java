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
import com.example.demo_addFunc.model.OrganizationEntity;
import com.example.demo_addFunc.service.OrganizationService;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoAddFuncApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrganizationControllerIntegrationTest {
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
	public void testGetOrganizationById() {
		OrganizationEntity organization = restTemplate.getForObject(getRootUrl() + "/Organizations/1", OrganizationEntity.class);
		System.out.println(organization.getTitle());
		assert (organization) != null;
	}

	@Test
	public void testCreateOrganization() {
		OrganizationEntity organization = new OrganizationEntity();
		organization.setTitle("value for title");
		organization.setDescription("value for description");
		organization.setLocation("value for location");

		ResponseEntity<OrganizationEntity> postResponse = restTemplate.postForEntity(getRootUrl() + "/Organizations", organization, OrganizationEntity.class);
		assert (postResponse) != null;
		assert (postResponse.getBody()) != null;
	}

	@Test
	public void testUpdateOrganization() {
		int id = 1;
		OrganizationEntity organization = restTemplate.getForObject(getRootUrl() + "/Organizations/" + id, OrganizationEntity.class);
		organization.setTitle("new value for title");
		organization.setDescription("new value for description");

		restTemplate.put(getRootUrl() + "/Organizations/" + id, organization);

		OrganizationEntity updatedOrganization = restTemplate.getForObject(getRootUrl() + "/Organizations/" + id, OrganizationEntity.class);
		assert (updatedOrganization) != null;
	}

	@Test
	public void testDeleteOrganizationById() {
		int id = 2;
		OrganizationEntity organization = restTemplate.getForObject(getRootUrl() + "/Organizations/" + id, OrganizationEntity.class);
		assert (organization) != null;

		restTemplate.delete(getRootUrl() + "/Organizations/" + id);

		try {
			organization = restTemplate.getForObject(getRootUrl() + "/Organizations/" + id, OrganizationEntity.class);
		} catch (final HttpClientErrorException e) {
			//assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
		
		
		@Test
		public void testGetOpportunityById() {
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


