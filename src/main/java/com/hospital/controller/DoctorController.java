package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hospital.entity.Doctor;
import com.hospital.service.DoctorService;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // 👉 Open Add Doctor Page
    @GetMapping("/doctor")
    public String openDoctorPage(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor";
    }

    // 👉 SAVE / UPDATE Doctor
    @PostMapping("/doctorForm")
    public String submitDoctor(@ModelAttribute("doctor") Doctor doctor) {

        doctorService.registerDoctor(doctor);

        // ✅ Redirect after save/update
        return "redirect:/doctorList?success";
    }

    // 👉 View Doctor List
    @GetMapping("/doctorList")
    public String viewDoctors(Model model) {

        List<Doctor> list = doctorService.getAllDoctors();
        model.addAttribute("doctors", list);

        return "doctorList";
    }

    // 👉 Edit Doctor
    @GetMapping("/editDoctor/{id}")
    public String editDoctor(@PathVariable Integer id, Model model) {

        Doctor doctor = doctorService.getDoctorById(id);
        model.addAttribute("doctor", doctor);

        return "updateDoctor";
    }

    // 👉 Delete Doctor
    @GetMapping("/deleteDoctor/{id}")
    public String deleteDoctor(@PathVariable Integer id) {

        doctorService.deleteDoctor(id);

        return "redirect:/doctorList?deleted";
    }
}