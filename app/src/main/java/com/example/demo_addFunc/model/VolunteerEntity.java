/**
 * Implementation of the VOLUNTEER table
 */
package com.example.demo_addFunc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_VOLUNTEERS")
public class VolunteerEntity {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="full_name")
    private String FullName;
    
    @Column(name="location")
    private String Location;
    
    @Column(name="email", nullable=false, length=200)
    private String Email;
    
	/**
	 * Retrieves record id for this volunteer
	 * 
	 */
    public Long getId() {
		return id;
	}

	/**
	 * Assigns record id for this volunteer
	 * 
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retrieves the volunteer's full name
	 * 
	 */
	public String getFullName() {
		return FullName;
	}

	/**
	 * Assigns the volunteer's full name
	 * 
	 */
	public void setFullName(String FullName) {
		this.FullName = FullName;
	}

	/**
	 * Retrieves where the volunteering opportunity is located
	 * 
	 */
	public String getLocation() {
		return Location;
	}

	/**
	 * Assigns where the volunteering opportunity is located
	 * 
	 */
	public void setLocation(String Location) {
		this.Location = Location;
	}

	/**
	 * Retrieves email/contact information for this volunteer
	 * 
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * Assigns email/contact information for this volunteer
	 * 
	 */
	public void setEmail(String Email) {
		this.Email = Email;
	}

 	/**
	 * Returns a string representation of the currently loaded volunteer
	 * 
	 */
	@Override
    public String toString() {
        return "VolunteerEntity [id=" + id + ", Fullname=" + FullName + 
                ", Location=" + Location + ", Email=" + Email   + "]";
    }
}