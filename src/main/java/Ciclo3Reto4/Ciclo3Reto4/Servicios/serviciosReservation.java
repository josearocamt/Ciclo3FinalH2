/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Servicios;

import Ciclo3Reto4.Ciclo3Reto4.Modelo.reservation;
import Ciclo3Reto4.Ciclo3Reto4.Reportes.reporteContadorClientes;
import Ciclo3Reto4.Ciclo3Reto4.Reportes.reporteStatusReservas;
import Ciclo3Reto4.Ciclo3Reto4.Repositorios.RepositorioReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAM AROPUM
 */
@Service
public class serviciosReservation {
        
    @Autowired
    private RepositorioReservation metodosCrud;
    
    public List<reservation> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<reservation> getreservation(int idReservation){
        return metodosCrud.getreservation(idReservation);
    }
    
    public reservation save(reservation reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<reservation> evt=metodosCrud.getreservation(reservation.getIdReservation());
            if(evt.isEmpty()){
            return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    public reservation update(reservation reservation){
        if(reservation.getIdReservation()!=null) {
            Optional<reservation> evt=metodosCrud.getreservation(reservation.getIdReservation());
            if(!evt.isEmpty()){
                if(reservation.getStartDate()!=null){
                    evt.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null) {
                   evt.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null) {
                   evt.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return reservation;
            }
        }else{
             return reservation;
        }
    }

    public boolean deleteReservation(int reservationId){
        Boolean aBoolean = getreservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
        public reporteStatusReservas reporteStatusServicio (){
        List<reservation>completed= metodosCrud.ReservacionStatusRepositorio("completed");
        List<reservation>cancelled= metodosCrud.ReservacionStatusRepositorio("cancelled");
        
        return new reporteStatusReservas(completed.size(), cancelled.size() );
    }
    
    public List<reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    } 
    
    public List<reporteContadorClientes> reporteClientesServicio(){
            return metodosCrud.getClientesRepositorio();
    }

   
}
