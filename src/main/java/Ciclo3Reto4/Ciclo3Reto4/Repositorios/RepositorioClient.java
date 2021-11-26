/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Repositorios;

import Ciclo3Reto4.Ciclo3Reto4.Interfaces.InterfaceClient;
import Ciclo3Reto4.Ciclo3Reto4.Modelo.client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FAM AROPUM
 */
@Repository
public class RepositorioClient {
     
    @Autowired
    
    private InterfaceClient crud1;
    
    public List<client> getAll(){
        return (List<client>) crud1.findAll();
    }
    
    public Optional <client> getclient(int id){
        return crud1.findById(id);
    }
    
    public client save(client client){
        return crud1.save(client);
    }

    public void delete(client client){
        crud1.delete(client);
    }
       
}
