/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sica.dao;

import com.sica.entity.Abrigada;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Leonn Ferreira
 */

public class AbrigadaDAOTest {
    static EntityManager em;
    
    public AbrigadaDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //AnnotationConfiguration config = new AnnotationConfiguration();
       // config.addAnnotatedClass(Abrigada.class);
       // config.configure();
        //new SchemaExport(config).create(true, true); 
        em = Persistence.createEntityManagerFactory("default").createEntityManager();
        em.getTransaction().begin();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of adiciona method, of class AbrigadaDAO.
     */
    @Test
    public void testAdiciona() {
        System.out.println("adiciona");
        Abrigada a = new Abrigada();
        a.setNome("Abrigada teste ");
        a.setTelefone("061-28282828");
        a.setEndereco(" aki acola ");
        AbrigadaDAO dao = new AbrigadaDAO(em);
        dao.adiciona(a);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
