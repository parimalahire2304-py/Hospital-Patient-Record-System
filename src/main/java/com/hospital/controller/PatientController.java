package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hospital.entity.Patient;
import com.hospital.service.PatientService;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientServ;

    // 👉 Open Registration Page
    @GetMapping("/regPage")
    public String openRegPage(Model model) {
        model.addAttribute("patient", new Patient());
        return "register";
    }

    // 👉 SAVE / UPDATE Patient (FIXED ✅)
    @PostMapping("/regForm")
    public String submitRegform(@ModelAttribute("patient") Patient patient) {

        patientServ.registerpatient(patient);

        // ✅ Redirect to patients list page after save/update
        return "redirect:/patients";
    }

    // 👉 View All Patients
    @GetMapping("/patients")
    public String getAllPatients(Model model) {

        List<Patient> list = patientServ.getAllPatients();
        model.addAttribute("patients", list);

        return "patients";
    }

    // 👉 Edit Patient (Open Update Form)
    @GetMapping("/edit/{id}")
    public String editPatient(@PathVariable Integer id, Model model) {

        Patient patient = patientServ.getPatientById(id);
        model.addAttribute("patient", patient);

        return "updatePatient";
    }

    // 👉 Delete Patient (Already Correct ✅)
    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Integer id) {

        patientServ.deletePatient(id);

        return "redirect:/patients";
    }
}