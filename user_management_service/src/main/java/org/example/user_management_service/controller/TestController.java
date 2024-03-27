package org.example.user_management_service.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/rider")
    @PreAuthorize("hasRole('RIDER') or hasRole('DRIVER') or hasRole('ADMIN')")
    public String riderAccess() {
        return "Rider Content.";
    }

    @GetMapping("/driver")
    @PreAuthorize("hasRole('DRIVER')")
    public String driverAccess() {
        return "Driver Content.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Content.";
    }
}
