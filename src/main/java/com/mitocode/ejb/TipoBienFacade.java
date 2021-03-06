/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.ejb;

import com.mitocode.model.TipoBien;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CesarMiguel
 */
@Stateless
public class TipoBienFacade extends AbstractFacade<TipoBien> implements TipoBienFacadeLocal {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoBienFacade() {
        super(TipoBien.class);
    }
    
}
