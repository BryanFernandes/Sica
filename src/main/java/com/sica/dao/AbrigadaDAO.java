/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sica.dao;

import br.com.caelum.vraptor.ioc.Component;
import com.sica.entity.Abrigada;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Leonn Ferreira
 */
@Component
public class AbrigadaDAO {
    private EntityManager manager;
    
    public AbrigadaDAO(EntityManager manager){
        this.manager = manager;
    }
    
    public void adiciona(Abrigada abrigada){
        //manager.getTransaction().begin();
        manager.persist(abrigada);
        manager.getTransaction().commit();
    }
    
    public void edita(Abrigada abrigada){
        manager.merge(abrigada);
        manager.getTransaction().commit();
    }
    
    public List<Abrigada> listaTodos() {
        Query query = manager.createQuery("from Abrigada abrigada");
        List<Abrigada> lista = query.getResultList();
        manager.close();
        return lista;
    }
    
    public void deleta(Abrigada abrigada){
        abrigada = manager.getReference(Abrigada.class, abrigada.getId());
        manager.remove(abrigada);
        manager.getTransaction().commit();
    }
    
    public Abrigada findById(Abrigada abrigada){
        return manager.find(Abrigada.class, abrigada.getId());
    }
}
