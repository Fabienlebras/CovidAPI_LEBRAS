package org.polytech.covid;

import java.sql.Date;

import org.polytech.covid.Model.Administrator;
import org.polytech.covid.Model.Doctor;
import org.polytech.covid.Model.Patient;
import org.polytech.covid.Model.Vaccination;
import org.polytech.covid.Model.VaccinationCenter;
import org.polytech.covid.Service.AdministratorService;
import org.polytech.covid.Service.DoctorService;
import org.polytech.covid.Service.PatientService;
import org.polytech.covid.Service.VaccinationCenterService;
import org.polytech.covid.Service.VaccinationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CovidApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(VaccinationCenterService vaccinationcenterService) {
		return args -> {
			VaccinationCenter t = new VaccinationCenter("name 1", "address 1", "city 1");

			vaccinationcenterService.save(t);
			VaccinationCenter tt = new VaccinationCenter("name 2", "address 2", "city 2");

			vaccinationcenterService.save(tt);
		};
	}
}
