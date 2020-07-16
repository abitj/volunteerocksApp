package com.example.demo_addFunc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_addFunc.exception.RecordNotFoundException;
import com.example.demo_addFunc.model.VolunteerEntity;
import com.example.demo_addFunc.repository.VolunteerRepository;

@Service
public class VolunteerService {
    
	
	@Autowired
	VolunteerRepository repository;
	
	public List<VolunteerEntity> getAllVolunteers()
	{
		List<VolunteerEntity> result = (List<VolunteerEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<VolunteerEntity>();
		}
	}
	
	public VolunteerEntity getVolunteerById(Long id) throws RecordNotFoundException 
	{
		Optional<VolunteerEntity> volunteer = repository.findById(id);
		
		if(volunteer.isPresent()) {
			return volunteer.get();
		} else {
			throw new RecordNotFoundException("No volunteer record exist for given id");
		}
	}
	
	public VolunteerEntity createOrUpdateVolunteer(VolunteerEntity entity) 
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<VolunteerEntity> volunteer = repository.findById(entity.getId());
			
			if(volunteer.isPresent()) 
			{
				VolunteerEntity newEntity = volunteer.get();
				newEntity.setVolEmail(entity.getVolEmail());
				newEntity.setVolFullName(entity.getVolFullName());
				newEntity.setVolLocation(entity.getVolLocation());

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteVolunteerById(Long id) throws RecordNotFoundException 
	{
		Optional<VolunteerEntity> volunteer = repository.findById(id);
		
		if(volunteer.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No volunteer record exist for given id");
		}
	} 
}