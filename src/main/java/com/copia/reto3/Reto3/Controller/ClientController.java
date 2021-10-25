package com.copia.reto3.Reto3.Controller;

import com.copia.reto3.Reto3.entity.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.copia.reto3.Reto3.Service.ClientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Client")
public class ClientController {
    @Autowired
    private ClientService servicio;
    
    @PostMapping("/save")
    public ResponseEntity addCliente(@RequestBody Client cliente){
        servicio.saveClient(cliente);
        return ResponseEntity.status(201).build();      
    }
    
   @GetMapping("/all")
   public List<Client> getAllClients(){
       return servicio.getClientAll();
   }
   
   @GetMapping("{id}")
   public Client findClientsById(@PathVariable int id){
       return servicio.getClientById(id);
   }
   
   @PutMapping("/update")
   public ResponseEntity updateClient(@RequestBody Client cliente){
      servicio.updateClient(cliente);
      return ResponseEntity.status(201).build();
              
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity deleteClient(@PathVariable int id){
       servicio.deleteClient(id);
       return ResponseEntity.status(204).build();
   }
       
}
