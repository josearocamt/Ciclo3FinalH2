/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Repositorios;

import Ciclo3Reto4.Ciclo3Reto4.Interfaces.InterfaceScore;
import Ciclo3Reto4.Ciclo3Reto4.Modelo.score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FAM AROPUM
 */
@Repository
public class RepositorioScore {
           
    @Autowired
    
    private InterfaceScore crud;
    
    public List<score> getAll(){
        return (List<score>) crud.findAll();
    }
    
    public Optional <score> getscore(int id){
        return crud.findById(id);
    }
    
    public score save(score score){
        return crud.save(score);
    }
    
    public void delete(score score){
        crud.delete(score);
    }
}
