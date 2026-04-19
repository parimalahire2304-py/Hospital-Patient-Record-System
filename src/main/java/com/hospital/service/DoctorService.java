package com.hospital.service;

 
import com.hospital.entity.Doctor;
 
import java.util.List;
public interface DoctorService {
    boolean registerDoctor(Doctor doctor);

	Doctor getDoctorById(Integer id);

	void deleteDoctor(Integer id);
	List<Doctor> getAllDoctors();
}