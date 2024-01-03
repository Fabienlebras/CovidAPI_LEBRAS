package org.polytech.covid.Service;

import java.util.Optional;

import org.polytech.covid.Model.Patient;
import org.polytech.covid.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Iterable<Patient> getallPatient() {
        return patientRepository.findAll();
    }

    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    public void delete(long id) {
        patientRepository.deleteById(id);
    }

    public void update(Patient patient) {

        if (patientRepository.existsById(patient.getId())) {
            patientRepository.save(patient);
        }

    }

    public Optional<Patient> getPatientById(long id) {
        return patientRepository.findById(id);
    }

}
