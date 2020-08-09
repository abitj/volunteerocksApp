/**
 * Implementation of the ORGANIZATION table
 */
package com.example.demo_addFunc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ORGANIZATION")
public class OrganizationEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="title", nullable=false, length=250)
    private String Title;

    @Column(name="description", nullable=false, length=250)
    private String Description;
    
    @Column(name="location", nullable=false, length=250)
    private String Location;
    
    @Column(name="volunteers")
    private int Volunteers;
    
	/**
	 * Retrieves auto-generated record id 
	 * 
	 */
    public Long getId() {
		return id;
	}

	/**
	 * Assigns new record id 
	 * 
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retrieves the title of this opportunity
	 * 
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * Assigns title of this opportunity
	 * 
	 */
	public void setTitle(String Title) {
		this.Title = Title;
    }
    
	/**
	 * Retrieves description of this opportunity
	 * 
	 */
    public String getDescription() {
		return Description;
	}

	/**
	 * Assigns description of this opportunity
	 * 
	 */
	public void setDescription(String Description) {
		this.Description = Description;
	}

	/**
	 * Retrieves location of this opportunity
	 * 
	 */
	public String getLocation() {
		return Location;
	}

	/**
	 * Assigns location of this opportunity
	 * 
	 */
	public void setLocation(String Location) {
		this.Location = Location;
	}

	/**
	 * Retrieves number of volunteers needed for this opportunity
	 * 
	 */
	public int getVolunteers() {
		return Volunteers;
	}

	/**
	 * Assigns number of volunteers needed for this opportunity
	 * 
	 */
	public void setVolunteers(int Volunteers) {
		this.Volunteers = Volunteers;
	}

	/**
	 * Returns a string representation of the currently loaded opportunity
	 * 
	 */
    @Override
    public String toString() {
        return "VolunteerEntity [id=" + id + ", title=" + Title + ", description=" + Description + 
                ", location=" + Location + ", volunteers=" + Volunteers + "]";
    }
}