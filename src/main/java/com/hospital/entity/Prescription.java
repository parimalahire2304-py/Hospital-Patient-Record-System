package com.hospital.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Prescription {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@Column
	private LocalDate date;
	@Column
	private String symptoms;
	@Column
	private String diagnosis;
	@Column
	private String medicine;
	@Column
	private String note;
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	 
	public Doctor getDoctor() {
	    return doctor;
	}

	public void setDoctor(Doctor doctor) {
	    this.doctor = doctor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
