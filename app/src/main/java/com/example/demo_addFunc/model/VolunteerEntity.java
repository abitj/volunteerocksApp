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
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String FullName) {
		this.FullName = FullName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String Location) {
		this.Location = Location;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

    @Override
    public String toString() {
        return "VolunteerEntity [id=" + id + ", Fullname=" + FullName + 
                ", Location=" + Location + ", Email=" + Email   + "]";
    }
}