package org.polytech.covid.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vaccination")
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Patient patient;
    private String vaccinationDate;
    private boolean validate;
    @ManyToOne
    private Doctor doctor;

    public Vaccination(Patient patient, String vaccinationDate, Doctor doctor) {

        this.patient = patient;
        this.vaccinationDate = vaccinationDate;
        this.doctor = doctor;
        this.validate = false;
    }

    public Vaccination(Patient patient, String vaccinationDate, Doctor doctor, Boolean validate) {

        this.patient = patient;
        this.vaccinationDate = vaccinationDate;
        this.doctor = doctor;
        this.validate = validate;
    }

    public Vaccination() {

    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(String vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

}
