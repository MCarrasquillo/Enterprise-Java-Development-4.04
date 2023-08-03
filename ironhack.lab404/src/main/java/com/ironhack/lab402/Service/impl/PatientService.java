package com.ironhack.lab402.Service.impl;

import com.ironhack.lab402.Repository.PatientRepository;
import com.ironhack.lab402.Service.interfaces.IPatientService;
import com.ironhack.lab402.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;

//Logic for updating the information of a patient
    @Override
    public void updatePatient(Patient patient, Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) return;
        patient.setPatient_id(id);
        patientRepository.save(patient);
    }
}
