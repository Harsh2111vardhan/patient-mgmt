package com.capstone.simplepatientmgmt.controller;

import com.capstone.simplepatientmgmt.model.Patient;
import com.capstone.simplepatientmgmt.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    private final PatientRepository repository;

    public PatientController(PatientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("patients", repository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute Patient patient) {
        repository.save(patient);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
