/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.ControladorWeb;

import Ciclo3Reto4.Ciclo3Reto4.Modelo.reservation;
import Ciclo3Reto4.Ciclo3Reto4.Reportes.reporteContadorClientes;
import Ciclo3Reto4.Ciclo3Reto4.Reportes.reporteStatusReservas;
import Ciclo3Reto4.Ciclo3Reto4.Servicios.serviciosReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FAM AROPUM
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class reservationWeb {
        @Autowired
    private serviciosReservation servicios;
    @GetMapping("/all")
    public List <reservation> getreservation(){
       return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<reservation> getcategory(@PathVariable("id") int idReservation) {
        return servicios.getreservation(idReservation);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public reservation save(@RequestBody reservation reservation){
        return servicios.save(reservation);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public reservation update(@RequestBody reservation reservation){
        return servicios.update(reservation);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId){
        return servicios.deleteReservation(reservationId);
    }
    
        @GetMapping("/report-status")
    public reporteStatusReservas getReservas(){
        return servicios.reporteStatusServicio();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
     public List<reservation> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
         return servicios.reporteTiempoServicio(dateOne, dateTwo);
     }
     
     @GetMapping("/report-clients")
     public List<reporteContadorClientes> getClientes(){
         return servicios.reporteClientesServicio();
     }


}
