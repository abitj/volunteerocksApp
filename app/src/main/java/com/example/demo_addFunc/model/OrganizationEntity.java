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
    private String orgTitle;

    @Column(name="description", nullable=false, length=250)
    private String description;
    
    @Column(name="loc", nullable=false, length=250)
    private String orgLocation;
    
    @Column(name="vols")
    private String numVols;
    
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

	public String getOrgLocation() {
		return orgLocation;
	}

	public void setOrgLocation(String orgLocation) {
		this.orgLocation = orgLocation;
	}

	public String getNumVols() {
		return numVols;
	}

	public void setNumVols(String numVols) {
		this.numVols = numVols;
	}

    @Override
    public String toString() {
        return "VolunteerEntity [id=" + id + ", title=" + orgTitle + ", description=" + description + 
                ", location=" + orgLocation + ", volunteers=" + numVols + "]";
    }
}