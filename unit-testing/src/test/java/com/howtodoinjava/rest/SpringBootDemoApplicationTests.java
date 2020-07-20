package com.howtodoinjava.rest;


import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.howtodoinjava.rest.model.VolunteerEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SpringBootDemoApplicationTests 
{   
    @LocalServerPort
    int randomServerPort;
    
    @Test
    public void testAddVolunteerSuccess() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/volunteers/";
        URI uri = new URI(baseUrl);
        VolunteerEntity volunteer = new VolunteerEntity();
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      

        HttpEntity<VolunteerEntity> request = new HttpEntity<>(volunteer, headers);
        
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        
        //Verify request succeed
        Assert.assertEquals(201, result.getStatusCodeValue());
    }
    
    @Test
    public void testGetVolunteerListSuccessWithHeaders() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
        
        final String baseUrl = "http://localhost:"+randomServerPort+"/volunteers/";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-LOCATION", "USA");

        HttpEntity<VolunteerEntity> requestEntity = new HttpEntity<>(null, headers);

        try 
        {
            restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
            Assert.fail();
        }
        catch(HttpClientErrorException ex) 
        {
            //Verify bad request and missing header
            Assert.assertEquals(400, ex.getRawStatusCode());
            Assert.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
        }
    }
    
 
    @Test
    public void testAddVolunteerMissingHeader() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/volunteers/";
        URI uri = new URI(baseUrl);
        VolunteerEntity volunteer = new VolunteerEntity();
        
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<VolunteerEntity> request = new HttpEntity<>(volunteer, headers);
        
        try 
        {
            restTemplate.postForEntity(uri, request, String.class);
            Assert.fail();
        }
        catch(HttpClientErrorException ex) 
        {
            //Verify bad request and missing header
            Assert.assertEquals(400, ex.getRawStatusCode());
            Assert.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
        }
    }
}
