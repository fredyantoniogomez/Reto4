package com.copia.reto3.Reto3.Service;

import com.copia.reto3.Reto3.entity.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.copia.reto3.Reto3.Repository.MessageRepository;


@Service
public class MessageService {
    @Autowired
    private MessageRepository repositorio;

    public Message saveMessage(Message mensaje){
        return repositorio.save(mensaje);
    }

    public List<Message> getMessageAll(){
        return repositorio.findAll();
    }

    public Message updateMessage(Message mensaje){
        Message existeMensaje=repositorio.findById(mensaje.getIdMessage()).orElse(null);
        //essage existeMensaje=getMessageById(mensaje.getIdMessage());
        existeMensaje.setMessageText(mensaje.getMessageText());
        return repositorio.save(existeMensaje);
    }

    public void deleteMessage(int idMessage){
        repositorio.deleteById(idMessage);
    }

    public Message getMessageById(int id){
        return repositorio.findById(id).orElse(null);
    }
}

    
    

