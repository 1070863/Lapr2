/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pereira
 */
public class DecisaoTest {
     private List<Distribuicao> listaDistribuicao;
     private Decisao decisao;
     private final String nome = "MecanismoDecisao1";
     private Decisao m_decisao;
    public DecisaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        m_decisao=new Decisao("aceite");
         int aceite;
        int recusada;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test do método getDecisao, da class Decisao, este é o único método testado
     * as instancia m_decisao já está instanciada com o "valor" aceite pelo que
     * basta fazer um get e compara-las
     */
    @Test
    public void testGetDecisao() {
        System.out.println("getDecisao");
        Decisao instance = new Decisao();
        instance= m_decisao;
        String expResult = "aceite";
        String result = instance.getDecisao();
        assertEquals(expResult, result);
       
    }

   
    
}
