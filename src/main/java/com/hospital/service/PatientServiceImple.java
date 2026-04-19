package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Patient;
import com.hospital.repository.PatientRepository;
@Service
public class PatientServiceImple implements PatientService {
	@Autowired
    private PatientRepository patientRepo;
	@Override
	public boolean registerpatient(Patient patient) {
		// TODO Auto-generated method stub
		try {
			patientRepo.save(patient);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		 return patientRepo.findAll();
	}
	@Override
	public Patient getPatientById(Integer id) {
		// TODO Auto-generated method stub
	    return patientRepo.findById(id).orElse(null);
	}
	@Override
	public void deletePatient(Integer id) {
		// TODO Auto-generated method stub
		 patientRepo.deleteById(id);
	}
	@Override
	public boolean updatePatient(Patient patient) {
		try {
	        patientRepo.save(patient);   
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	

}
