
package com.mitocode.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dependencia")
public class Dependencia implements Serializable{
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private int idDependencia;
   
   @Column(name = "Descripcion_Dep")
   private String Descripcion_Dep;
   
   @Column(name = "Lugar_Dep")
   private String Lugar_Dep;
      
   @Column(name = "Referencia_Dep")
   private String Referencia_Dep;
         
   @Column(name = "IdEmp")
   private String IdEmp;

    public int getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(int idDependencia) {
        this.idDependencia = idDependencia;
    }

    public String getDescripcion_Dep() {
        return Descripcion_Dep;
    }

    public void setDescripcion_Dep(String Descripcion_Dep) {
        this.Descripcion_Dep = Descripcion_Dep;
    }

    public String getLugar_Dep() {
        return Lugar_Dep;
    }

    public void setLugar_Dep(String Lugar_Dep) {
        this.Lugar_Dep = Lugar_Dep;
    }

    public String getReferencia_Dep() {
        return Referencia_Dep;
    }

    public void setReferencia_Dep(String Referencia_Dep) {
        this.Referencia_Dep = Referencia_Dep;
    }

    public String getIdEmp() {
        return IdEmp;
    }

    public void setIdEmp(String IdEmp) {
        this.IdEmp = IdEmp;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idDependencia;
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
        final Dependencia other = (Dependencia) obj;
        if (this.idDependencia != other.idDependencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dependencia{" + "idDependencia=" + idDependencia + '}';
    }
   
    
}
