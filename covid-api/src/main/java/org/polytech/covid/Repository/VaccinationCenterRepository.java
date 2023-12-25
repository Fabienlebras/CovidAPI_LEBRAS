package org.polytech.covid.Repository;


import org.polytech.covid.Model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Long> {


}