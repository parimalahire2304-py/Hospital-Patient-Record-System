package com.hospital.controller;



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

    @GetMapping("/regPage")
    public String openRegPage(Model model) {
        model.addAttribute("patient", new Patient());
        return "register";
    }

    @PostMapping("/regForm")
    public String submitRegform(@ModelAttribute("patient") Patient patient, Model model) {

        boolean status = patientServ.registerpatient(patient);

        if (status) {
            return "redirect:/patients";
        } else {
            model.addAttribute("errorMsg", "Failed to register patient");
            return "register";
        }
    }

    @GetMapping("/patients")
    public String getAllPatients(Model model) {
        model.addAttribute("patients", patientServ.getAllPatients());
        return "patients";
    }

    @GetMapping("/edit/{id}")
    public String editPatient(@PathVariable Integer id, Model model) {

        Patient patient = patientServ.getPatientById(id);

        if (patient == null) {
            return "redirect:/patients";
        }

        model.addAttribute("patient", patient);
        return "updatePatient";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Integer id) {
        try {
            patientServ.deletePatient(id);
        } catch (Exception e) {
            System.out.println("Cannot delete patient (FK constraint)");
        }
        return "redirect:/patients";
    }
    @GetMapping("/history/{id}")
    public String patientHistory(@PathVariable Integer id, Model model) {
        // later implement
        return "history";
    }
}