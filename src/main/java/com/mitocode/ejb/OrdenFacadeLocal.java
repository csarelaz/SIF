/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.ejb;

import com.mitocode.model.Orden;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CesarMiguel
 */
@Local
public interface OrdenFacadeLocal {

    void create(Orden orden);

    void edit(Orden orden);

    void remove(Orden orden);

    Orden find(Object id);

    List<Orden> findAll();

    List<Orden> findRange(int[] range);

    int count();
    
    List<Orden> findorden(int idOrden)throws Exception;
    
    List<Orden> findordenFechas(Date fechaD, Date Hasta )throws Exception;
    List<Orden> findordenEstado(String estado )throws Exception;
    List<Orden> findordenLab(int idlab )throws Exception;
}
