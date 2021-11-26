/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Repositorios;

import Ciclo3Reto4.Ciclo3Reto4.Interfaces.InterfaceAdmin;
import Ciclo3Reto4.Ciclo3Reto4.Modelo.admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FAM AROPUM
 */
@Repository
public class RepositorioAdmin {
   @Autowired
    
    private InterfaceAdmin crud;
    
    public List<admin> getAll(){
        return (List<admin>) crud.findAll();
    }
    
    public Optional <admin> getadmin(int id){
        return crud.findById(id);
    }
    
    public admin save(admin admin){
        return crud.save(admin);
    }
    
    public void delete(admin admin){
        crud.delete(admin);
    }
}
