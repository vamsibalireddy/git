package com.healthinsurence.www.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.healthinsurence.www.Entity.Loginpage;
import com.healthinsurence.www.Entity.Registration;
import com.healthinsurence.www.Repositary.LoginRepository;
import com.healthinsurence.www.Repositary.RegistrationReposotory;
import com.healthinsurence.www.Repositary.paymentRepo;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class RegisterService {
	private String customerId;
	
	@Autowired
	RegistrationReposotory registerRepo;
	@Autowired
	LoginRepository loginRepositary;
	@Autowired
	paymentRepo paymentRepository;
//	@Autowired
//	Loginpage loginpage;
	
	public Registration addregister(Registration register) {
		customerId=generateOTP(6);
		
		register.setCustomerId(customerId);
		Registration reg=registerRepo.save(register);
		  Loginpage userlogin = new Loginpage();

		 userlogin.setUsername(reg.getEmail());
		 userlogin.setUserpassword(reg.getPassword());
		 userlogin.setCustomerId(reg.getCustomerId());
		loginRepositary.save(userlogin);
		
		return registerRepo.save(register);
	}
	public List<Registration> getAll() {
		return registerRepo.findAll();
	}
	
	public boolean check(String username,String password) 
	{
		Registration reg=registerRepo.findByEmail(username);
		if(reg==null)
		{
			return false;
		}
		
		return reg.getPassword().equals(password);
	}
	

	public Registration getById(String email) {
		return registerRepo.findByEmail(email);
	}
	public Registration findByEmail(String email) {
		// TODO Auto-generated method stub
		return registerRepo.findByEmail(email);
	}
	public Registration update(Registration register, String email) {
		
		Registration reg=registerRepo.findByEmail(email);
		reg.setFirstname(register.getFirstname());
		reg.setAddress(register.getAddress());
		reg.setContactNo(register.getContactNo());
		reg.setEmail(register.getEmail());
	 Loginpage login=loginRepositary.findByUsername(email);
		 
		login.setUsername(register.getEmail());
		loginRepositary.save(login);
		
		
		
		return registerRepo.save(reg);
//		return registerRepo.save(register);
	}
	 
	public Registration updateUserEmail(String currentEmail, String newEmail, Registration updatedRegistration) throws Exception {
	        try {
	            // Check if the new email already exists
	            Registration existingRegistrationWithEmail = registerRepo.findByEmail(newEmail);

	            // If the new email already exists and it's not the same as the current email
	            if (existingRegistrationWithEmail != null && !existingRegistrationWithEmail.getEmail().equals(currentEmail)) {
	                throw new Exception("Email already exists: " + newEmail);
	            }

	            // Retrieve the existing registration by the current email
	            Registration existingRegistration = registerRepo.findByEmail(currentEmail);

	            
	            if (existingRegistration == null) {
	                throw new EntityNotFoundException("Registration not found for email: " + currentEmail);
	            }

	            
	            existingRegistration.setEmail(newEmail); 

	          
	            return registerRepo.save(existingRegistration);
	        } catch (DataAccessException ex) {
	            // Handle database access exceptions
	            // Log the error or rethrow as a custom application exception
	            throw new Exception("Error updating registration: " + ex.getMessage(), ex);
	        }
	    }
	public String generateOTP(int length) {
		// TODO Auto-generated method stub
		String numbers="0123456789";
		
		StringBuilder otp=new StringBuilder(length);
		
		Random random=new Random();
		for(int i=0;i<=length;i++) {
		otp.append(numbers.charAt(random.nextInt(numbers.length())));
		}
		
		return otp.toString();
	}
//	public boolean checkMail(String email) {
//		Optional<Registration> register=Optional.of(registerRepo.findByEmail(email));
//		if(register.isEmpty()) {
//			return false;
//		}
//		return true;
//	
//	}
	public boolean checkMail(String email) {
	    // Use Optional.ofNullable to handle the case where findByEmail returns null
	    Optional<Registration> register = Optional.ofNullable(registerRepo.findByEmail(email));
	    
	    // Check if the Optional is empty
	    if (register.isEmpty()) {
	        return false;
	    }
	    return true;
	}

	@Transactional
	public void updateEmail(String oldEmail, String newEmail) {
	    // Fetch the existing entity by its primary key (email)
	    Registration registration = registerRepo.findById(oldEmail)
	            .orElseThrow(() -> new EntityNotFoundException("Registration not found with email: " + oldEmail));

	    // Update the email address
	    registration.setEmail(newEmail);

	    // Save the updated entity back to the database
	    registerRepo.save(registration);

	    // Update the email in the Payment entity
//	    paymentRepository.updateEmail(oldEmail, newEmail);
	}
	
}
