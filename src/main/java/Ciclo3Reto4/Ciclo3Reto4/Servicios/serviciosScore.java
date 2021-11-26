/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Servicios;

import Ciclo3Reto4.Ciclo3Reto4.Modelo.score;
import Ciclo3Reto4.Ciclo3Reto4.Repositorios.RepositorioScore;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAM AROPUM
 */
@Service
public class serviciosScore {
             
    @Autowired
    private RepositorioScore metodosCrud;
    
    public List<score> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<score> getscore(int id){
        return metodosCrud.getscore(id);
    }
    
    public score save(score score){
        if(score.getIdScore()==null){
            return metodosCrud.save(score);
        }else{
            Optional<score> evt=metodosCrud.getscore(score.getIdScore());
            if(evt.isEmpty()){
            return metodosCrud.save(score);
            }else{
                return score;
            }
        }
    }
    
    public score update(score score){
        if(score.getIdScore()!=null) {
            Optional<score> evt=metodosCrud.getscore(score.getIdScore());
            if(!evt.isEmpty()){
                if(score.getMessageText()!=null){
                    evt.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null) {
                   evt.get().setStars(score.getStars());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return score;
            }
        }else{
             return score;
        }
    }

    public boolean deleteScore(int scoreId){
        Boolean aBoolean = getscore(scoreId).map(score -> {
            metodosCrud.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }  
}
