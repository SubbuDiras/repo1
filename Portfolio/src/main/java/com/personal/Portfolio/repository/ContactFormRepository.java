package com.personal.Portfolio.repository;

import com.personal.Portfolio.modal.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormRepository extends JpaRepository<ContactForm,Long> {
}
