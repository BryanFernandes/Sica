/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sica.util;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Leonn Ferreira
 */
@ApplicationScoped
@Component
public class HibernateUtil {
    private final SessionFactory factory;
    
    public HibernateUtil(){
        factory = new AnnotationConfiguration().configure().buildSessionFactory();
    }
    
    public Session getSession(){
        return factory.openSession();
    }
}
