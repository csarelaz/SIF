/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.controller;

import com.mitocode.ejb.LineasordenFacadeLocal;
import com.mitocode.model.Lineasorden;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Monica
 */

@Named
@RequestScoped
public class AgregarlineasController implements Serializable{
    @EJB
    private LineasordenFacadeLocal lineasordenEJB;
    
    @Inject
     private Lineasorden lineasorden;

    public Lineasorden getLineasorden() {
        return lineasorden;
    }

    public void setLineasorden(Lineasorden lineasorden) {
        this.lineasorden = lineasorden;
    }
    
    public void asignar(Lineasorden lineasorden) {
        this.lineasorden = lineasorden;
    }
    
   

}
