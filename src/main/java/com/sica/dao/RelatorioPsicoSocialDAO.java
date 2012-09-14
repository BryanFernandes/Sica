/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sica.dao;

import br.com.caelum.vraptor.ioc.Component;
import com.sica.entity.RelatorioPsicoSocial;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Bryan
 */
@Component
public class RelatorioPsicoSocialDAO {
    private EntityManager manager;
        
    public RelatorioPsicoSocialDAO(EntityManager manager){
        this.manager = manager;
    }
    
        public void deleta(RelatorioPsicoSocial relatorioPsicoSocial){
        relatorioPsicoSocial = manager.getReference(RelatorioPsicoSocial.class, relatorioPsicoSocial.getId());
        manager.remove(relatorioPsicoSocial);
        manager.getTransaction().commit();
    }
}


