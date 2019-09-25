package com.mitocode.controller;
import com.mitocode.ejb.ActivoFacadeLocal;
import com.mitocode.ejb.DependenciaFacadeLocal;
import com.mitocode.ejb.NominaFacadeLocal;
import com.mitocode.ejb.TipoBienFacadeLocal;
import com.mitocode.ejb.TransaccionActivoFacadeLocal;
import com.mitocode.model.Activo;
import com.mitocode.model.Dependencia;
import com.mitocode.model.Nomina;
import com.mitocode.model.TipoBien;
import com.mitocode.model.TransaccionActivo;
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
public class TransaccionActivoController implements Serializable{
  
    @EJB
    private TransaccionActivoFacadeLocal transaccionactivoEJB;
    @EJB
    private ActivoFacadeLocal activoEJB;
    @EJB
    private NominaFacadeLocal nominaEJB;
    @EJB
    private DependenciaFacadeLocal dependenciaEJB;
    
    @EJB
    private TipoBienFacadeLocal tipobienEJB;
    
    @Inject
    private TransaccionActivo Transaccionactivo;
    @Inject
    private Activo activo;
    @Inject
    private Nomina nomina;
    @Inject
    private Dependencia dependencia;
    @Inject
    private TipoBien tipobien;
    
    private List <Activo> activos;
    private List <Nomina> nominas;
    private List <Dependencia> dependencias;
    private List <TransaccionActivo> TransaccionesActivos;
    private List <TipoBien> tiposbien;

    public TransaccionActivo getTransaccionactivo() {
        return Transaccionactivo;
    }

    public void setTransaccionactivo(TransaccionActivo Transaccionactivo) {
        this.Transaccionactivo = Transaccionactivo;
    }

    public List<TransaccionActivo> getTransaccionesActivos() {
        return TransaccionesActivos;
    }

    public void setTransaccionesActivos(List<TransaccionActivo> TransaccionesActivos) {
        this.TransaccionesActivos = TransaccionesActivos;
    }

    
    public TipoBien getTipobien() {
        return tipobien;
    }

    public void setTipobien(TipoBien tipobien) {
        this.tipobien = tipobien;
    }

    public List<TipoBien> getTiposbien() {
        return tiposbien;
    }

    public void setTiposbien(List<TipoBien> tiposbien) {
        this.tiposbien = tiposbien;
    }

    
  
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
     

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public Nomina getNomina() {
        return nomina;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public List<Activo> getActivos() {
        return activos;
    }

    public void setActivos(List<Activo> activos) {
        this.activos = activos;
    }

    public List<Nomina> getNominas() {
        return nominas;
    }

    public void setNominas(List<Nomina> nominas) {
        this.nominas = nominas;
    }

    public List<Dependencia> getDependencias() {
        return dependencias;
    }

    public void setDependencias(List<Dependencia> dependencias) {
        this.dependencias = dependencias;
    }
    
    @PostConstruct
    public void init(){
    //TransaccionesActivos = transaccionactivoEJB.findAll();//ojo con la sobrecarga
    //activos = activoEJB.findAll();//ojo con la sobrecarga
    dependencias = dependenciaEJB.findAll();
    tiposbien = tipobienEJB.findAll();
    nominas = nominaEJB.findAll();
    }
    
    public void buscar() {
        try {

            TransaccionesActivos = transaccionactivoEJB.buscarTipoBien(tipobien.getCod_TipoBien());
  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
    
    public void buscarACT() {
        try {

         activos = activoEJB.buscar(tipobien.getCod_TipoBien());
  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
    
    public void buscarACTTrans() {
        try {

         TransaccionesActivos = transaccionactivoEJB.buscarIdActivo(activo.getIdActivos());
  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
    
    
        public void mostrarDialogo(){
        //logica
        this.setAccion("R");
        
        RequestContext req = RequestContext.getCurrentInstance();
        req.execute("PF('wdialogo').show();");
    }
    
    
}
