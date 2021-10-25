package com.copia.reto3.Reto3.Controller;

import com.copia.reto3.Reto3.Service.GamesService;
import com.copia.reto3.Reto3.entity.Game;
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
@RequestMapping("/api/Game")
public class GamesController {
    
    @Autowired
    private GamesService servicio;
    
    @PostMapping("/save")
    public ResponseEntity addJuego(@RequestBody Game juego){
        servicio.saveGames(juego);
        return ResponseEntity.status(201).build();      
    }
    
   @GetMapping("/all")
   public List<Game> getAllJuegos(){
       return servicio.getGamesAll();
   }
   
   @GetMapping("{id}")
   public Game findGamesId(@PathVariable int id){
       return servicio.getGamesById(id);
   }
   
   @PutMapping("/update")
   public ResponseEntity updateJuego(@RequestBody Game juego){
      servicio.updateGames(juego);
      return ResponseEntity.status(201).build();
              
   }
   @DeleteMapping("/{id}")
   public ResponseEntity deleteGames(@PathVariable int id){
       servicio.deleteGames(id);
       return ResponseEntity.status(204).build();
   }
   
}
        