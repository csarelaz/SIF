
package com.mitocode.controller;

import com.mitocode.ejb.ClientesFacadeLocal;
import com.mitocode.model.Clientes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author CesarMiguel
 */
@Named
@RequestScoped
public class ClientesController implements Serializable{
    
    @EJB
    private ClientesFacadeLocal clientesEJB;
    @Inject
    private Clientes clientes;
    
    private List<Clientes> lstclientes;

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    
    public List<Clientes> getLstclientes() {
        return lstclientes;
    }

    public void setLstclientes(List<Clientes> lstclientes) {
        this.lstclientes = lstclientes;
    }
    
    @PostConstruct
    public void init() {
        lstclientes = clientesEJB.findAll();
       // clientes = new clientes();
    }
    public void registrar() {
        try {
            clientesEJB.create(clientes);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));            
        }
    }
    
    public void editar(Clientes cli) {
        try {
            clientesEJB.edit(cli);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se modificó"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));            
        }
    }
        public void onRowEdit(RowEditEvent event) {
          
        
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
