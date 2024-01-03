package org.polytech.covid.Controller;

import org.polytech.covid.Model.VaccinationCenter;
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
@RequestMapping("/vaccination-center")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccinationCenterController {
    @Autowired
    private VaccinationCenterService vaccinationCenterService;

    @GetMapping(path = "/All-center")
    @ResponseBody
    public Iterable<VaccinationCenter> GetAllVaccinationCenter() {
        return vaccinationCenterService.getVaccinationCenter();
    }

    @GetMapping(path = "/bycity/{city}")
    @ResponseBody
    public Iterable<VaccinationCenter> GetVaccinationCentersByCity(@PathVariable String city) {
        return vaccinationCenterService.getVaccinationCentersByCity(city);
    }

    @PostMapping(path = "/addcenter/{data}")
    @ResponseBody
    public void Addcenter(@PathVariable String data) {
        System.out.println("Received data: " + data);

        String[] parts = data.split("&&");
        String name = parts[0].trim();
        String address = parts[1].trim();
        String city = parts[2].trim();

        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);

        VaccinationCenter center = new VaccinationCenter(name, address, city);
        vaccinationCenterService.save(center);
    }

    @PostMapping(path = "/deletecenter/{id}")
    @ResponseBody
    public void DeleteCenter(@PathVariable long id) {
        vaccinationCenterService.delete(id);
    }

    @PostMapping(path = "updatecenter/{data}")
    public void UpdateCenter(@PathVariable String data) {
        String[] parts = data.split("&&");
        String name = parts[0].trim();
        String address = parts[1].trim();
        String city = parts[2].trim();
        String id = parts[3].trim();
        Long new_Id = Long.parseLong(id);
        VaccinationCenter vaccinationCenter = new VaccinationCenter(name, address, city, new_Id);

        vaccinationCenterService.update(vaccinationCenter);
    }

}
