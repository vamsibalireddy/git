//
//package com.healthinsurence.www.Controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.healthinsurence.www.Entity.Payment;
//import com.healthinsurence.www.Entity.Registration;
//import com.healthinsurence.www.Service.InvoiceService;
//import com.healthinsurence.www.Service.RegisterService;
//import com.healthinsurence.www.Service.paymentService;
//import com.lowagie.text.DocumentException;
//
//import jakarta.servlet.http.HttpServletResponse;
//
//@CrossOrigin(origins="*")
//@RestController
//@RequestMapping("/payment")
//public class paymentController {
//
//    @Autowired
//    private paymentService paymentService;
//    
//    @Autowired
//    private RegisterService registerService;
//    
//    @Autowired
//    private InvoiceService invoiceService;
//
//    @PostMapping("/addCustomer/{email}")
//    public ResponseEntity<?> addCustomer(@RequestBody Payment payment, @PathVariable(name = "email") String email) {
//        // Check if the user with the provided email exists in the registration table
//        Registration register = registerService.findByEmail(email);
//        if (register == null) {
//            return ResponseEntity.badRequest().body("User with email " + email + " not found");
//        }
//
//        // Proceed with creating the payment record
//        Payment createdPayment = paymentService.addCustomer(payment, register);
//        return ResponseEntity.ok(createdPayment);
//    }
//
//    @GetMapping("/getCustomerDetails/{email}")
//    public List<Payment> getCustomer(@PathVariable String email) {
//        return paymentService.getCustomerPayments(email);
//    }
//
//    @GetMapping("/getCustomerDetailsByMail/{email}")
//    public List<Payment> getAllDetailsByMail(@PathVariable String email) {
//        return paymentService.getCustomerByMail(email);
//    }
//
//    @GetMapping("/create")
//    public void createPdf(@RequestParam("userId") String userId, HttpServletResponse response) {
//        // Setting content type and response headers
//        response.setContentType("application/pdf");
//        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf");
//
//        // Initialize the invoice service with the provided userId
//        invoiceService.init(userId);
//
//        try {
//            invoiceService.export(response);
//        } catch (DocumentException | IOException e) {
//            e.printStackTrace();
//        
//         }
//    }
//}
//
package com.healthinsurence.www.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthinsurence.www.Entity.Payment;
import com.healthinsurence.www.Entity.Registration;
import com.healthinsurence.www.Service.InvoiceService;
import com.healthinsurence.www.Service.RegisterService;
import com.healthinsurence.www.Service.paymentService;
import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/payment")
public class paymentController {

    @Autowired
    private paymentService paymentService;
    
    @Autowired
    private RegisterService registerService;
    
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/addCustomer/{email}")
    public ResponseEntity<?> addCustomer(@RequestBody Payment payment, @PathVariable(name = "email") String email) {
        // Check if the user with the provided email exists in the registration table
        Registration register = registerService.findByEmail(email);
        if (register == null) {
            return ResponseEntity.badRequest().body("User with email " + email + " not found");
        }

        // Proceed with creating the payment record
        Payment createdPayment = paymentService.addCustomer(payment, register);
        return ResponseEntity.ok(createdPayment);
    }

    @GetMapping("/getCustomerDetails/{email}")
    public List<Payment> getCustomer(@PathVariable String email) {
        return paymentService.getCustomerPayments(email);
    }

    @GetMapping("/getCustomerDetailsByMail/{email}")
    public List<Payment> getAllDetailsByMail(@PathVariable String email) {
        return paymentService.getCustomerByMail(email);
    }

    @GetMapping("/create")
    public void createPdf(@RequestParam("userId") String userId, HttpServletResponse response) {
        // Setting content type and response headers
        response.setContentType("application/pdf");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf");

        // Initialize the invoice service with the provided userId
        invoiceService.init(userId);

        try {
            invoiceService.export(response);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}

