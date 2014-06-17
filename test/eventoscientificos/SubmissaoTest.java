/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import states.SubmissaoState;
import states.SubmissaoArtigosParaRevisaoSubmetidosState;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class SubmissaoTest {
    
    private Evento evento;
    private Artigo artigo;
    
    public SubmissaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.evento = new Evento("Teste", "Evento de teste.");
        Submissao submissao = new Submissao();
        this.artigo = new Artigo();
        this.artigo.setTitulo("Artigo 1");
        this.artigo.setResumo("Artigo de teste");
        this.artigo.novoAutor("Pedro", "ISEP");
        submissao.novoArtigo();
        submissao.setArtigo(artigo);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of novoArtigo method, of class Submissao.
     */
    @Test
    public void testNovoArtigo() {
        System.out.println("novoArtigo");
        Submissao instance = new Submissao();
        instance.setArtigo(artigo);
        Artigo expResult = artigo;
        Artigo result = instance.getArtigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getInfo method, of class Submissao.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        Submissao instance = new Submissao();
        instance.setArtigo(artigo);
        String expResult = instance.getInfo();
        String result = "Submissão:\n"+this.artigo.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getArtigo method, of class Submissao.
     */
    @Test
    public void testGetArtigo() {
        System.out.println("getArtigo");
        Submissao instance = new Submissao();
        instance.setArtigo(artigo);
        Artigo expResult = instance.getArtigo();
        Artigo result = instance.getArtigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of valida method, of class Submissao.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Submissao instance = new Submissao();
        instance.setArtigo(artigo);
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setState method, of class Submissao.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        
        Submissao instance = new Submissao();
        instance.setArtigo(artigo);
        SubmissaoArtigosParaRevisaoSubmetidosState state = new 
            SubmissaoArtigosParaRevisaoSubmetidosState(instance);
        instance.setState(state);
        
        SubmissaoState expResult = state;
        SubmissaoState result = instance.getState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
