package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.entity.Doctor;
import com.hospital.repository.DoctorRepository;

@Service
public class DoctorServiceImple implements DoctorService {

    @Autowired
    private DoctorRepository repo;

    @Override
    public boolean registerDoctor(Doctor doctor) {
        Doctor saved = repo.save(doctor);
        return saved.getId() != null;
    }

	@Override
	public Doctor getDoctorById(Integer id) {
		// TODO Auto-generated method stub
		 return repo.findById(id).orElse(null);
	}

	@Override
	public void deleteDoctor(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		 return repo.findAll();
		
	}
}