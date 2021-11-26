/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3Reto4.Ciclo3Reto4.Reportes;

import Ciclo3Reto4.Ciclo3Reto4.Modelo.client;

/**
 *
 * @author FAM AROPUM
 */
public class reporteContadorClientes {
    private Long total;
    private client client;

    public reporteContadorClientes (Long total, client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public client getClient() {
        return client;
    }

    public void setClient(client client) {
        this.client = client;
    }
    
    
}
