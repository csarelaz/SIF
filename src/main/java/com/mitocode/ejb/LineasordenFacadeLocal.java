/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.ejb;

import com.mitocode.model.Lineasorden;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CesarMiguel
 */
@Local
public interface LineasordenFacadeLocal {

    void create(Lineasorden lineasorden);

    void edit(Lineasorden lineasorden);

    void remove(Lineasorden lineasorden);

    Lineasorden find(Object id);

    List<Lineasorden> findAll();

    List<Lineasorden> findRange(int[] range);

    int count();
    
    List<Lineasorden> findListByOrden(Integer idOrden);
    
}
