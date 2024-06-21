package ru.sberhealth.dto;

import lombok.Data;
import ru.sberhealth.enums.EmployeeRole;

@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private EmployeeRole role;
    private Integer clinicId;
    private Integer tenantId;
}
