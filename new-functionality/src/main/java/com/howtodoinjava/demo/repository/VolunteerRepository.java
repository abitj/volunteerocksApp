package com.howtodoinjava.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.VolunteerEntity;

@Repository
public interface VolunteerRepository 
			extends CrudRepository<VolunteerEntity, Long> {

}
