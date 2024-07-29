package com.healthinsurence.www.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthinsurence.www.Entity.Payment;
import com.healthinsurence.www.Entity.Registration;
import com.healthinsurence.www.Repositary.paymentRepo;
@Service
public class paymentService {
	@Autowired
	paymentRepo paymentRepo;
	
	

	public Payment addCustomer(Payment payment,Registration register) {
		// TODO Auto-generated method stub
		 payment.setRegister(register);
	return paymentRepo.save(payment);
	}

	public List<Payment> getCustomerPayments(String customerId) {
        return paymentRepo.findByRegistrationCustomerId(customerId);
    }
	public List<Payment> getCustomerByMail(String email) {
		
		return paymentRepo.findAllByRegisterEmail(email);
	}
	
}
