package Service;

import org.polytech.covid.Model.Reservation;
import org.polytech.covid.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Iterable<Reservation> getVaccination() {
        return reservationRepository.findAll();
    }

    public void save(Reservation reservationService) {
        reservationRepository.save(reservationService);

    }

    public void delete(long id) {
        reservationRepository.deleteById(id);
    }

    public void update(Reservation reservationService) {

        if (reservationRepository.existsById(reservationService.getId())) {
            reservationRepository.save(reservationService);
        }

    }

}
