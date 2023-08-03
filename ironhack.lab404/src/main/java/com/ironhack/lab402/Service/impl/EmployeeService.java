package com.ironhack.lab402.Service.impl;

import com.ironhack.lab402.Repository.EmployeeRepository;
import com.ironhack.lab402.Service.interfaces.IEmployeeService;
import com.ironhack.lab402.model.Employee;
import com.ironhack.lab402.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    //Logic for changing doctor status
    @Override
    public void changeDoctorStatus(Status status, Integer id) {
        Optional<Employee> doctorOptional = employeeRepository.findById(id);
        if(doctorOptional.isEmpty()) return;
        Employee employee = doctorOptional.get();
        employee.setStatus(status);
        employeeRepository.save(employee);
    }
    //Logic for changing doctor department

    public void changeDoctorDepartment(String department, Integer id){
        Optional<Employee> doctorOptional = employeeRepository.findById(id);
        if (doctorOptional.isEmpty()) return;
        Employee employee = doctorOptional.get();
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }
}
