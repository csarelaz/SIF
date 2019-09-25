/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.ejb;

import com.mitocode.model.Activo;
import com.mitocode.model.TransaccionActivo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CesarMiguel
 */
@Local
public interface TransaccionActivoFacadeLocal {

    void create(TransaccionActivo transaccionActivo);

    void edit(TransaccionActivo transaccionActivo);

    void remove(TransaccionActivo transaccionActivo);

    TransaccionActivo find(Object id);

    List<TransaccionActivo> findAll();

    List<TransaccionActivo> findRange(int[] range);
    
    List<TransaccionActivo> buscarTipoBien(int CodTipoBien) throws Exception;
    
    List<TransaccionActivo> buscarIdActivo(int IdActivo) throws Exception;
    
    int count();
    
}
