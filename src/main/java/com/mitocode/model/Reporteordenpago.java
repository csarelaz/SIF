/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author CesarMiguel
 */

@Entity
@Table(name = "reporteordenpago")
public class Reporteordenpago {
    
    @Id
    @Column(name = "nroOrdePago")
    private Integer nroOrdenPago;
    
    @Column(name = "departamentoNombre")
    private String DepartamentoNombre;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha")
    private Date fechaNacimiento;

    @Column(name = "clienteNombre")
    private String clienteNombre;

    @Column(name = "Cedula")
    private String cedula;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "email")
    private String email;
    
     @Column(name = "telefonoCliente")
    private String telefono;
     
    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "descripcionArticulo")
    private String descripcion;
    
    @Column(name = "precioUnitario")
    private Double pu;

    @Column(name = "totalPago")
    private Double total; 
    
    
    
}
