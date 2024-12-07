package com.personal.Portfolio.service;

import com.personal.Portfolio.modal.ContactForm;
import com.personal.Portfolio.repository.ContactFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactFormService {
    @Autowired
    private ContactFormRepository contactFormRepository;

    public ContactForm saveContactForm(ContactForm contactForm) {
        return contactFormRepository.save(contactForm);
    }

    public List<ContactForm> getAllContactForms() {
        return contactFormRepository.findAll();
    }
}
