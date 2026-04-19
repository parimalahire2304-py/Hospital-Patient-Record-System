package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospital.entity.Prescription;
import com.hospital.service.DoctorService;
import com.hospital.service.PrescriptionService;

@Controller
public class PrescriptionContoller {

    @Autowired
    private PrescriptionService pressave;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/prescription")
    public String openPresciption(Model model) {
        model.addAttribute("prescription", new Prescription());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "prescription";
    }

    @PostMapping("/PrescriptionForm")
    public String savePrescription(@ModelAttribute("prescription") Prescription pres,
                                   Model model) {

        if (pres.getPatient() == null || pres.getPatient().getId() == 0) {
            model.addAttribute("errorMsg", "Patient ID is required!");
            model.addAttribute("doctors", doctorService.getAllDoctors());
            return "prescription";
        }

        boolean status = pressave.savePrescription(pres);

        if (status) {
            return "redirect:/prescription";
        } else {
            model.addAttribute("errorMsg", "Failed To Save Prescription");
            model.addAttribute("doctors", doctorService.getAllDoctors());
            return "prescription";
        }
    }
}