/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sica.dao;

import com.sica.entity.Dependente;
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
public class DependenteDAOTest {
    static EntityManager em;
    static Dependente dependente;
    static DependenteDAO instance;
    
    public DependenteDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(Dependente.class);
        config.configure();
        new SchemaExport(config).create(true, true);
        em = Persistence.createEntityManagerFactory("default").createEntityManager();
        em.getTransaction().begin();
        dependente = new Dependente(0, "leonn",19,"masculino", Long.parseLong("1"));
        instance = new DependenteDAO(em);     
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
     * Test of adiciona method, of class DependenteDAO.
     */
    @Test
    public void testAdiciona() {
        instance.adiciona(dependente);
        dependente.setId(1);
        assertNotNull(instance.findById(dependente));
        assertEquals(1,instance.findById(dependente).getId());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of edita method, of class DependenteDAO.
     */
    @Test
    public void testEdita() {
        Assert.assertNotSame("fernando",instance.findById(dependente).getNome());
        dependente.setNome("fernando");
        instance.edita(dependente);
        assertNotNull(instance.findById(dependente));
        assertEquals("fernando",instance.findById(dependente).getNome());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of listaTodos method, of class DependenteDAO.
     */
    @Test
    public void testListaTodos() {
        List result = instance.listaTodos(dependente);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of findById method, of class DependenteDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        dependente.setId(1);
        Dependente result = instance.findById(dependente);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    

    /**
     * Test of deleta method, of class DependenteDAO.
     */
    @Test
    public void testDeleta() {
        dependente.setId(1);
        instance.deleta(dependente);
        assertNull(instance.findById(dependente));
    }
}
