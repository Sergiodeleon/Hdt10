/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt10;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sergio
 */
public class GrafoTest {
    
    public GrafoTest() {
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
     * Test of agregar method, of class Grafo.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar");
        String ciudad = "Ciudad1";
        Grafo instance = new Grafo();
        instance.agregar(ciudad);
    }

    /**
     * Test of agregarGrafo method, of class Grafo.
     */
    @Test
    public void testAgregarGrafo() {
        System.out.println("agregarGrafo");
        String ciudad1 = "ciudad1";
        String ciudad2 = "ciudad2";
        int d = 2;
        Grafo instance = new Grafo();
        instance.agregarGrafo(ciudad1, ciudad2,d);
    }

}
