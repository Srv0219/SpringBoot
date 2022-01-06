package com.email.controller;


import com.email.model.EmailRequest;
import com.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @RequestMapping("/welcome")
    @ResponseBody
    public String welcome() {
        return "Hello this is email API";
    }

    //api to send email

    @RequestMapping(value = "/sendmail", method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) {
       boolean result =  this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
        System.out.println(request);
        if (result){
            return ResponseEntity.ok("Mail Sent..");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not send");
        }

    }
}
