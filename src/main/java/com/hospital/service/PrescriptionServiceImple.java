package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Prescription;
import com.hospital.repository.PrescriptionRepository;

@Service
public class PrescriptionServiceImple implements PrescriptionService{
	@Autowired
	private PrescriptionRepository presRepo;
	@Override
	public boolean savePrescription(Prescription pres) {
		try {
			presRepo.save(pres);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Prescription> getPrescriptionByPatientId(Integer patientId) {
		 return presRepo.findByPatient_Id(patientId);
	}

}
