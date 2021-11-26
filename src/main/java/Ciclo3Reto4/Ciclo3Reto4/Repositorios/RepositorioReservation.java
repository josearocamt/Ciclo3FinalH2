/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Repositorios;

import Ciclo3Reto4.Ciclo3Reto4.Interfaces.InterfaceReservation;
import Ciclo3Reto4.Ciclo3Reto4.Modelo.client;
import Ciclo3Reto4.Ciclo3Reto4.Modelo.reservation;
import Ciclo3Reto4.Ciclo3Reto4.Reportes.reporteContadorClientes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FAM AROPUM
 */
@Repository
public class RepositorioReservation {
       @Autowired
    private InterfaceReservation crud4;
    
    public List<reservation> getAll(){
        return (List<reservation>) crud4.findAll();
    }
    
    public Optional <reservation> getreservation(int id){
        return crud4.findById(id);
    }
    
    public reservation save(reservation reservation){
        return crud4.save(reservation);
    }  
    
    public void delete(reservation reservation){
        crud4.delete(reservation);
    }
    
         public List<reservation> ReservacionStatusRepositorio (String status){
         return crud4.findAllByStatus(status);
     }
     
     public List<reservation> ReservacionTiempoRepositorio (Date a, Date b){
         return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
    public List<reporteContadorClientes> getClientesRepositorio(){
         List<reporteContadorClientes> res = new ArrayList<>();
         List<Object[]> report = crud4.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new reporteContadorClientes((Long)report.get(i)[1],(client) report.get(i)[0]));
         }
         return res;
     }


}
