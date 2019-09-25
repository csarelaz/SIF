
package com.mitocode.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nomina")
public class Nomina implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNomina;

    @Column(name = "Nombres")
    private String Nombres;
    
    @Column(name = "Apellidos")
    private String Apellidos;

    @Column(name = "Direccion")
    private String Direccion;
        
    @Column(name = "CI")
    private String CI;
    
    @Column(name = "Cargo")
    private String Cargo;
    
    @Column(name = "Jefe")
    private String Jefe;

    @Column(name = "Telefono")
    private String Telefono; 
    
    @Column(name = "IdEmp")
    private String IdEmp;    

    public int getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(int idNomina) {
        this.idNomina = idNomina;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getJefe() {
        return Jefe;
    }

    public void setJefe(String Jefe) {
        this.Jefe = Jefe;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
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
        hash = 97 * hash + this.idNomina;
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
        final Nomina other = (Nomina) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Nomina{" + "idNomina=" + idNomina + '}';
    }
    
    
    
}
