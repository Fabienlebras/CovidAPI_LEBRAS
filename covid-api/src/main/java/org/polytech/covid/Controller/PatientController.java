package org.polytech.covid.Controller;

import org.polytech.covid.Model.Patient;
import org.polytech.covid.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:4200")

public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping(path = "/All-patient")
    @ResponseBody

    public Iterable<Patient> GetAllPatient() {
        return patientService.getallPatient();
    }

    @PostMapping(path = "/addpatient/{data}")
    @ResponseBody
    public void Addpatient(@PathVariable String data) {
        System.out.println("Received data: " + data);

        String[] parts = data.split("&&");
        String firstName = parts[0].trim();
        String lastName = parts[1].trim();
        String mail = parts[2].trim();
        String phone = parts[3].trim();

        Patient patient = new Patient(firstName, lastName, mail, phone);
        patientService.save(patient);
    }

    @PostMapping(path = "/deletepatient/{id}")
    @ResponseBody
    public void DeleteCenter(@PathVariable long id) {
        patientService.delete(id);
    }

    @PostMapping(path = "updatepatient/{data}")
    public void UpdateCenter(@PathVariable String data) {
        String[] parts = data.split("&&");
        String firstName = parts[0].trim();
        String lastName = parts[1].trim();
        String mail = parts[2].trim();
        String phone = parts[3].trim();
        String id = parts[5].trim();
        Long patientId = Long.parseLong(id);

        Patient patient = new Patient(patientId, firstName, lastName, mail, phone);
        patientService.update(patient);
    }
}