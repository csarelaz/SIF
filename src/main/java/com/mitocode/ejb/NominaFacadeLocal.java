/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.ejb;

import com.mitocode.model.Nomina;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CesarMiguel
 */
@Local
public interface NominaFacadeLocal {

    void create(Nomina nomina);

    void edit(Nomina nomina);

    void remove(Nomina nomina);

    Nomina find(Object id);

    List<Nomina> findAll();

    List<Nomina> findRange(int[] range);

    int count();
    
}
