/**
 * Implements the Opportunity service functions
 */
package com.example.demo_addFunc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_addFunc.exception.RecordNotFoundException;
import com.example.demo_addFunc.model.OpportunityEntity;
import com.example.demo_addFunc.repository.OpportunityRepository;

@Service
public class OpportunityService {
    
	
	@Autowired
	OpportunityRepository repository;
	
	/**
	 * Generate a list of opportunities
	 * @return List of OpportunityEntity objects or new ArrayList of OpportunityEntity if list is empty
	 */
	public List<OpportunityEntity> getAllOpportunities()
	{
		List<OpportunityEntity> result = (List<OpportunityEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<OpportunityEntity>();
		}
	}
	
	/**
	 * Retrieve an opportunity using the id for the index/key
	 * @param id - unique id of opportunity to retrieve
	 * @return opportunity object matching the id parameter
	 * @throws RecordNotFoundException
	 */
	public OpportunityEntity getOpportunityById(Long id) throws RecordNotFoundException 
	{
		Optional<OpportunityEntity> opportunity = repository.findById(id);
		
		if(opportunity.isPresent()) {
			return opportunity.get();
		} else {
			throw new RecordNotFoundException("No opportunity record exist for given id");
		}
	}
	
	/**
	 * Sign up for a volunteering opportunity
	 * @param entity - the opportunity to sign up for
	 * @return opportunity just signed up for
	 */
	public OpportunityEntity signUp(OpportunityEntity entity)
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			return entity;
		} 
		return entity;
	}
	
	/**
	 * Create a new or update an existing opportunity
	 * @param entity - opportunity to update, if empty then create a new opportunity
	 * @return opportunity entity object just edited or created
	 */
	public OpportunityEntity createOrUpdateOpportunity(OpportunityEntity entity) 
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<OpportunityEntity> opportunity = repository.findById(entity.getId());
			
			if(opportunity.isPresent()) 
			{
				OpportunityEntity newEntity = opportunity.get();
				newEntity.setDescription(entity.getDescription());
				newEntity.setNumberNeeded(entity.getNumberNeeded());
				newEntity.setLocation(entity.getLocation());

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	/**
	 * Delete an opportunity 
	 * @param id - unique id of the opportunity to delete
	 * @throws RecordNotFoundException
	 */
	public void deleteOpportunityById(Long id) throws RecordNotFoundException 
	{
		Optional<OpportunityEntity> opportunity = repository.findById(id);
		
		if(opportunity.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No volunteer record exist for given id");
		}
	} 
}