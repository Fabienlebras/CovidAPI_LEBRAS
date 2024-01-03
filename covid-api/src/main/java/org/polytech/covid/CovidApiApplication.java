package org.polytech.covid;


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
	public CommandLineRunner init(VaccinationCenterService vaccinationcenterService,
			AdministratorService administratorService, PatientService patientService,
			VaccinationService vaccinationService, DoctorService doctorService) {
		return args -> {
			VaccinationCenter center1 = new VaccinationCenter("Centre 1", "rue de la gare", "Nancy");
			VaccinationCenter center2 = new VaccinationCenter("Centre 2", "Centre ville", "Metz");
			VaccinationCenter center3 = new VaccinationCenter("Centre 3", "Porte de la chapelle", "Metz");

			vaccinationcenterService.save(center1);
			vaccinationcenterService.save(center2);
			vaccinationcenterService.save(center3);

			Doctor doctor1 = new Doctor("Pierre", "test", center1,
					"pierre.test@gmail.com", "010203040506");
			Doctor doctor2 = new Doctor("John", "test2", center1, "john.test2@gmail.com",
					"0151151515");
			Doctor doctor3 = new Doctor("Sam", "test3", center1, "sam.test3@gmail.com",
					"848848448948");

			doctorService.save(doctor1);
			doctorService.save(doctor2);
			doctorService.save(doctor3);

			Administrator administrator = new Administrator("Pierre", "Test1", "mail1", "phone1", center1);
			Administrator administrator2 = new Administrator("Pierre", "Test2", "mail2", "phone2", center2);
			Administrator administrator3 = new Administrator("Pierre", "Test2", "mail3", "phone3", center3);

			administratorService.save(administrator);
			administratorService.save(administrator2);
			administratorService.save(administrator3);

			Patient patient1 = new Patient("pierre", "test1", "mail1", "phone1");
			Patient patient2 = new Patient("pierre", "test2", "mail2", "phone2");
			Patient patient3 = new Patient("pierre", "test3", "mail3", "phone3");
			System.out.print(patient1);
			patientService.save(patient1);
			patientService.save(patient2);
			patientService.save(patient3);

			Vaccination vaccination = new Vaccination(patient1, "01/05/2022", doctor1);
			Vaccination vaccination2 = new Vaccination(patient2, "01/09/2022", doctor2);
			Vaccination vaccination3 = new Vaccination(patient3, "01/12/2022", doctor3);

			vaccinationService.save(vaccination);
			vaccinationService.save(vaccination2);
			vaccinationService.save(vaccination3);

		};
	}
}
