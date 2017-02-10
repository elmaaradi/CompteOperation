/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import bean.Operation;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ayoub
 */
public class OperationFacadeTest {
    
    public OperationFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class OperationFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Operation entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OperationFacade instance = (OperationFacade)container.getContext().lookup("java:global/classes/OperationFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class OperationFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Operation entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OperationFacade instance = (OperationFacade)container.getContext().lookup("java:global/classes/OperationFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class OperationFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Operation entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OperationFacade instance = (OperationFacade)container.getContext().lookup("java:global/classes/OperationFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class OperationFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OperationFacade instance = (OperationFacade)container.getContext().lookup("java:global/classes/OperationFacade");
        Operation expResult = null;
        Operation result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class OperationFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OperationFacade instance = (OperationFacade)container.getContext().lookup("java:global/classes/OperationFacade");
        List<Operation> expResult = null;
        List<Operation> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class OperationFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OperationFacade instance = (OperationFacade)container.getContext().lookup("java:global/classes/OperationFacade");
        List<Operation> expResult = null;
        List<Operation> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class OperationFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OperationFacade instance = (OperationFacade)container.getContext().lookup("java:global/classes/OperationFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByCompte method, of class OperationFacade.
     */
    @Test
    public void testFindByCompte() throws Exception {
        System.out.println("findByCompte");
        Compte compte = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OperationFacade instance = (OperationFacade)container.getContext().lookup("java:global/classes/OperationFacade");
        List<Operation> expResult = null;
        List<Operation> result = instance.findByCompte(compte);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOperation method, of class OperationFacade.
     */
    @Test
    public void testCreateOperation() throws Exception {
        System.out.println("createOperation");
        Operation operation = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OperationFacade instance = (OperationFacade)container.getContext().lookup("java:global/classes/OperationFacade");
        int expResult = 0;
        int result = instance.createOperation(operation);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
