package org.polytech.covid;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.polytech.covid.Model.Patient;
import org.polytech.covid.Repository.PatientRepository;
import org.polytech.covid.Service.PatientService;

public class ServicePatientTest {
    PatientRepository patientRepository;
    PatientService patientService;
    Patient patient1;

    @BeforeEach
    void setUp() {
        patientRepository = Mockito.mock(PatientRepository.class);
        patientService = Mockito.mock(PatientService.class);
    }

    @Test
    void testAddPatient() {
        Mockito.doNothing().when(patientService).save(patient1);
        patientService.save(patient1);
        Mockito.verify(patientService, Mockito.times(1)).save(patient1);
    }

    @Test
    void testDeletePatient() {
        Mockito.doNothing().when(patientService).delete(1);
        patientService.delete(1);
        Mockito.verify(patientService, Mockito.times(1)).delete(1);
        Optional<Patient> result = patientService.getPatientById(1);
        Assertions.assertThat(result).isEqualTo(Optional.empty());
    }

}
