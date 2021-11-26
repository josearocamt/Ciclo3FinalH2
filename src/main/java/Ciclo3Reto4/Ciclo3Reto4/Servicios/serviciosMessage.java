/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Servicios;

import Ciclo3Reto4.Ciclo3Reto4.Modelo.message;
import Ciclo3Reto4.Ciclo3Reto4.Repositorios.RepositorioMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAM AROPUM
 */
@Service
public class serviciosMessage {
             
    @Autowired
    private RepositorioMessage metodosCrud;
    
    public List<message> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<message> getmessage(int id){
        return metodosCrud.getmessage(id);
    }
    
    public message save(message message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<message> evt=metodosCrud.getmessage(message.getIdMessage());
            if(evt.isEmpty()){
            return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }
    
    public message update(message message){
        if(message.getIdMessage()!=null) {
            Optional<message> evt=metodosCrud.getmessage(message.getIdMessage());
            if(!evt.isEmpty()){
                if(message.getMessageText()!=null){
                    evt.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return message;
            }
        }else{
             return message;
        }
    }

    public boolean deleteMessage(int messageId){
        Boolean aBoolean = getmessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
