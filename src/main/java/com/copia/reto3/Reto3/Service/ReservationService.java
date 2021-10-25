package com.copia.reto3.Reto3.Service;

import com.copia.reto3.Reto3.entity.Reservation;
import com.copia.reto3.Reto3.Repository.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    
      @Autowired
    private ReservationRepository repositorio;

    public Reservation saveReservation(Reservation reservation){
       return repositorio.save(reservation);
    }

    public List<Reservation> getReservationAll(){
        return repositorio.findAll();
    }

    public Reservation updateReservation(Reservation reservation){
        Reservation existeReservation=repositorio.findById(reservation.getIdReservation()).orElse(null);
        existeReservation.setStartDate(reservation.getStartDate());
        existeReservation.setDevolutionDate(reservation.getDevolutionDate());
        return repositorio.save(existeReservation);
    }

    public void deleteReservation(int idReservation){
        repositorio.deleteById(idReservation);
    }

    public Reservation getReservationById(int idReservation){
        return repositorio.findById(idReservation).orElse(null);
    }
}
