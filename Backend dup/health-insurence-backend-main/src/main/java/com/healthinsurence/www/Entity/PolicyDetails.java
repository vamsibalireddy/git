package com.healthinsurence.www.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class PolicyDetails {
	@Id
	private String policyType;
	@Column
	private String familyMembers;
	@Column
	private String individual;
	@Column
	private String date;
	@Column
	private String options;

}
