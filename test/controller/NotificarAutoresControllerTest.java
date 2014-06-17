/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import eventoscientificos.Evento;
import eventoscientificos.Organizador;
import eventoscientificos.Utilizador;
import eventoscientificos.*;
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
public class NotificarAutoresControllerTest {
    private Empresa empresa;
    private RegistoEventos re;
    private Utilizador u;
    private  Organizador org;
    private  Evento e;
    private  Artigo a;
    private Autor autor ;
    private Submissao s;
    public NotificarAutoresControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
      empresa= new Empresa();
      re= new RegistoEventos(empresa);
      empresa.setM_registoEventos(re);
      u= new Utilizador("Sergio","Sergio","sergio","sergio@mail.com");
      empresa.getM_registaUtilizador().addUtilizador(u);
      Evento e=empresa.getM_registoEventos().novoEvento();
      e.setTitulo("Ser");
      e.setLocal("isep");
      e.setDescricao("Descrição");
      org= new Organizador("sergio",u);
     s=empresa.getM_registoEventos().novoEvento().novaSubmissao();
     a=empresa.getM_registoEventos().novoEvento().novaSubmissao().novoArtigo();
        a.setTitulo("Titulo");
        a.setResumo("Esperança");
        a.setFicheiro("Nau da esperança");
        autor = a.novoAutor("Isep", u.getM_strEmail());
        autor.setAfiliacao("isep");
        autor.setM_Utilizador(u);
        autor.setNome(u.getM_strNome());
        a.addAutor(autor);
        e.addSubmissao(s);
        re.registaEvento(e);
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of iniciarSubmissao method, of class NotificarAutoresController.
     */
    @Test
    public void testIniciarSubmissao() {
        System.out.println("iniciarSubmissao");
        NotificarAutoresController instance = new NotificarAutoresController(empresa);
        e.addSubmissao(s);
        re.getListaEventosPodeSubmeter().add(e);
        List<Evento> expResult = re.getListaEventosPodeSubmeter();
        List<Evento> result = instance.iniciarSubmissao();
        assertEquals(expResult, result);
      
    }

   

    /**
     * Test of getListaEventosProntosNotificar method, of class NotificarAutoresController.
     */
    @Test
    public void testGetListaEventosProntosNotificar() {
        System.out.println("getListaEventosProntosNotificar");
        String[] listaEventos= new String[re.getListaEventosProntosNotificar().size()];
        for (Evento evento : re.getListaEventosProntosNotificar()) {
            listaEventos[re.getListaEventosProntosNotificar().indexOf(evento)]=
                    evento.getM_strTitulo();}
        NotificarAutoresController instance = new NotificarAutoresController(empresa);
        System.out.println(listaEventos);
        String[] expResult = listaEventos;
        String[] result = instance.getListaEventosProntosNotificar();
        assertArrayEquals(expResult, result);
    }

    
}
