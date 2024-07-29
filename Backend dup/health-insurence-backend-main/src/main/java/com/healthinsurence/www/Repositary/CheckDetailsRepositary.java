package com.healthinsurence.www.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthinsurence.www.Entity.CheckDetails;

@Repository
public interface CheckDetailsRepositary extends JpaRepository<CheckDetails, String> {

}
