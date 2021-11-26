/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Repositorios;

import Ciclo3Reto4.Ciclo3Reto4.Interfaces.InterfacePartyroom;
import Ciclo3Reto4.Ciclo3Reto4.Modelo.partyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FAM AROPUM
 */
@Repository
public class RepositorioPartyroom {
      
    @Autowired
    
    private InterfacePartyroom crud;
    
    public List<partyroom> getAll(){
        return (List<partyroom>) crud.findAll();
    }
    
    public Optional <partyroom> getPartyroom(int id){
        return crud.findById(id);
    }
    
    public partyroom save(partyroom partyroom){
        return crud.save(partyroom);
    }
    
    public void delete(partyroom partyroom){
        crud.delete(partyroom);
    }
      
}
