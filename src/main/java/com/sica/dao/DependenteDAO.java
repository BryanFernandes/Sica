/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sica.dao;

import br.com.caelum.vraptor.ioc.Component;
import com.sica.entity.Dependente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Leonn Ferreira
 */
@Component
public class DependenteDAO {
    private EntityManager manager;
    
    public DependenteDAO(EntityManager manager){
        this.manager = manager;
    }
    
    public void adiciona(Dependente dependente){
        
        manager.persist(dependente);
        manager.getTransaction().commit();
    }
    
    public void edita(Dependente dependente){
        manager.merge(dependente);
        manager.getTransaction().commit();
    }
    
    public List<Dependente> listaTodos(Dependente dependente) {
        Query query = manager.createQuery("from Dependente dependente where idAbrigada = "+dependente.getIdAbrigada());
        List<Dependente> lista = query.getResultList();
        //manager.close();
        return lista;
    }
    
    public void deleta(Dependente dependente){
        dependente = manager.getReference(Dependente.class, dependente.getId());
        manager.remove(dependente);
        manager.getTransaction().commit();
    }
    
    public Dependente findById(Dependente dependente){
        return manager.find(Dependente.class, dependente.getId());
    }
}
