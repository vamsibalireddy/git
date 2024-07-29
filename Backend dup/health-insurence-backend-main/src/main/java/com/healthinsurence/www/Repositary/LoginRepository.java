package com.healthinsurence.www.Repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthinsurence.www.Entity.Loginpage;

@Repository
public interface LoginRepository extends JpaRepository<Loginpage,String> {

	

	Loginpage findByUsername(String email);

	Optional<Loginpage> findByusername(String username);



	





}
