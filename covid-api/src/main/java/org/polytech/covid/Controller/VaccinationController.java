package org.polytech.covid.Controller;

import org.polytech.covid.Model.Doctor;
import org.polytech.covid.Model.Patient;
import org.polytech.covid.Model.Vaccination;
import org.polytech.covid.Service.DoctorService;
import org.polytech.covid.Service.PatientService;
import org.polytech.covid.Service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/vaccination")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccinationController {
  @Autowired
  private VaccinationService vaccinationService;
  @Autowired
  private PatientService patientService;
  @Autowired
  private DoctorService doctorService;

  @GetMapping(path = "/All-vaccin")
  @ResponseBody
  public Iterable<Vaccination> GetAllVaccination() {
    return vaccinationService.getVaccination();
  }

  @PostMapping(path = "/update/{id}")
  @ResponseBody
  public void UpdateVaccination(@PathVariable String id) {
    Long Longid = Long.parseLong(id);
    vaccinationService.validate(Longid);

  }

  @PostMapping(path = "/deletevaccin/{id}")
  @ResponseBody
  public void DeleteVaccin(@PathVariable String id) {

    System.out.print(id);
    Long Longid = Long.parseLong(id);
    vaccinationService.delete(Longid);
  }

  @PostMapping(path = "/addvaccin/{data}")
  @ResponseBody
  public void addVaccin(@PathVariable String data) {
    System.out.println("Received data: " + data);

    String[] parts = data.split("&&");
    String id = parts[0].trim();
    String patient = parts[1].trim();
    String vaccinationDate = parts[2].trim();
    String doctor = parts[3].trim();
    String validate = parts[4].trim();
    Boolean Validate;
    if (validate == "true") {
      Validate = true;
    } else {
      Validate = false;
    }
    long long_ID = Long.parseLong(id);
    Patient Patient = patientService.getPatientById(long_ID)
        .orElseThrow(() -> new RuntimeException("VaccinationCenter not found with ID: " + long_ID));
    Doctor Doctor = doctorService.getDoctorById(long_ID)
        .orElseThrow(() -> new RuntimeException("VaccinationCenter not found with ID: " + long_ID));

    Vaccination vaccination = new Vaccination(Patient, vaccinationDate, Doctor, Validate);
    vaccinationService.save(vaccination);
  }
}