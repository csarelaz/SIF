/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.controller;

import com.mitocode.ejb.ActivoFacadeLocal;
import com.mitocode.ejb.DependenciaFacadeLocal;
import com.mitocode.ejb.NominaFacadeLocal;
import com.mitocode.ejb.TipoBienFacadeLocal;
import com.mitocode.model.Activo;
import com.mitocode.model.Dependencia;
import com.mitocode.model.Nomina;
import com.mitocode.model.TipoBien;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author CesarMiguel
 */

//@ManagedBean(name = "depControl")
@Named
@RequestScoped
public class DepreciarControler implements Serializable {
    
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
    
    private int CodTipoBien ;
    //private Date Fechadepre;

    public TipoBienFacadeLocal getTipobienEJB() {
        return tipobienEJB;
    }

    public void setTipobienEJB(TipoBienFacadeLocal tipobienEJB) {
        this.tipobienEJB = tipobienEJB;
    }

    public Activo getActivo() {
        return activo;
    }

    public int getCodTipoBien() {
        return CodTipoBien;
    }

    public void setCodTipoBien(int CodTipoBien) {
        this.CodTipoBien = CodTipoBien;
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

    public List<TipoBien> getTiposbien() {
        return tiposbien;
    }

    public void setTiposbien(List<TipoBien> tiposbien) {
        this.tiposbien = tiposbien;
    }


@PostConstruct
    public void init(){   
    try{ 
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
    private long TotalFecha;
    private Double DepAcumulada;
    
        public void buscar() {
        try {

            activos = activoEJB.buscar(tipobien.getCod_TipoBien());
   /*         for (Activo activos : activos) {
                 
                 activos.setValResidual(activos.getValContable()*0.1);
                 TotalFecha = (((activos.getFechaDep().getTime()/86400000) - (activos.getFecha_Ingreso().getTime()/86400000))+1)/365;
                 DepAcumulada = TotalFecha * ((activos.getValContable() - activos.getValResidual())/activos.getVidaUtil());
                 activos.setValDepAcum(DepAcumulada);
                 activos.setValLibros(activos.getValContable()-DepAcumulada); 
            
            }*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
        public void Depreciar(List<Activo> Act, Date Fechadepre) {
        try {

           activos = activoEJB.buscar(tipobien.getCod_TipoBien());
           //Date Hoy = new Date();
            for (Activo activos : activos) {
                 
                 activos.setValResidual(activos.getValContable()*0.1);
                 activos.setFechaDep(Fechadepre);
                 TotalFecha = (((activos.getFechaDep().getTime()/86400000) - (Fechadepre.getTime()/86400000))+1)/365;
                 DepAcumulada = TotalFecha * ((activos.getValContable() - activos.getValResidual())/activos.getVidaUtil());
                 activos.setValDepAcum(DepAcumulada);
                 activos.setValLibros(activos.getValContable()-DepAcumulada);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
        
        public void registrar(List<Activo> Act, Date Fechadepre){
        
        try {
        activos = activoEJB.buscar(tipobien.getCod_TipoBien());
           //Date Hoy = new Date();
            for (Activo activo : activos) {
                 
                 activo.setValResidual(activo.getValContable()*0.1);
                 activo.setFechaDep(Fechadepre);
                 TotalFecha = (((activo.getFechaDep().getTime()/86400000) - (Fechadepre.getTime()/86400000))+1)/365;
                 DepAcumulada = TotalFecha * ((activo.getValContable() - activo.getValResidual())/activo.getVidaUtil());
                 activo.setValDepAcum(DepAcumulada);
                 activo.setValLibros(activo.getValContable()-DepAcumulada);
                 activoEJB.edit(activo); 
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró"));
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
        
        
        }
        public void asignar() {
           
            for (Activo activos : activos) {
                  activo.setValLibros(11.00);
            }
        }
        

    
    
    
}
