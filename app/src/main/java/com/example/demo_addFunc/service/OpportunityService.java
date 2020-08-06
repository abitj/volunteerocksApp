/**
 * Opportunity service member implementations
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
	
	public List<OpportunityEntity> getAllOpportunities()
	{
		List<OpportunityEntity> result = (List<OpportunityEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<OpportunityEntity>();
		}
	}
	
	public OpportunityEntity getOpportunityById(Long id) throws RecordNotFoundException 
	{
		Optional<OpportunityEntity> opportunity = repository.findById(id);
		
		if(opportunity.isPresent()) {
			return opportunity.get();
		} else {
			throw new RecordNotFoundException("No opportunity record exist for given id");
		}
	}
	
	public OpportunityEntity signUp(OpportunityEntity entity)
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			return entity;
		} 
		return entity;
	}
	
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