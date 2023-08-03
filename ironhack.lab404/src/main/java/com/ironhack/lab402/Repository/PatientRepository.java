package com.ironhack.lab402.Repository;

import com.ironhack.lab402.model.Patient;
import com.ironhack.lab402.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    List<Patient> findByEmployeeDepartment(String department );
    List<Patient> findByEmployeeStatus(Status status);

    List<Patient> findByDateOfBirthBetween(Date startDate, Date endDate);
}
