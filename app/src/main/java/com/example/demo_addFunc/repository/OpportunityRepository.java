/**
 * Opportunity repository, extends CrudRepository
 */
package com.example.demo_addFunc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_addFunc.model.OpportunityEntity;

@Repository
public interface OpportunityRepository
    extends CrudRepository<OpportunityEntity, Long> {
    
}