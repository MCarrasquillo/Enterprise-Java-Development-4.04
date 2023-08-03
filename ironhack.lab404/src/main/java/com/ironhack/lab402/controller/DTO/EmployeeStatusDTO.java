package com.ironhack.lab402.controller.DTO;

import com.ironhack.lab402.model.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
//Class is used for patch, change Status of doctors
public class EmployeeStatusDTO {
    @Enumerated(EnumType.STRING)
    private Status status;

    public Status getStatus() {
        return status;
    }
}
