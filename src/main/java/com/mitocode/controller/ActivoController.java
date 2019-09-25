
package com.mitocode.controller;

import com.mitocode.ejb.ActivoFacadeLocal;
import com.mitocode.ejb.DependenciaFacadeLocal;
import com.mitocode.ejb.NominaFacadeLocal;
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
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class ActivoController implements Serializable{
  
    @EJB
    private ActivoFacadeLocal activoEJB;
    @EJB
    private NominaFacadeLocal nominaEJB;
    @EJB
    private DependenciaFacadeLocal dependenciaEJB;
    
    @EJB
    private TipoBienFacadeLocal tipobienEJB;
    
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
    private List <TipoBien> tiposbien;    
    
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
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
    try{
   // activos = activoEJB.findRange(a);    
    activos = activoEJB.findAll();
    dependencias = dependenciaEJB.findAll();
    nominas = nominaEJB.findAll();
    tiposbien = tipobienEJB.findAll();
    }
    catch (Exception e)
            {              
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));    
            }
    }
    
        public void registrar(){
        
        try {
        activo.setIdDependencia(dependencia);
        activo.setIdNomina(nomina);
        activo.setIdCodTipoBien(tipobien);
        activo.setIdACTIVOAdj(activo);
        activoEJB.create(activo);  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró"));
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
       
    }
        public void mostrarDialogo(){
        //logica
        this.setAccion("R");
        
        RequestContext req = RequestContext.getCurrentInstance();
        req.execute("PF('wdialogo').show();");
    }
    
    public void leerAct(Activo actselec)
    {
        activo = actselec;

    }
        
        
   public void modificar(Activo act){
       try {
        act.setIdDependencia(dependencia);
        act.setIdNomina(nomina);
        act.setIdACTIVOAdj(activo);
        activoEJB.edit(act);
        activos = activoEJB.findAll();//Verificar con datos
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se modificó"));
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
        
    }
    
    
    
}
