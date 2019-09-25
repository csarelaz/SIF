
package com.mitocode.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departemento")
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartamento;
    
    @Column(name = "Nombre_Dep")
    private String Nombre_Dep;
    
    @Column(name = "Telefono")
    private String Telefono;
    
    @Column(name = "Direccion_Dep")
    private String Direccion_Dep;
    
    @Column(name = "SecuencialOrden")
    private int SecuencialOrden;
    
    @Column(name = "IdEmp")
    private String IdEmp;
    
    @Column(name = "Sigla")
    private String sigla;
    
       
    @Column(name = "Txtimp")
    private String txtimp;
    

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre_Dep() {
        return Nombre_Dep;
    }

    public void setNombre_Dep(String Nombre_Dep) {
        this.Nombre_Dep = Nombre_Dep;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion_Dep() {
        return Direccion_Dep;
    }

    public void setDireccion_Dep(String Direccion_Dep) {
        this.Direccion_Dep = Direccion_Dep;
    }

    public int getSecuencialOrden() {
        return SecuencialOrden;
    }

    public void setSecuencialOrden(int SecuencialOrden) {
        this.SecuencialOrden = SecuencialOrden;
    }

    
    public String getIdEmp() {
        return IdEmp;
    }

    public void setIdEmp(String IdEmp) {
        this.IdEmp = IdEmp;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getTxtimp() {
        return txtimp;
    }

    public void setTxtimp(String txtimp) {
        this.txtimp = txtimp;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.idDepartamento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departamento other = (Departamento) obj;
        if (this.idDepartamento != other.idDepartamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Departamento{" + "idDepartamento=" + idDepartamento + '}';
    }

    
    
}
