package com.healthinsurence.www.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthinsurence.www.Entity.Payment;

@Repository
public interface paymentRepo extends JpaRepository<Payment,String>{

//	 @Query("SELECT p FROM Payment p JOIN p.register r WHERE r.customerId = :customerId")
//	    Payment findByRegistrationEmail(@Param("customerId") String customerId);
	 
	 @Query("SELECT p FROM Payment p JOIN p.register r WHERE r.customerId = :customerId")
	    List<Payment> findByRegistrationCustomerId(@Param("customerId") String customerId);


	  List<Payment> findAllByRegisterEmail(String email);
//
//  @Modifying
//  @Query("UPDATE Payment p SET p.email = :newEmail WHERE p.email = :oldEmail")
//  void updateEmail(@Param("oldEmail") String oldEmail, @Param("newEmail") String newEmail);

	List<Payment> findByRegisterCustomerId(String string);


	List<Payment> findByUserId(String userId);


	


//	Payment findByCustomerId(String userId);


//	Payment findByCustomerId(String userId);

//	List<Payment> findByCustomerId(String string);


	
}
