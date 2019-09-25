
package com.mitocode.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column(name = "Nombres_Cliente")
    private String Nombres_Cliente;
    
    @Column(name = "Apellidos_Cliente")
    private String Apellidos_Cliente;

    @Column(name = "CI")
    private String CI_Cliente;
    
    @Column(name = "Dir_Cliente")
    private String Dir_Cliente;
    
    @Column(name = "Email_Cliente")
    private String Email_Cliente;

    @Column(name = "Telefono_Cliente")
    private String Telefono_Cliente; 
    
    @Column(name = "IdEmp")
    private String IdEmp; 

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres_Cliente() {
        return Nombres_Cliente;
    }

    public void setNombres_Cliente(String Nombres_Cliente) {
        this.Nombres_Cliente = Nombres_Cliente;
    }

    public String getApellidos_Cliente() {
        return Apellidos_Cliente;
    }

    public void setApellidos_Cliente(String Apellidos_Cliente) {
        this.Apellidos_Cliente = Apellidos_Cliente;
    }

    public String getCI_Cliente() {
        return CI_Cliente;
    }

    public void setCI_Cliente(String CI_Cliente) {
        this.CI_Cliente = CI_Cliente;
    }

    public String getDir_Cliente() {
        return Dir_Cliente;
    }

    public void setDir_Cliente(String Dir_Cliente) {
        this.Dir_Cliente = Dir_Cliente;
    }

    public String getEmail_Cliente() {
        return Email_Cliente;
    }

    public void setEmail_Cliente(String Email_Cliente) {
        this.Email_Cliente = Email_Cliente;
    }

    public String getTelefono_Cliente() {
        return Telefono_Cliente;
    }

    public void setTelefono_Cliente(String Telefono_Cliente) {
        this.Telefono_Cliente = Telefono_Cliente;
    }

    public String getIdEmp() {
        return IdEmp;
    }

    public void setIdEmp(String IdEmp) {
        this.IdEmp = IdEmp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idCliente;
        return hash; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clientes other = (Clientes) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clientes{" + "idCliente=" + idCliente + '}';
    }
    
    
    
    
}
