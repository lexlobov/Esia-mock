package ru.sberhealth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("M"),
    FEMALE("F");

    private final String gender;
}
