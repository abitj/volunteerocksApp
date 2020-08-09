/**
 * Organization repository, extends CrudRepository
 */
package com.example.demo_addFunc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_addFunc.model.OrganizationEntity;

/**
 * OrganizationRepository, extends CrudRepository
 */
@Repository
public interface OrganizationRepository
    extends CrudRepository<OrganizationEntity, Long> {
    
}