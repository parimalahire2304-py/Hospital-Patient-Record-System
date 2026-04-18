package com.hospital.service;
 
import java.util.List;

import com.hospital.entity.Patient;

public interface PatientService {
    public boolean registerpatient(Patient patient);

    List<Patient> getAllPatients();    

Patient getPatientById(Integer id);

void deletePatient(Integer id);
}