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
    
    /**
     * Test of getConfianca method, of class Revisor.
     */
    @Test
    public void testGetConfianca() {
        System.out.println("getConfianca");
        Distribuicao instance = new Distribuicao();
        String expResult = "0";
        instance.setConfianca(expResult);
        String result = instance.getConfianca();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdequacao method, of class Revisor.
     */
    @Test
    public void testGetAdequacao() {
        System.out.println("getAdequacao");
        Distribuicao instance = new Distribuicao();
        String expResult = "1";
        instance.setAdequacao(expResult);
        String result = instance.getAdequacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOriginalidade method, of class Revisor.
     */
    @Test
    public void testGetOriginalidade() {
        System.out.println("getOriginalidade");
        Distribuicao instance = new Distribuicao();
        String expResult = "2";
        instance.setOriginalidade(expResult);
        String result = instance.getOriginalidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQualidade method, of class Revisor.
     */
    @Test
    public void testGetQualidade() {
        System.out.println("getQualidade");
        Distribuicao instance = new Distribuicao();
        String expResult = "3";
        instance.setQualidade(expResult);
        String result = instance.getQualidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRecomendacao method, of class Revisor.
     */
    @Test
    public void testGetRecomendacao() {
        System.out.println("getRecomendacao");
        Distribuicao instance = new Distribuicao();
        boolean expResult = true;
        instance.setRecomendacao(expResult);
        boolean result = instance.getRecomendacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTextoJustificativo method, of class Revisor.
     */
    @Test
    public void testGetTextoJustificativo() {
        System.out.println("getTextoJustificativo");
        Distribuicao instance = new Distribuicao();
        String expResult = "Teste texto";
        instance.setTextoJustificativo(expResult);
        String result = instance.getTextoJustificativo();
        assertEquals(expResult, result);
    }

}
