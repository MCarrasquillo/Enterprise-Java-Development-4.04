package com.ironhack.lab402.controller.impl;

import com.ironhack.lab402.Repository.EmployeeRepository;

import com.ironhack.lab402.Service.interfaces.IEmployeeService;
import com.ironhack.lab402.controller.DTO.EmployeeDepartmentDTO;
import com.ironhack.lab402.controller.DTO.EmployeeStatusDTO;
import com.ironhack.lab402.model.Employee;
import com.ironhack.lab402.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController{
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    IEmployeeService employeeService;

    //Find all doctors
    @GetMapping("/doctors")
    public List<Employee> getAllEmployees(){
         return employeeRepository.findAll();
    }

    //find doctor by id
    @GetMapping("/doctors/{id}")
    public Employee getDoctorById(@PathVariable()Integer id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()) return null;
        return employeeOptional.get();
    };

    //find doctor by their status
    @GetMapping("/doctors/status/{status}")
    public List<Employee> getDoctorByStatus(@PathVariable() Status status){
        return employeeRepository.findAllByStatus(status);

    };
//find doctors by their departments
    @GetMapping("doctors/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable() String department){
        return employeeRepository.findAllByDepartment(department);
    }
//------------------POST-----------------
    //Adds a new doctor/employee
    @PostMapping("/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDoctor(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }



//------------------PATCH-----------------
//changes the value of Status of a specific doctor by finding them by their id
    @PatchMapping("/doctors/status/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeDoctorStatus(@RequestBody EmployeeStatusDTO employeeStatusDTO, @PathVariable Integer id) {
        employeeService.changeDoctorStatus(employeeStatusDTO.getStatus(), id); }

//changes the value of the doctor department by finding them by their id
    @PatchMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeDoctorDepartment(@RequestBody EmployeeDepartmentDTO employeeDepartmentDTO, @PathVariable Integer id){
        employeeService.changeDoctorDepartment(employeeDepartmentDTO.getDepartment(), id);
    }

}
