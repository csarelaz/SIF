/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.controller;

import com.mitocode.ejb.ActivoFacadeLocal;
import com.mitocode.ejb.TipoBienFacadeLocal;
import com.mitocode.model.Activo;
import com.mitocode.model.Dependencia;
import com.mitocode.model.Nomina;
import com.mitocode.model.TipoBien;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class Depreciar2Controller implements Serializable{
 
    @EJB
    private ActivoFacadeLocal activoEJB;
       
    @EJB
    private TipoBienFacadeLocal tipobienEJB;
    
    @Inject
    private Activo activo;
    
    @Inject
    private DepreciarControler depreciarcontroler;
    
    @Inject
    private TipoBien tipobien;
    
    private List <Activo> activos;

    private List <TipoBien> tiposbien;  

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public TipoBien getTipobien() {
        return tipobien;
    }

    public void setTipobien(TipoBien tipobien) {
        this.tipobien = tipobien;
    }

    public List<Activo> getActivos() {
        return activos;
    }

    public void setActivos(List<Activo> activos) {
        this.activos = activos;
    }

    public List<TipoBien> getTiposbien() {
        return tiposbien;
    }

    public void setTiposbien(List<TipoBien> tiposbien) {
        this.tiposbien = tiposbien;
    }
    
    
    
    @PostConstruct
    public void init(){   
    try{ 
    activos = depreciarcontroler.getActivos();
    
    }
    catch (Exception e)
            {              
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));    
            }
    }  
    
    
}
