package com.capstone.simplepatientmgmt.repository;

import com.capstone.simplepatientmgmt.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
