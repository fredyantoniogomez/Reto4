package com.copia.reto3.Reto3.Controller;

import com.copia.reto3.Reto3.entity.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.copia.reto3.Reto3.Service.MessageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService servicio;
    
    @PostMapping("/save")
    public ResponseEntity addMensaje(@RequestBody Message mensaje){
        servicio.saveMessage(mensaje);
        return ResponseEntity.status(201).build();      
    }
    
   @GetMapping("/all")
   public List<Message> getAllMensajes(){
       return servicio.getMessageAll();
   }
    
   
   @GetMapping("{id}")
   public Message findMessagesById(@PathVariable int id){
       return servicio.getMessageById(id);
   }
   
   @PutMapping("/update")
   public ResponseEntity updateMessages(@RequestBody Message mensaje){
      servicio.updateMessage(mensaje);
      return ResponseEntity.status(201).build();          
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity deleteMessages(@PathVariable int idMessage){
       servicio.deleteMessage(idMessage);
       return ResponseEntity.status(204).build();
   }
}
