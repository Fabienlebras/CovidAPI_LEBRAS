package org.polytech.covid.Service;

import java.util.Optional;

import org.polytech.covid.Model.VaccinationCenter;
import org.polytech.covid.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;

    public Iterable<VaccinationCenter> getVaccinationCenter() {
        return vaccinationCenterRepository.findAll();
    }

    public void save(VaccinationCenter vaccinationCenter) {
        vaccinationCenterRepository.save(vaccinationCenter);

    }

    public void delete(long id) {
        vaccinationCenterRepository.deleteById(id);
    }

    public void update(VaccinationCenter vaccinationCenter) {

        if (vaccinationCenterRepository.existsById(vaccinationCenter.getId())) {
            vaccinationCenterRepository.save(vaccinationCenter);
        }

    }

    public Iterable<VaccinationCenter> findVaccinationCentersByCityLike() {
        return vaccinationCenterRepository.findAll();
    }

    public Iterable<VaccinationCenter> getVaccinationCentersByCity(String city) {
        Iterable<VaccinationCenter> centers = vaccinationCenterRepository.findByCity(city);
        return centers;
    }

    public Optional<VaccinationCenter> getAdministratorById(long id) {
        return vaccinationCenterRepository.findById(id);
    }

}
