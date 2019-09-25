/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.controller;

import com.mitocode.ejb.NotaFacadeLocal;
import com.mitocode.ejb.OrdenFacadeLocal;
import com.mitocode.model.Orden;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author CesarMiguel
 */

@Named
@ViewScoped
public class RegistrarPagoController implements Serializable {
  
@EJB
private OrdenFacadeLocal ordenEJB;
 @Inject
    private OrdenController ordencontroller;
    private Orden orden;
    
    @PostConstruct
    public void init() {
        this.orden = ordencontroller.getOrden();
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
    
    public void EditarOrden(){
        try {
        ordenEJB.edit(orden);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha Registrado la Orden número: " + orden.getIdOrdenes()));   
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        } 
       }
    
    
}
