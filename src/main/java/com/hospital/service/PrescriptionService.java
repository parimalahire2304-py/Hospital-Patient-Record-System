package com.hospital.service;

import java.util.List;

import com.hospital.entity.Prescription;

public interface PrescriptionService {
	public boolean savePrescription(Prescription pres);
	
	List<Prescription> getPrescriptionByPatientId(Integer patientId);

}
