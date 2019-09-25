package com.mitocode.ejb;

import com.mitocode.model.Articulos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ArticulosFacade extends AbstractFacade<Articulos> implements ArticulosFacadeLocal {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticulosFacade() {
        super(Articulos.class);
    }

    @Override
    public List<Articulos> buscarArticulo() throws Exception {
        List<Articulos> lista = null;
        String consulta;
        
        try {
            consulta = "FROM Articulos a WHERE a.Estado = 0";
            Query query = em.createQuery(consulta);
            lista = query.getResultList();            
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    public List<Articulos> findListByDepa(Integer departamento) {
         List<Articulos> listResult = new ArrayList<Articulos>();
        String consulta;
        
        try {
            consulta = "FROM Articulos art WHERE art.idDepartamento.idDepartamento = ?1";// Id_Departemento
            Query query = em.createQuery(consulta);
            query.setParameter(1, departamento);  
            listResult = query.getResultList();            
        } catch (Exception e) {
            throw e;
        }
        return listResult;
    }
    
}
