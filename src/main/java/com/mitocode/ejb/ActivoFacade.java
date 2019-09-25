/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.ejb;

import com.mitocode.model.Activo;
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
public class ActivoFacade extends AbstractFacade<Activo> implements ActivoFacadeLocal {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActivoFacade() {
        super(Activo.class);
    }
    
    @Override
    public List<Activo> buscar(int CodTipoBien) throws Exception {
        List<Activo> lista;
        try {
            String jpql = "FROM Activo a WHERE a.idCodTipoBien.Cod_TipoBien = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, CodTipoBien);
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    
    @Override
    public List<Activo> buscarCI(int idnomina) throws Exception {
        List<Activo> lista;
        try {
            String jpql = "FROM Activo a WHERE a.idNomina.idNomina = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, idnomina);
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }    
}
