package com.healthinsurence.www.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthinsurence.www.Entity.PolicyDetails;

@Repository
public interface PolicyDetailsRepositary extends JpaRepository<PolicyDetails,  String> {

}
