
package com.mitocode.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "lineasorden")
public class Lineasorden implements Serializable {

   @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idLineasOrden;
   
    @Column(name = "Cantidad")
    private Double cantidad;
   
    @Column(name = "Total")
    private Double Total;
   
    @Column(name = "IdEmp")
    private String idemp;
    
    @ManyToOne
    @JoinColumn(name = "ARTICULOS_idArticulos", nullable = false)
    private Articulos articulos;
    
    /*@Column(name = "ORDENES_idOrdenes")
    private String num_orden;
    */
    

    @ManyToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ORDENES_idOrdenes", nullable = false)
    private Orden idorden;

    
    public int getIdLineasOrden() {
        return idLineasOrden;
    }

    public void setIdLineasOrden(int idLineasOrden) {
        this.idLineasOrden = idLineasOrden;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public String getIdemp() {
        return idemp;
    }

    public void setIdemp(String idemp) {
        this.idemp = idemp;
    }

    public Articulos getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }
    
    

    public Orden getIdorden() {
        return idorden;
    }

    public void setIdorden(Orden idorden) {
        this.idorden = idorden;
    }
/*
    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }
    */
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idLineasOrden;
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
        final Lineasorden other = (Lineasorden) obj;
        if (this.idLineasOrden != other.idLineasOrden) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lineasorden{" + "idLineasOrden=" + idLineasOrden + '}';
    }

    public void getIdorden(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
 
    
}
