package org.polytech.covid.Controller;

import org.polytech.covid.Model.Vaccination;
import org.polytech.covid.Service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/vaccination")
public class VaccinationController {
  @Autowired
  private VaccinationService vaccinationService;

  @GetMapping(path = "/All-vaccination")
  @ResponseBody
  public Iterable<Vaccination> GetAllVaccination() {
    return vaccinationService.getVaccination();
  }

  @GetMapping(path = "/update/{id}")
  @ResponseBody
  public void UpdateVaccination(@PathVariable Long id) {
    boolean success = vaccinationService.validate(id);

  }

}