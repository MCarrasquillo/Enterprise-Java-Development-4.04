package com.ironhack.lab402.Service.interfaces;

import com.ironhack.lab402.model.Status;

public interface IEmployeeService {
    public void changeDoctorStatus(Status status, Integer id);
    public void changeDoctorDepartment(String department, Integer id);
}
