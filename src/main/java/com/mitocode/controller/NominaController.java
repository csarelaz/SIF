
package com.mitocode.controller;

import com.mitocode.ejb.NominaFacadeLocal;
import com.mitocode.model.Nomina;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class NominaController implements Serializable{
    
    @EJB
    private NominaFacadeLocal nominaEJB;
    @Inject
    private Nomina nomina;

    public Nomina getNomina() {
        return nomina;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }
    
    public void registrar() {
        try {
            nominaEJB.create(nomina);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));            
        }
    }
    
}
