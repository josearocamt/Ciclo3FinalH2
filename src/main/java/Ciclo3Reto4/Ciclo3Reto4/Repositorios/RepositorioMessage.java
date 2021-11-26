/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Repositorios;

import Ciclo3Reto4.Ciclo3Reto4.Interfaces.InterfaceMessage;
import Ciclo3Reto4.Ciclo3Reto4.Modelo.message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FAM AROPUM
 */
@Repository
public class RepositorioMessage {
       @Autowired
    private InterfaceMessage crud2;
    
    public List<message> getAll(){
        return (List<message>) crud2.findAll();
    }
    
    public Optional <message> getmessage(int id){
        return crud2.findById(id);
    }
    
    public message save(message message){
        return crud2.save(message);
    }
    
    public void delete(message message){
        crud2.delete(message);
    }

}
