/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.ejb;

import com.mitocode.model.Orden;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class OrdenFacade extends AbstractFacade<Orden> implements OrdenFacadeLocal {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenFacade() {
        super(Orden.class);
    }
    

    @Override
    public List<Orden> findorden(int idOrden) throws Exception {
        List<Orden> listResult = new ArrayList<Orden>();
        String consulta;
        
        try {
            consulta = "FROM Orden l WHERE l.idOrdenes = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, idOrden);            
            listResult = query.getResultList();            
        } catch (Exception e) {
            throw e;
        }
        return listResult;
    }
   
    @Override
    public List<Orden> findordenFechas(Date FechaD, Date FechaH) throws Exception {
        List<Orden> lista = new ArrayList<Orden>();
        try {
            String jpql = "FROM Orden o WHERE o.fecha > ?1 and o.fecha <= ?2";
            Query query = em.createQuery(jpql);
            query.setParameter(1, FechaD);
            query.setParameter(2, FechaH);
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

       @Override
    public List<Orden> findordenEstado(String estado) throws Exception {
        List<Orden> lista = new ArrayList<Orden>();
        try {
            String jpql = "FROM Orden o WHERE o.fecha > ?1 and o.fecha <= ?2";
            Query query = em.createQuery(jpql);
            query.setParameter(1, estado);
            
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    @Override
    public List<Orden> findordenLab(int idlab) throws Exception {
        List<Orden> listResult = new ArrayList<Orden>();
        String consulta;
        
        try {
            consulta = "FROM Orden l WHERE l.idOrdenes = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, idlab);            
            listResult = query.getResultList();            
        } catch (Exception e) {
            throw e;
        }
        return listResult;
    }
    
}
