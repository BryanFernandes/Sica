/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sica.dao;

import br.com.caelum.vraptor.ioc.Component;
import com.sica.entity.Pertence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Leonn Ferreira
 */
@Component
public class PertenceDAO {
    private EntityManager manager;
    
    public PertenceDAO(EntityManager manager){
        this.manager = manager;
    }
    
    public void adiciona(Pertence pertence){
        
        manager.persist(pertence);
        manager.getTransaction().commit();
    }
    
    public void edita(Pertence pertence){
        manager.merge(pertence);
        manager.getTransaction().commit();
    }
    
    public List<Pertence> listaTodos(Pertence pertence) {
        Query query = manager.createQuery("from Pertence pertence where idAbrigada = "+pertence.getIdAbrigada());
        List<Pertence> lista = query.getResultList();
        //manager.close();
        return lista;
    }
    
    public void deleta(Pertence pertence){
        pertence = manager.getReference(Pertence.class, pertence.getId());
        manager.remove(pertence);
        manager.getTransaction().commit();
    }
    
    public Pertence findById(Pertence pertence){
        return manager.find(Pertence.class, pertence.getId());
    }
}
