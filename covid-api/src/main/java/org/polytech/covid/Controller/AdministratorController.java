package org.polytech.covid.Controller;

import org.polytech.covid.Model.Administrator;
import org.polytech.covid.Model.VaccinationCenter;
import org.polytech.covid.Service.AdministratorService;
import org.polytech.covid.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/administrator")
@CrossOrigin(origins = "http://localhost:4200")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private VaccinationCenterService vaccinationCenterService;

    @GetMapping(path = "/All-administrator")
    @ResponseBody

    public Iterable<Administrator> GetAllAdministrato() {
        return administratorService.getAllAdministrator();
    }

    @PostMapping(path = "/addadministrator/{data}")
    @ResponseBody
    public void AddAdmninistrator(@PathVariable String data) {
        System.out.println("Received data: " + data);

        String[] parts = data.split("&&");
        String firstName = parts[0].trim();
        String lastName = parts[1].trim();
        String mail = parts[2].trim();
        String phone = parts[3].trim();
        String id = parts[4].trim();
        long long_ID = Long.parseLong(id);
        VaccinationCenter vaccinationCenter = vaccinationCenterService.getAdministratorById(long_ID)
                .orElseThrow(() -> new RuntimeException("VaccinationCenter not found with ID: " + long_ID));

        Administrator administrator = new Administrator(firstName, lastName, mail, phone, vaccinationCenter);
        administratorService.save(administrator);
    }

    @PostMapping(path = "/deleteadmin/{id}")
    @ResponseBody
    public void DeleteCenter(@PathVariable long id) {
        administratorService.delete(id);
    }

    @PostMapping(path = "updateadmin/{data}")
    public void UpdateCenter(@PathVariable String data) {
        String[] parts = data.split("&&");
        String firstName = parts[0].trim();
        String lastName = parts[1].trim();
        String mail = parts[2].trim();
        String phone = parts[3].trim();
        String id = parts[4].trim();
        String VaccinationCenter_Id = parts[5].trim();
        Long VaccinationCenterId = Long.parseLong(VaccinationCenter_Id);
        Long new_Id = Long.parseLong(id);
        VaccinationCenter vaccinationCenter = vaccinationCenterService.getAdministratorById(VaccinationCenterId)
                .orElseThrow(() -> new RuntimeException("VaccinationCenter not found with ID: "));

        Administrator administrator = new Administrator(new_Id, firstName, lastName, mail, phone, vaccinationCenter);
        administratorService.update(administrator);
    }

}