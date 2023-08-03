package com.ironhack.lab402.Component;

import com.ironhack.lab402.Repository.EmployeeRepository;
import com.ironhack.lab402.Repository.PatientRepository;
import com.ironhack.lab402.model.Employee;
import com.ironhack.lab402.model.Patient;
import com.ironhack.lab402.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class Creator {
    //This is used to insert the values to the database
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PatientRepository patientRepository;

    //Used only for creating data in our database
    public void createAndSave(){
        Employee employee1= new Employee(356712,"cardiology","Alonso Flores", Status.ON_CALL);
        Employee employee2= new Employee(564134,"immunology","Sam Ortega", Status.ON);
        Employee employee3= new Employee(761527,"cardiology","German Ruiz", Status.OFF);
        Employee employee4= new Employee(166552,"pulmonary","Maria Lin", Status.ON);
        Employee employee5= new Employee(156545,"orthopaedic","Pablo Rodriguez", Status.ON_CALL);
        Employee employee6= new Employee(172456,"psychiatric","John Paul Armes", Status.OFF);

        Patient patient1 = new Patient("Jaime Jordan",new GregorianCalendar(1984, Calendar.FEBRUARY, 11).getTime(),employee2);
        Patient patient2 = new Patient("Jaime Jordan",new Date(84, 3,2),employee2);
        Patient patient3 = new Patient("Jaime Jordan",new Date(1984, 3,2),employee1);
        Patient patient4 = new Patient("Jaime Jordan",new Date(1984, 3,2),employee3);
        Patient patient5 = new Patient("Jaime Jordan",new Date(1984, 3,2),employee6);

       employeeRepository.save(employee1);
       employeeRepository.save(employee2);
       employeeRepository.save(employee3);
       employeeRepository.save(employee4);
       employeeRepository.save(employee5);
       employeeRepository.save(employee6);

       patientRepository.save(patient1);
       patientRepository.save(patient2);
       patientRepository.save(patient3);
       patientRepository.save(patient4);
       patientRepository.save(patient5);

    }

    //Used only for deleting data in our database

    public void deleteALlValues(){
        employeeRepository.deleteAll();
        patientRepository.deleteAll();
    }





}
