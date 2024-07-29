package com.healthinsurence.www.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthinsurence.www.Entity.Loginpage;
import com.healthinsurence.www.Repositary.RegistrationReposotory;
import com.healthinsurence.www.Service.LoginpageService;
import com.healthinsurence.www.Service.RegisterService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Loginpage")
public class LoginpageController {
	
	@Autowired
	LoginpageService loginpageService;
	@Autowired
	RegisterService registerservice;
	@Autowired
	RegistrationReposotory registerRepo;
	public LoginpageController(LoginpageService loginpageService) {
        this.loginpageService = loginpageService;
    }

	@PostMapping("/add")
	public String  addlogin(@RequestBody Loginpage loginpage) {
		Optional<Loginpage> optionalUser=loginpageService.findByEmail(loginpage.getUsername());
		
		 if (optionalUser.isPresent()) {
		        Loginpage user = optionalUser.get();
		        // Check if passwords match (you should hash the passwords for security)
		        if (user.getUserpassword().equals(loginpage.getUserpassword())) {
		            // Passwords match, login successful
		            return "Login successfully";
		        } else {
		          
		            return "Invalid credentials";
		        }
		        
		 } 
		 else {
		        // User with the given email not found
		        return "User not found";
		    } 
	}
	@GetMapping("/getAll")
	public List<Loginpage> getAll(@RequestBody Loginpage loginpage) {
		return loginpageService.getAll(loginpage);
	}
	@PutMapping("/update")
	public Loginpage update(@RequestBody Loginpage loginpage) {
	return loginpageService.update(loginpage);
	
	}
	@DeleteMapping("/delete/{username}")
	public void delete(@RequestBody Loginpage loginpage) {
		loginpageService.delete(loginpage);
	}
	
}
