/**
 * Implementation of the OPPORTUNITIES table
 */
package com.example.demo_addFunc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_OPPORTUNITIES")
public class OpportunityEntity {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="description", nullable=false, length=200)
    private String Description;
    
    @Column(name="location")
    private String Location;
    
    @Column(name="number_needed")
    private int NumberNeeded;
	
	/**
	 * Retrieves record id for this opportunity
	 * 
	 */
    public Long getId() {
		return id;
	}

	/**
	 * Assigns record id for this opportunity
	 * 
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retrieves description for the opportunity
	 * 
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * Assigns description for the opportunity
	 * 
	 */
	public void setDescription(String Description) {
		this.Description = Description;
	}

	/**
	 * Retrieves location of the opportunity
	 * 
	 */
	public String getLocation() {
		return Location;
	}

	/**
	 * Assigns location of the opportunity
	 * 
	 */
	public void setLocation(String Location) {
		this.Location = Location;
	}

	/**
	 * Retrieves the number of volunteers requested
	 * 
	 */
	public int getNumberNeeded() {
		return NumberNeeded;
	}

	/**
	 * Assigns the number of volunteers requested
	 * 
	 */
	public void setNumberNeeded(int NumberNeeded) {
		this.NumberNeeded = NumberNeeded;
	}

	/**
	 * Returns a string representation of the currently loaded volunteer data
	 */
    @Override
    public String toString() {
        return "OpportunityEntity [id=" + id + ", Description=" + Description + 
                ", Location=" + Location + ", NumberNeeded=" + NumberNeeded + "]";
    }
}