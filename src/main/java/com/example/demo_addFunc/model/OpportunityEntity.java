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
    
    @Column(name="opp_description", nullable=false, length=200)
    private String oppDescription;
    
    @Column(name="opp_location")
    private String oppLocation;
    
    @Column(name="opp_number_needed")
    private int oppNumberNeeded;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOppDescription() {
		return oppDescription;
	}

	public void setOppDescription(String oppDescription) {
		this.oppDescription = oppDescription;
	}

	public String getOppLocation() {
		return oppLocation;
	}

	public void setOppLocation(String oppLocation) {
		this.oppLocation = oppLocation;
	}

	public int getOppNumberNeeded() {
		return oppNumberNeeded;
	}

	public void setOppNumberNeeded(int oppNumberNeeded) {
		this.oppNumberNeeded = oppNumberNeeded;
	}

    @Override
    public String toString() {
        return "OpportunityEntity [id=" + id + ", oppDescription=" + oppDescription + 
                ", oppLocation=" + oppLocation + ", oppNumberNeeded=" + oppNumberNeeded + "]";
    }
}