/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lopes
 */
public class DistribuicaoTest {
    
    private static List<Revisor> listaRevisor;
    private static Revisor revisor;
    private static Artigo artigo;
    private static Distribuicao instance;
    
    public DistribuicaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        revisor = new Revisor();
        listaRevisor = new ArrayList<>();
        listaRevisor.add(revisor);
        artigo = new Artigo();
        instance = new Distribuicao();
                
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
     * Test of getM_listaRevisores & setM_listaRevisores method, of class Distribuicao.
     */
    @Test
    public void testGetM_listaRevisores() {
        System.out.println("getM_listaRevisores");  
        instance.setM_listaRevisores(listaRevisor);
        List<Revisor> expResult = listaRevisor;
        List<Revisor> result = instance.getM_listaRevisores();
        assertEquals(expResult, result);

    }

    /**
     * Test of getM_artigo & setM_artigo method, of class Distribuicao.
     */
    @Test
    public void testGetM_artigo() {
        System.out.println("getM_artigo");
        instance.setM_artigo(artigo);
        Artigo expResult = artigo;
        Artigo result = instance.getM_artigo();
        assertEquals(expResult, result);
    }   

}
