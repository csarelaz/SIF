/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.ejb;

import com.mitocode.model.Lineasorden;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CesarMiguel
 */
@Stateless
public class LineasordenFacade extends AbstractFacade<Lineasorden> implements LineasordenFacadeLocal {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineasordenFacade() {
        super(Lineasorden.class);
    }

    @Override
    public List<Lineasorden> findListByOrden(Integer idOrden) {
        List<Lineasorden> listResult = new ArrayList<Lineasorden>();
        String consulta;
        
        try {
            consulta = "FROM Lineasorden l WHERE l.idorden.idOrdenes = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, idOrden);            
            listResult = query.getResultList();            
        } catch (Exception e) {
            throw e;
        }
        return listResult;
    }
    
}
