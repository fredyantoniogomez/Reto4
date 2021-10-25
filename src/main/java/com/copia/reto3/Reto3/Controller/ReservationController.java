package com.copia.reto3.Reto3.Controller;

import com.copia.reto3.Reto3.entity.Reservation;
import com.copia.reto3.Reto3.Service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Reservation")
public class ReservationController {
    
     @Autowired
    private ReservationService servicio;
    
    @PostMapping("/save")
    public ResponseEntity addReservacion(@RequestBody Reservation reservacion){
        servicio.saveReservation(reservacion);
        return ResponseEntity.status(201).build();           
    }
    
    @GetMapping("/all")
    public List<Reservation> getAllResrvations(){
        return servicio.getReservationAll();
        
    }
    
    @PutMapping("/update")
   public ResponseEntity updateReservations(@RequestBody Reservation reservacion){
      servicio.updateReservation(reservacion);
      return ResponseEntity.status(201).build();          
   }
    
    @GetMapping("{id}")
    public Reservation findReservations(@PathVariable int id){
        return servicio.getReservationById(id);
    }
    
    @DeleteMapping("/{id}")
   public ResponseEntity deleteReservation(@PathVariable int id){
       servicio.deleteReservation(id);
       return ResponseEntity.status(204).build();
   }
}
