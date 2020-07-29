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
    private Integer Volunteers;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
    }
    
    public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String Location) {
		this.Location = Location;
	}

	public Integer getVolunteers() {
		return Volunteers;
	}

	public void setVolunteers(Integer Volunteers) {
		this.Volunteers = Volunteers;
	}

    @Override
    public String toString() {
        return "VolunteerEntity [id=" + id + ", title=" + Title + ", description=" + Description + 
                ", location=" + Location + ", volunteers=" + Volunteers + "]";
    }
}