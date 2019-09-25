/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ordenes")
public class Orden implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrdenes;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "Observacion")
    private String observacion;
    
    //csar.sn - campos adicionales de orden de servicio
    
    @Column(name = "Adicional1")
    private String add1;

    @Column(name = "Adicional2")
    private String add2;
    
     @Column(name = "Adicional3")
    private String add3;

    @Column(name = "Adicional4")
    private String add4;
    
    @Column(name = "Adicional5")
    private String add5;

    @Column(name = "Adicional6")
    private String add6;
    
    @Column(name = "Adicional7")
    private String add7;

    @Column(name = "Muestra1")
    private String muestra1;
    
    @Column(name = "Muestra2")
    private String muestra2;
    
    @Column(name = "Muestra3")
    private String muestra3;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Fecha", insertable = false)
    private Date fecha;

    @Column(name = "TotalOrden")
    private Double totalorden;

    @Column(name = "IVA")
    private Double iva;   
    
    @Column(name = "idEmp")
    private String IdEmp;
    
    @Column(name = "Sigla")
    private String sigla;
    
    @Column(name = "Numorden")
    private int numorden;
   
    //csar.en
    
    @ManyToOne
    @JoinColumn(name = "DEPARTAMENTO_idDepartamento", nullable = false)
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "CLIENTES_idCliente", nullable = false)
    private Clientes cliente;
    
    @ManyToOne
    @JoinColumn(name = "Persona_codigo", nullable = false)
    private Persona persona;

    public int getIdOrdenes() {
        return idOrdenes;
    }

    public void setIdOrdenes(int idOrdenes) {
        this.idOrdenes = idOrdenes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotalorden() {
        return totalorden;
    }

    public void setTotalorden(Double totalorden) {
        this.totalorden = totalorden;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public String getIdEmp() {
        return IdEmp;
    }

    public void setIdEmp(String IdEmp) {
        this.IdEmp = IdEmp;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getAdd3() {
        return add3;
    }

    public void setAdd3(String add3) {
        this.add3 = add3;
    }

    public String getAdd4() {
        return add4;
    }

    public void setAdd4(String add4) {
        this.add4 = add4;
    }

    public String getAdd5() {
        return add5;
    }

    public void setAdd5(String add5) {
        this.add5 = add5;
    }

    public String getAdd6() {
        return add6;
    }

    public void setAdd6(String add6) {
        this.add6 = add6;
    }

    public String getAdd7() {
        return add7;
    }

    public void setAdd7(String add7) {
        this.add7 = add7;
    }

    public String getMuestra1() {
        return muestra1;
    }

    public void setMuestra1(String muestra1) {
        this.muestra1 = muestra1;
    }

    public String getMuestra2() {
        return muestra2;
    }

    public void setMuestra2(String muestra2) {
        this.muestra2 = muestra2;
    }

    public String getMuestra3() {
        return muestra3;
    }

    public void setMuestra3(String muestra3) {
        this.muestra3 = muestra3;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getNumorden() {
        return numorden;
    }

    public void setNumorden(int numorden) {
        this.numorden = numorden;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idOrdenes;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orden other = (Orden) obj;
        if (this.idOrdenes != other.idOrdenes) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orden{" + "idOrdenes=" + idOrdenes + '}';
    }
    
    
    
    
}
