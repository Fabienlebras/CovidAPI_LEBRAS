package org.polytech.covid.Model;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "VaccinationCenter")
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String city;
    @OneToMany(mappedBy = "vaccinationCenter")
    private Set<Administrator> administrators = new HashSet<>();

    public VaccinationCenter(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public VaccinationCenter(String name, String address, String city, long id) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.id = id;
    }

    public VaccinationCenter() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}