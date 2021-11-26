/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Servicios;

import Ciclo3Reto4.Ciclo3Reto4.Modelo.admin;
import Ciclo3Reto4.Ciclo3Reto4.Repositorios.RepositorioAdmin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAM AROPUM
 */
@Service
public class serviciosAdmin {
          
    @Autowired
    private RepositorioAdmin metodosCrud;
    
    public List<admin> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<admin> getadmin(int id){
        return metodosCrud.getadmin(id);
    }
    
    public admin save(admin admin){
        if(admin.getIdAdmin()==null){
            return metodosCrud.save(admin);
        }else{
            Optional<admin> evt=metodosCrud.getadmin(admin.getIdAdmin());
            if(evt.isEmpty()){
            return metodosCrud.save(admin);
            }else{
                return admin;
            }
        }
    }
    
    public admin update(admin admin){
        if(admin.getIdAdmin()!=null) {
            Optional<admin> evt=metodosCrud.getadmin(admin.getIdAdmin());
            if(!evt.isEmpty()){
                if(admin.getEmail()!=null){
                    evt.get().setName(admin.getEmail());
                }
                if(admin.getName()!=null) {
                   evt.get().setName(admin.getName());
                }
                if(admin.getPassword()!=null) {
                   evt.get().setPassword(admin.getPassword());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return admin;
            }
        }else{
             return admin;
        }
    }

    public boolean deleteAdmin(int adminId){
        Boolean aBoolean = getadmin(adminId).map(admin -> {
            metodosCrud.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }  
}
