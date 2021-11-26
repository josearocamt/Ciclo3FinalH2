/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Repositorios;

import Ciclo3Reto4.Ciclo3Reto4.Interfaces.InterfaceCategory;
import Ciclo3Reto4.Ciclo3Reto4.Modelo.category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FAM AROPUM
 */
@Repository
public class RepositorioCategory {
        
    @Autowired
    
    private InterfaceCategory crud;
    
    public List<category> getAll(){
        return (List<category>) crud.findAll();
    }
    
    public Optional <category> getcategory(int id){
        return crud.findById(id);
    }
    
    public category save(category category){
        return crud.save(category);
    }
    
    public void delete(category category){
        crud.delete(category);
    }
}
