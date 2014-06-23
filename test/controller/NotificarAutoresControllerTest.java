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
    private List<Evento> listaEventos;
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
       re.getM_listaEventos().add(e);
       listaEventos= re.getM_listaEventos();
       re.registaEvento(e);
       
    }
    
    @After
    public void tearDown() {
    }
   

    /**
     * Test of getListaEventosProntosNotificar method, of class NotificarAutoresController.
     */
    @Test
    public void testGetListaEventosProntosNotificar() {
        System.out.println("getListaEventosProntosNotificar");
        boolean a= false;
        NotificarAutoresController instance = new NotificarAutoresController(empresa);
        listaEventos=instance.getListaEventosProntosNotificar(org.getM_utilizador().getM_strUsername());
         if(listaEventos.get(0)!=null )
             a=true;
        boolean expResult = true;       
        boolean result = a;
        assertEquals(expResult, result);
    }

    
}
