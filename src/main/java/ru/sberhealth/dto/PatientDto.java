package ru.sberhealth.dto;

import lombok.Data;
import ru.sberhealth.enums.Gender;

@Data
public class PatientDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String dateOfBirth;
}
