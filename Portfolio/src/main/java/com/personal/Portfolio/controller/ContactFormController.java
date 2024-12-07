package com.personal.Portfolio.controller;

import com.personal.Portfolio.modal.ContactForm;
import com.personal.Portfolio.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/contact")
public class ContactFormController {
    @Autowired
    private ContactFormService contactFormService;

    @PostMapping("/submit")
    public ResponseEntity<ContactForm> submitContactForm(@RequestBody ContactForm contactForm) {
        ContactForm savedForm = contactFormService.saveContactForm(contactForm);
        return ResponseEntity.ok(savedForm);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContactForm>> getAllContactForms() {
        List<ContactForm> contactForms = contactFormService.getAllContactForms();
        return ResponseEntity.ok(contactForms);
    }
}
