package org.polytech.covid.Service;

import java.util.Optional;

import org.polytech.covid.Model.Doctor;

import org.polytech.covid.Repository.DoctorRepository;
import org.polytech.covid.Repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Iterable<Doctor> getDoctor() {
        return doctorRepository.findAll();
    }

    public void save(Doctor doctor) {
        doctorRepository.save(doctor);

    }

    public void delete(long id) {
        doctorRepository.deleteById(id);

    }

    public void update(Doctor doctor) {

        if (doctorRepository.existsById(doctor.getId())) {
            doctorRepository.save(doctor);
        }

    }

    public Optional<Doctor> getDoctorById(long id) {
        return doctorRepository.findById(id);
    }

}