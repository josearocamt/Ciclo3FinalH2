/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Servicios;

import Ciclo3Reto4.Ciclo3Reto4.Modelo.partyroom;
import Ciclo3Reto4.Ciclo3Reto4.Repositorios.RepositorioPartyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAM AROPUM
 */
@Service
public class serviciosPartyroom {
        
    @Autowired
    
    private RepositorioPartyroom metodosCrud;
    
    public List<partyroom> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<partyroom> getpartyroom(int partyroomId){
        return metodosCrud.getPartyroom(partyroomId);
    }
    
    public partyroom save(partyroom partyroom){
        if(partyroom.getId()==null){
            return metodosCrud.save(partyroom);
        }else{
            Optional<partyroom> evt=metodosCrud.getPartyroom(partyroom.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(partyroom);
            }else{
                return partyroom;
            }
        }
    }
    
    public partyroom update(partyroom partyroom){
        if(partyroom.getId()!=null) {
            Optional<partyroom> evt=metodosCrud.getPartyroom(partyroom.getId());
            if(!evt.isEmpty()){
                if(partyroom.getName()!=null){
                    evt.get().setName(partyroom.getName());
                }
                if(partyroom.getOwner()!=null) {
                   evt.get().setOwner(partyroom.getOwner());
                }
                if(partyroom.getCapacity()!=null) {
                    evt.get().setCapacity(partyroom.getCapacity());
                }
                if(partyroom.getDescription()!=null) {
                    evt.get().setDescription(partyroom.getDescription());
                } 
                if(partyroom.getCategory()!=null){
                    evt.get().setCategory(partyroom.getCategory());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return partyroom;
            }
        }else{
             return partyroom;
        }
    }

    public boolean deletePartyroom(int partyroomId){
        Boolean aBoolean = getpartyroom(partyroomId).map(partyroom -> {
            metodosCrud.delete(partyroom);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
