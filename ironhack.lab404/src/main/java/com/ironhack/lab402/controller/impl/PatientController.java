package com.ironhack.lab402.controller.impl;

import com.ironhack.lab402.Repository.PatientRepository;
import com.ironhack.lab402.Service.impl.PatientService;
import com.ironhack.lab402.Service.interfaces.IPatientService;
import com.ironhack.lab402.model.Employee;
import com.ironhack.lab402.model.Patient;
import com.ironhack.lab402.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    IPatientService patientService;
    //Finds all Patients
    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    //Finds patient by id
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable()Integer id){
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isEmpty()) return null;
        return patientOptional.get();
    };

    //Finds patient by date of birth range
    @GetMapping("/patient/dateofbirth")
    public List<Patient> getPatientByBirthBetween(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end){
        return patientRepository.findByDateOfBirthBetween(start, end);

    };
//find patient by department to which they were admitted
    @GetMapping("/patient/department/{department}")
    public List<Patient> getPatientByDepartment(@PathVariable() String department){
        return patientRepository.findByEmployeeDepartment(department);
    }

    //Find patients based on the status of the doctor
    @GetMapping("/patient/status/{status}")
    public List<Patient> getPatientWithDoctorStatus(@PathVariable() Status status){
    return patientRepository.findByEmployeeStatus(status);
    };


    //--------------------POST-------------------
    //Adds/creates a new patient
    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePatient(@RequestBody Patient patient){
    patientRepository.save(patient);
}


    //--------------------Put-------------------
    //Changes a patient's information
    @PutMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatient(@RequestBody Patient patient, @PathVariable Integer id){
        patientService.updatePatient(patient,id);
    }

}
