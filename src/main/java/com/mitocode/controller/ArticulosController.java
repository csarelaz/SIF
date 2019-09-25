package com.mitocode.controller;

import com.mitocode.ejb.ArticulosFacadeLocal;
import com.mitocode.ejb.DepartamentoFacadeLocal;
import com.mitocode.model.Articulos;
import com.mitocode.model.Departamento;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class ArticulosController implements Serializable{
    
    @EJB
    private ArticulosFacadeLocal articulosEJB;
    @EJB
    private DepartamentoFacadeLocal DepartamentoEJB;
    
    @Inject
    private Articulos articulo;
    @Inject
    private Departamento Deparatamento;
    
    private List <Departamento> Departamentos;
    private List <Articulos> articulos;
    private String accion;

    public Articulos getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulos articulo) {
        this.articulo = articulo;
    }

    public List<Articulos> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulos> articulos) {
        this.articulos = articulos;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Departamento getDeparatamento() {
        return Deparatamento;
    }

    public void setDeparatamento(Departamento Deparatamento) {
        this.Deparatamento = Deparatamento;
    }

    public List<Departamento> getDepartamentos() {
        return Departamentos;
    }

    public void setDepartamentos(List<Departamento> Departamentos) {
        this.Departamentos = Departamentos;
    }
      
    
     @PostConstruct
    public void init() {
    articulos = articulosEJB.findAll();
    Departamentos = DepartamentoEJB.findAll();
    }
    
    public void registrar()
    {
            articulo.setIdDepartamento(Deparatamento);
            articulosEJB.create(articulo);
            articulos = articulosEJB.findAll();
    }
    
    public void leer(Articulos artSeleccion) {
        articulo = artSeleccion;
        this.setAccion("M");
    }
    
    public void modificar(Articulos art){
    articulo.setIdDepartamento(Deparatamento);    
    articulosEJB.edit(art);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se modificó"));
    }
    
    public void mostrarDialogo(){
        //logica
        this.setAccion("R");
        
        RequestContext req = RequestContext.getCurrentInstance();
        req.execute("PF('wdialogo').show();");
    }
}
