/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.ejb;

import com.mitocode.model.TransaccionActivo;
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
public class TransaccionActivoFacade extends AbstractFacade<TransaccionActivo> implements TransaccionActivoFacadeLocal {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionActivoFacade() {
        super(TransaccionActivo.class);
    }
    
    @Override
    public List<TransaccionActivo> buscarTipoBien(int CodTipoBien) throws Exception {
        List<TransaccionActivo> lista;
        try {
            String jpql = "FROM TransaccionActivo a WHERE a.idCodTipoBien.Cod_TipoBien = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, CodTipoBien);
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    @Override
    public List<TransaccionActivo> buscarIdActivo(int IdActivo) throws Exception {
        List<TransaccionActivo> lista;
        try {
            String jpql = "FROM TransaccionActivo a WHERE a.IdActivo.idActivos = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, IdActivo);
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

   
    
}
