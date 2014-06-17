/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.io.File;
import java.io.FileOutputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import states.EventoDecididoState;
import states.EventoState;
import states.SubmissaoAceiteState;
import states.SubmissaoNotificadaAceiteState;
import states.SubmissaoState;

/**
 *
 * @author Pereira
 */
public class NotificarAutoresTest {
    private Empresa empresa;
    private Evento e;
    private Utilizador m_utilizador;
    private Artigo m_artigo;
    private Autor m_autor;
    private EventoState e_state;
    
    private Submissao sub;
    private SubmissaoState sub_state;
    
    public NotificarAutoresTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        e=new Evento();
        sub= new Submissao();
        e.setState(e_state);
        sub.setState(sub_state);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of NotificarAutores method, of class NotificarAutores.
     */
   /* @Test
    public void testNotificarAutores() throws Exception {
        System.out.println("NotificarAutores");
        NotificarAutores instance = new NotificarAutores();
        FileOutputStream fop = null;
          File file;
                file = new File("Submissao.xml");
                fop = new FileOutputStream(file);
                   file.createNewFile();
                fop.close();
                boolean expResult= (file.exists()) ;   
                 boolean result = instance.NotificarAutores();
                assertEquals(expResult, result);
     
    }*/
   
    /**
     * Test of valida method, of class NotificarAutores.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        boolean pass= false;
        

        NotificarAutores instance = new NotificarAutores();
        
        if( e.getState() instanceof EventoDecididoState && sub.getState() instanceof SubmissaoNotificadaAceiteState)
         pass= true;
         
        boolean result = instance.valida();
        boolean expResult = pass;
               
        assertEquals(expResult, result);
            
        }
     
    
    
    
}
