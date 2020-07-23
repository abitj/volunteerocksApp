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
    
    @Column(name="vol_full_name")
    private String volFullName;
    
    @Column(name="vol_location")
    private String volLocation;
    
    @Column(name="vol_email", nullable=false, length=200)
    private String volEmail;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVolFullName() {
		return volFullName;
	}

	public void setVolFullName(String volFullName) {
		this.volFullName = volFullName;
	}

	public String getVolLocation() {
		return volLocation;
	}

	public void setVolLocation(String volLocation) {
		this.volLocation = volLocation;
	}

	public String getVolEmail() {
		return volEmail;
	}

	public void setVolEmail(String volEmail) {
		this.volEmail = volEmail;
	}

    @Override
    public String toString() {
        return "VolunteerEntity [id=" + id + ", volFullname=" + volFullName + 
                ", volLocation=" + volLocation + ", volEmail=" + volEmail   + "]";
    }
}