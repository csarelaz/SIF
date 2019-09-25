/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.controller;

import com.mitocode.ejb.ClientesFacadeLocal;
import com.mitocode.ejb.DepartamentoFacadeLocal;
import com.mitocode.ejb.OrdenFacadeLocal;
import com.mitocode.model.Clientes;
import com.mitocode.model.Departamento;
import com.mitocode.model.Orden;
import com.mitocode.model.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped //para enviar los datos a otro formulario
public class OrdenController implements Serializable {
    @EJB
    private OrdenFacadeLocal ordenEJB;
    @EJB
    private ClientesFacadeLocal clientesEJB;
    @EJB
    private DepartamentoFacadeLocal departamentoEJB;
       
    
    @Inject
    private Orden orden;
    
    @Inject
    private Departamento departamento;
    
    @Inject
    private Clientes cliente;
    
 
    private List<Clientes> lstclientes;
    private List<Departamento> departamentos;
    private List<Orden> ordenes;

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }
    

    
    public List<Clientes> getLstclientes() {
        return lstclientes;
    }

    public void setLstclientes(List<Clientes> lstclientes) {
        this.lstclientes = lstclientes;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
    @PostConstruct
    public void init(){
       lstclientes = clientesEJB.findAll();
       departamentos = departamentoEJB.findAll();
       ordenes = ordenEJB.findAll();
    }
    
    public void registrar(){
        
        try {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        orden.setCliente(cliente);
        orden.setDepartamento(departamento);
        orden.setPersona(us.getCodigo());
        ordenEJB.create(orden);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró"));
        ordenes = ordenEJB.findorden(orden.getIdOrdenes());
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
    
    }    
    
    public void modificar(Orden ord){
        try {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        ord.setTotalorden(orden.getTotalorden());
        ord.setCliente(cliente);
        ord.setDepartamento(departamento);
        ord.setPersona(us.getCodigo());
        ordenEJB.edit(ord);
        ordenes = ordenEJB.findAll();//Verificar con datos
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha Pagado la Orden"));   
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
        
    }
    
       public void EditarOrden(){
        try {
        ordenEJB.edit(orden);
        ordenes = ordenEJB.findAll();//Verificar con datos
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha Pagado la Orden"));   
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        } 
       }
       
       
    public void asignar(Orden ordenselec) {
        this.orden = ordenselec;
        }
    
  
    public void asignarOrdeniD(Integer idorden) {
        this.orden = ordenEJB.find(idorden);
        }
    
    public void asignarNuevo() {
        this.orden = ordenEJB.find(orden.getIdOrdenes());
        }
    
   
    
}
