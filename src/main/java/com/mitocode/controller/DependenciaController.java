
package com.mitocode.controller;

import com.mitocode.ejb.DependenciaFacadeLocal;
import com.mitocode.model.Dependencia;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class DependenciaController implements Serializable{
    @EJB
    private DependenciaFacadeLocal dependenciaEJB;
    @Inject
    private Dependencia dependencia;

    public DependenciaFacadeLocal getDependenciaEJB() {
        return dependenciaEJB;
    }

    public void setDependenciaEJB(DependenciaFacadeLocal dependenciaEJB) {
        this.dependenciaEJB = dependenciaEJB;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
    public void registrar() {
        try {
            dependenciaEJB.create(dependencia);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));            
        }
    }
   
}
