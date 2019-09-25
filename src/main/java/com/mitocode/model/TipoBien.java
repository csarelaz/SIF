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
import javax.persistence.Table;

/**
 *
 * @author CesarMiguel
 */
@Entity
@Table(name = "tipobien")
public class TipoBien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Cod_TipoBien;

    @Column(name = "DatosAdicionales")
    private String DatosAdicionales;
    
    @Column(name = "KDep")
    private Double KDep;

    public String getDatosAdicionales() {
        return DatosAdicionales;
    }

    public void setDatosAdicionales(String DatosAdicionales) {
        this.DatosAdicionales = DatosAdicionales;
    }

    public Double getKDep() {
        return KDep;
    }

    public void setKDep(Double KDep) {
        this.KDep = KDep;
    }

    public int getCod_TipoBien() {
        return Cod_TipoBien;
    }

    public void setCod_TipoBien(int Cod_TipoBien) {
        this.Cod_TipoBien = Cod_TipoBien;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.Cod_TipoBien;
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
        final TipoBien other = (TipoBien) obj;
        if (this.Cod_TipoBien != other.Cod_TipoBien) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoBien{" + "Cod_TipoBien=" + Cod_TipoBien + '}';
    }

    
    
}
