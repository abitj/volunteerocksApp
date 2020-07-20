package com.howtodoinjava.rest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.rest.model.VolunteerEntity;

@Repository
public interface VolunteerRepository 
			extends CrudRepository<VolunteerEntity, Long> {

}
