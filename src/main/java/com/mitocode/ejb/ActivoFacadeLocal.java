/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.ejb;

import com.mitocode.model.Activo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CesarMiguel
 */
@Local
public interface ActivoFacadeLocal {

    void create(Activo activo);

    void edit(Activo activo);

    void remove(Activo activo);

    Activo find(Object id);

    List<Activo> findAll();

    List<Activo> findRange(int[] range);

    int count();
    
    List<Activo> buscar(int CodTipoBien) throws Exception;
    
    List<Activo> buscarCI(int idNomina) throws Exception;
    
}
