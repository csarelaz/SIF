/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.controller;

import com.mitocode.ejb.ArticulosFacadeLocal;
import com.mitocode.ejb.ClientesFacadeLocal;
import com.mitocode.ejb.DepartamentoFacadeLocal;
import com.mitocode.ejb.LineasordenFacadeLocal;
import com.mitocode.ejb.OrdenFacadeLocal;
import com.mitocode.model.Articulos;
import com.mitocode.model.Clientes;
import com.mitocode.model.Departamento;
import com.mitocode.model.Lineasorden;
import com.mitocode.model.Orden;
import com.mitocode.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped 
public class Orden2Controller implements Serializable {
    @EJB
    private OrdenFacadeLocal ordenEJB;
    @EJB
    private ClientesFacadeLocal clientesEJB;
    @EJB
    private DepartamentoFacadeLocal departamentoEJB;
    @EJB
    private LineasordenFacadeLocal lineasordenEJB;
    @EJB
    private ArticulosFacadeLocal articulosEJB;
       
    
    @Inject
    private Orden orden;
    
    @Inject
    private Departamento departamento;
    
    @Inject
    private Clientes cliente;
    
    @Inject
    private Lineasorden lineasorden;
    
    @Inject
    private Articulos articulos;
    
    private Double cantidad;
    private int numordenDep;
    private int iddepartamentoselc;
    private Double Totallin;
    private Double TotallinIVA;
    
 
    private List<Clientes> lstclientes;
    private List<Departamento> departamentos;
    private List<Orden> ordenes;
    private ArrayList<Lineasorden> lineas = new ArrayList<>();
    private List<Articulos> lstarticulos;

    public List<Articulos> getLstarticulos() {
        return lstarticulos;
    }

    public void setLstarticulos(List<Articulos> lstarticulos) {
        this.lstarticulos = lstarticulos;
    }

    public ArrayList<Lineasorden> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<Lineasorden> lineas) {
        this.lineas = lineas;
    }

          
    
    
    

    
    
    
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

   // public Lineasorden getLineasorden() {
    //    return lineasorden;
    //}

    //public void setLineasorden(Lineasorden lineasorden) {
     //   this.lineasorden = lineasorden;
   // }

    public Articulos getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    
    
        
    @PostConstruct
    public void init(){
       lstclientes = clientesEJB.findAll();
       departamentos = departamentoEJB.findAll();
       ordenes = ordenEJB.findAll();
       //Lineas = lineasordenEJB.findAll();
      //lstarticulos = articulosEJB.findAll();
       
    }
    //codigo para listar los articulos segun el departamento 
    public void listarart (int departamento){
    lstarticulos = articulosEJB.findListByDepa(departamento);
    lineas.clear(); //limpia las lineas si cambia de departamento
    
    //lstarticulos = articulosEJB.findAll();
    
    }
    
      public void stateChangeListener(ValueChangeEvent event) {
        //if(event.getNewValue()!=null)
       iddepartamentoselc = (Integer)event.getNewValue();
        listarart(iddepartamentoselc);
        
        }
    
    public void registrar(int coddep){
        
        try {
        //Incrementar num de Orden por departamento escojido
        Departamento dep = new Departamento();
        dep = departamentoEJB.find(coddep);
        numordenDep = dep.getSecuencialOrden();
        numordenDep++;
        dep.setSecuencialOrden(numordenDep);
        departamentoEJB.edit(dep);
        
        
        //Registrar orden    
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        orden.setCliente(cliente);
        orden.setDepartamento(departamento);
        orden.setPersona(us.getCodigo());
        orden.setNumorden(numordenDep);
        ordenEJB.create(orden);
        
            //agregar lineas de la orden
            for(Lineasorden lin2 : lineas)
            {
            //lineasorden.getArticulos();
            lin2.setArticulos(articulos);//cod de art seleccionado
            lin2.setCantidad(cantidad);
            lin2.setIdorden(orden);//Cod orden registrada anterior OJO si no se setea el valor se reistra 2 veces
            Totallin = cantidad * lin2.getArticulos().getCosto_Art();//TOtal de la linea
            TotallinIVA = Totallin * (1+(lin2.getArticulos().getIva()/100)); //Total linea con IVA
            lin2.setTotal(TotallinIVA);
            lineasordenEJB.create(lin2);
        
        }
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró orden Numero"+ numordenDep ));
        //ordenes = ordenEJB.findorden(orden.getIdOrdenes());
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" ));
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
    
    
    public void agregarlinea(){
        
        Lineasorden lin = new Lineasorden();
        //lin.setIdLineasOrden(idlo);
        lin.setArticulos(articulos);
        lin.setCantidad(cantidad);
            this.lineas.add(lin);
            
        
        }
   
    
}