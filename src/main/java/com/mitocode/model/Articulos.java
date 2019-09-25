/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articulos")
public class Articulos implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticulos;
    
    @Column(name = "Descripcion_Art")
    private String Descripcion_Art;
    
    @Column(name = "Costo_Art")
    private Double Costo_Art;
    
    @Column(name = "IdEmp")
    private String IdEmp;
    
     @Column(name = "Estado")
    private boolean Estado = true;
     
    @Column(name = "IVA")
    private Double iva;
    
    @Column(name = "Modificable")
    private String modificable;
    
     
    @ManyToOne
    @JoinColumn(name = "Id_Departemento")
    private Departamento idDepartamento;

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public int getIdArticulos() {
        return idArticulos;
    }

    public void setIdArticulos(int idArticulos) {
        this.idArticulos = idArticulos;
    }

    public String getDescripcion_Art() {
        return Descripcion_Art;
    }

    public void setDescripcion_Art(String Descripcion_Art) {
        this.Descripcion_Art = Descripcion_Art;
    }

    public Double getCosto_Art() {
        return Costo_Art;
    }

    public void setCosto_Art(Double Costo_Art) {
        this.Costo_Art = Costo_Art;
    }

    public String getIdEmp() {
        return IdEmp;
    }

    public void setIdEmp(String IdEmp) {
        this.IdEmp = IdEmp;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public String getModificable() {
        return modificable;
    }

    public void setModificable(String modificable) {
        this.modificable = modificable;
    }
    
    

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

        
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idArticulos;
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
        final Articulos other = (Articulos) obj;
        if (this.idArticulos != other.idArticulos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Articulos{" + "idArticulos=" + idArticulos + '}';
    }
                
            
    
}
