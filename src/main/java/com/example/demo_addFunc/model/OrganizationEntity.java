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
    
    @Column(name="org_title", nullable=false, length=50)
    private String orgTitle;

    @Column(name="description", nullable=false, length=300)
    private String description;
    
    @Column(name="org_location")
    private Integer orgLocation;
    
    @Column(name="num_volunteers")
    private Integer numVols;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return orgTitle;
	}

	public void setTitle(String orgTitle) {
		this.orgTitle = orgTitle;
    }
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrgLocation() {
		return volLocation;
	}

	public void setOrgLocation(Integer orgLocation) {
		this.orgLocation = orgLocation;
	}

	public Integer getNumVols() {
		return volEmail;
	}

	public void setNumVols(Integer numVols) {
		this.numVols = numVols;
	}

    @Override
    public String toString() {
        return "VolunteerEntity [id=" + id + ", org_title=" + orgTitle + ", description=" + description + 
                ", org_location=" + orgLocation + ", num_volunteers=" + numVols + "]";
    }
}