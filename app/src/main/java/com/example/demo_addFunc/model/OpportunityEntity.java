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
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getNumberNeeded() {
		return NumberNeeded;
	}

	public void setNumberNeeded(int NumberNeeded) {
		this.NumberNeeded = NumberNeeded;
	}

    @Override
    public String toString() {
        return "OpportunityEntity [id=" + id + ", Description=" + Description + 
                ", Location=" + Location + ", NumberNeeded=" + NumberNeeded + "]";
    }
}