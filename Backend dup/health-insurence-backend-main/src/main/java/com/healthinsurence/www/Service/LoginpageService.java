package com.healthinsurence.www.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthinsurence.www.Entity.Loginpage;
import com.healthinsurence.www.Repositary.LoginRepository;

@Service
public class LoginpageService {
	
	@Autowired
	LoginRepository loginRepositary;
	

	public List<Loginpage> getAll(Loginpage loginpage) {
		return loginRepositary.findAll();
	}

	
	
	public Loginpage update(Loginpage loginpage) {
		Loginpage login=loginRepositary.findById(loginpage.getUsername()).get();
		login.setUserpassword(loginpage.getUserpassword());
		
		return loginRepositary.save(login);

	}
	public void  delete(Loginpage loginpage) {
		loginRepositary.deleteById(loginpage.getUsername());
		
		
		
	}
	public Optional<Loginpage> findByEmail(String username) {
		
		return loginRepositary.findByusername(username);
	}
	
	

}
