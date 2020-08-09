/**
 * Implements the Volunteer service functions
 */
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
	
	/**
	 * Generate a list of volunteers
	 * @return List of VolunteerEntity objects or new ArrayList of VolunteerEntity if list is empty
	 */
	public List<VolunteerEntity> getAllVolunteers()
	{
		List<VolunteerEntity> result = (List<VolunteerEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<VolunteerEntity>();
		}
	}
	
	/**
	 * Retrieve a volunteer using the id for the index/key
	 * @param id - unique id of volunteer to retrieve
	 * @return volunteer object matching the id parameter
	 * @throws RecordNotFoundException
	 */
	public VolunteerEntity getVolunteerById(Long id) throws RecordNotFoundException 
	{
		Optional<VolunteerEntity> volunteer = repository.findById(id);
		
		if(volunteer.isPresent()) {
			return volunteer.get();
		} else {
			throw new RecordNotFoundException("No volunteer record exist for given id");
		}
	}
	
	/**
	 * Create a new or update an existing volunteer
	 * @param entity - volunteer to update, if empty then create a new volunteer
	 * @return volunteer entity object just edited or created
	 */
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
				newEntity.setEmail(entity.getEmail());
				newEntity.setFullName(entity.getFullName());
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
	 * Delete a volunteer 
	 * @param id - unique id of the volunteer to delete
	 * @throws RecordNotFoundException
	 */
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