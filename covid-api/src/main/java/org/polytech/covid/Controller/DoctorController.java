package org.polytech.covid.Controller;

import org.polytech.covid.Model.VaccinationCenter;
import org.polytech.covid.Service.DoctorService;
import org.polytech.covid.Service.VaccinationCenterService;
import org.polytech.covid.Service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
  @Autowired
  private DoctorService doctorService;

}