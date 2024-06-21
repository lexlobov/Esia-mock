package ru.sberhealth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private final Map<String, String> authCodes = new HashMap<>();

    @GetMapping("/aas/oauth2/ac")
    public RedirectView auth(
            @RequestParam String response_type,
            @RequestParam String client_id,
            @RequestParam String redirect_uri,
            @RequestParam String scope) {

        if ("code".equals(response_type) && "12345".equals(client_id)) {
            String authCode = "mock_auth_code";
            authCodes.put(authCode, client_id);
            return new RedirectView("/");
        }
        return new RedirectView(redirect_uri + "?error=invalid_request");
    }

    public boolean isValidAuthCode(String code) {
        return authCodes.containsKey(code);
    }

    public void removeAuthCode(String code) {
        authCodes.remove(code);
    }
}
