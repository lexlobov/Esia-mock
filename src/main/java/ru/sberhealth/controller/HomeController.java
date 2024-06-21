package ru.sberhealth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sberhealth.dto.EmployeeDto;
import ru.sberhealth.dto.PatientDto;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("client_id", "ВашClientID");
        model.addAttribute("redirect_uri", "http://localhost:8080/callback");
        return "index";
    }

    @GetMapping("/create-new-patient")
    public String newPatient(PatientDto patient, Model model){
        model.addAttribute("patient", patient);
        System.out.println(patient);
        return "new-patient";
    }

    @GetMapping("/create-new-employee")
    public String newEmployee(EmployeeDto employee, Model model){
        return "new_employee";
    }
}
