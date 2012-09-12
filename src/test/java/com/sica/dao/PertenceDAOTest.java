/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sica.dao;

import com.sica.entity.Pertence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author leonn
 */
public class PertenceDAOTest {
    static EntityManager em;
    static Pertence pertence;
    static PertenceDAO instance;
    
    public PertenceDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(Pertence.class);
        config.configure();
        new SchemaExport(config).create(true, true);
        em = Persistence.createEntityManagerFactory("default").createEntityManager();
        em.getTransaction().begin();
        pertence = new Pertence(0, "Anel de oru 25 kilates",1,"jóias", Long.parseLong("1"));
        instance = new PertenceDAO(em);     
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        if(!em.getTransaction().isActive())
            em.getTransaction().begin();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of adiciona method, of class PertenceDAO.
     */
    @Test
    public void testAdiciona() {
        instance.adiciona(pertence);
        pertence.setId(1);
        assertNotNull(instance.findById(pertence));
        assertEquals(1,instance.findById(pertence).getId());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of edita method, of class PertenceDAO.
     */
    @Test
    public void testEdita() {
        Assert.assertNotSame("itens de valor",instance.findById(pertence).getCategoria());
        pertence.setCategoria("itens de valor");
        instance.edita(pertence);
        assertNotNull(instance.findById(pertence));
        assertEquals("itens de valor",instance.findById(pertence).getCategoria());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of listaTodos method, of class PertenceDAO.
     */
    @Test
    public void testListaTodos() {
        List result = instance.listaTodos(pertence);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of findById method, of class PertenceDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        pertence.setId(1);
        Pertence result = instance.findById(pertence);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    

    /**
     * Test of deleta method, of class PertenceDAO.
     */
    @Test
    public void testDeleta() {
        pertence.setId(1);
        instance.deleta(pertence);
        assertNull(instance.findById(pertence));
    }
}
