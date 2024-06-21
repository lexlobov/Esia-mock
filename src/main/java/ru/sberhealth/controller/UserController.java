package ru.sberhealth.controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sberhealth.apiClient.EmployeesApiClient;
import ru.sberhealth.apiClient.IdmApiClient;
import ru.sberhealth.apiClient.ProfilesApiClient;
import ru.sberhealth.dto.PatientDto;

@RestController
@AllArgsConstructor
public class UserController {
    private EmployeesApiClient employeesApiClient;
    private IdmApiClient idmApiClient;
    private ProfilesApiClient profilesApiClient;

    @PostMapping("/get-patient")
    public String getExistingPatient(@RequestParam String user_id, Model model) {
        model.addAttribute("auth_code", "mock_auth_code");
        model.addAttribute("user_id", user_id);
        return "redirect:/callback?code=mock_auth_code&user_id=" + user_id;
    }

    @PostMapping("/create-patient")
    public String createNewPatient(PatientDto patient, Model model) {
        System.out.println(patient);
        return "redirect:/callback?code=mock_auth_code&user_id=";
    }

    @PostMapping("/get-employee")
    public String existingUser(@RequestParam String user_id, Model model) {
        model.addAttribute("auth_code", "mock_auth_code");
        model.addAttribute("user_id", user_id);
        return "redirect:/callback?code=mock_auth_code&user_id=" + user_id;
    }

    @PostMapping("/create-employee")
    public String newUser(Model model) {
        String newUserId = "new_user_id";
        model.addAttribute("auth_code", "mock_auth_code");
        model.addAttribute("user_id", newUserId);
        return "redirect:/callback?code=mock_auth_code&user_id=" + newUserId;
    }

    @GetMapping("/callback")
    public String callback(@RequestParam String code, @RequestParam String user_id, Model model) {
        model.addAttribute("auth_code", code);
        model.addAttribute("user_id", user_id);
        return "callback";
    }
}
