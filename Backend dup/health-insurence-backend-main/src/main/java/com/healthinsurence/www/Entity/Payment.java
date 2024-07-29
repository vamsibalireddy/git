package com.healthinsurence.www.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity
public class Payment {
	
	@Column
	private String planType;
//	@Column
//    private String email;
	@Id
	private String userId;
	@Column
	private String relationType;
	@Column
	private String duration;
	@Column
	private String insurence_cover;
	@Column
	private String intrest;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customerId",referencedColumnName = "customerId")
	private Registration register;
	
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRelationType() {
		return relationType;
	}
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
}
	//public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
	public String getInsurence_cover() {
		return insurence_cover;
	}
	public void setInsurence_cover(String insurence_cover) {
		this.insurence_cover = insurence_cover;
	}
	public String getInterest() {
		return intrest;
	}
	public void setIntrest(String intrest) {
		this.intrest = intrest;
	}
	public Registration getRegister() {
		return register;
	}
	public void setRegister(Registration register) {
		this.register = register;
	}	
	

}
