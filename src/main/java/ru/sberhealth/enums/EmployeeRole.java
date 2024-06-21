package ru.sberhealth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmployeeRole {
    ADMIN("admin"),
    TENANT("tenant"),
    DOCTOR("doctor");

    private final String role;
}
