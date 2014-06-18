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
public class RegistoEventosTest {

    private static Empresa empresa;
    private static RegistoEventos instance;
    private static Utilizador utilizador;
    private static Evento evento1, evento2;
    private static MecanismoDistribuicao mecanismoDistribuicao;
    private static List<MecanismoDistribuicao> listaMecanismos;
    private static List<Evento> listaEventos;

    @BeforeClass
    public static void setUpClass() throws Exception {
        empresa = new Empresa();
        instance = new RegistoEventos(empresa);
        utilizador = new Utilizador("nome", "username", "pwd", "email@email.com");
        evento1 = new Evento("titulo1", "descricao1");
        evento2 = new Evento();
        empresa.getM_registaUtilizador().addUtilizador(utilizador);
        empresa.setM_registoEventos(instance);
        evento1.addOrganizador("username", utilizador);
        instance.registaEvento(evento1);
        listaMecanismos = new ArrayList<>();
        listaEventos = new ArrayList<>();
        
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of registaEvento method, of class RegistoEventos.
     */
    @Test
    public void testRegistaEvento() {
        System.out.println("registaEvento");
        boolean expResult = true;
        boolean result = instance.registaEvento(evento1);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEventosOrganizador method, of class RegistoEventos.
     */
    @Test
    public void testGetEventosOrganizador() {

        System.out.println("getEventosOrganizador");
        String strId = "username";
        List<Evento> expResult = new ArrayList<>();
        expResult.add(evento1);
        List<Evento> result = instance.getEventosOrganizador(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaEventosPodeSubmeter method, of class RegistoEventos.
     */
    @Test
    public void testGetListaEventosPodeSubmeter() {
        System.out.println("getListaEventosPodeSubmeter");
        List<Evento> expResult = new ArrayList<>();
        expResult.add(evento1);
        List<Evento> result = instance.getListaEventosPodeSubmeter();
        assertEquals(expResult, result);
    }

    /**
     * Test of novoEvento method, of class RegistoEventos.
     */
    @Test
    public void testNovoEvento() {
        System.out.println("novoEvento");
        Evento expResult = evento2;
        Evento result = instance.novoEvento();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_listaMecanismoDistribuicao method, of class RegistoEventos.
     */
    @Test
    public void testGetM_listaMecanismoDistribuicao() {
        System.out.println("getM_listaMecanismoDistribuicao");
        instance.setM_listaMecanismoDistribuicao(listaMecanismos);
        List<MecanismoDistribuicao> expResult = listaMecanismos;
        List<MecanismoDistribuicao> result = instance.getM_listaMecanismoDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMd method, of class RegistoEventos.
     */
    @Test
    public void testGetMd() {
        System.out.println("getMd");
        instance.setMd(mecanismoDistribuicao);
        MecanismoDistribuicao expResult = mecanismoDistribuicao;
        MecanismoDistribuicao result = instance.getMd();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEvento method, of class RegistoEventos.
     */
    @Test
    public void testGetEvento() {
        System.out.println("getEvento");
        String eventoID = "titulo1";
        Evento expResult = evento1;
        Evento result = instance.getEvento(eventoID);
        assertEquals(expResult, result);
    }
}
