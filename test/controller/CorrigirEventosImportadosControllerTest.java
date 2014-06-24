package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Utilizador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import states.EventoCriadoState;
import states.EventoLidoFicheiroState;

/**
 * Classe de teste à classe CorrigirEventosImportadosController.
 *
 * @author GRUPO66 LAPR2
 */
public class CorrigirEventosImportadosControllerTest {
    
    private CorrigirEventosImportadosController instance;
    private List<Evento> listaEventos;
    private Evento evento;
    private Empresa empresa;
    private Utilizador u; 
    
    public CorrigirEventosImportadosControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        empresa = new Empresa();
        instance = new CorrigirEventosImportadosController(empresa);
        evento = new Evento();
        evento.setTitulo("12th International CDIO Conference, Turku, Finland");
        evento.setState(new EventoLidoFicheiroState(evento));
        instance.setStrTitulo_old("12th International CDIO Conference, Turku, Finland");
        empresa.getM_registoEventos().registaEvento(evento);
        u = new Utilizador("teste","teste","teste","teste@isep.ipp.pt");
        evento.addOrganizador("teste", u);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getListaEventosCarregados method, of class CorrigirEventosImportadosController.
     */
    @Test
    public void testGetListaEventosCarregados() {
        System.out.println("getListaEventosCarregados");
        List<Evento> expResult = new ArrayList();
        expResult.add(evento);
        List<Evento> result = instance.getListaEventosCarregados();
        assertEquals(expResult, result);
    }

    /**
     * Test of registaEvento method, of class CorrigirEventosImportadosController.
     */
    @Test
    public void testRegistaEvento() {
        System.out.println("registaEvento");
        instance.registaEvento();
        int result = 0;
        for (Evento e : empresa.getM_registoEventos().getM_listaEventos()) {
            if(e.getState() instanceof EventoCriadoState)
                result++;
        }
        int expResult = 1;
        assertEquals(expResult, result);
    }

    /**
     * Test of addOrganizador method, of class CorrigirEventosImportadosController.
     */
    @Test
    public void testAddOrganizador() {
        System.out.println("addOrganizador");
        Utilizador u2 = new Utilizador("teste2","teste2","teste2","teste2@isep.ipp.pt");
        boolean expResult = true;
        boolean result = instance.addOrganizador(u2);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaNomeEvento method, of class CorrigirEventosImportadosController.
     */
    @Test
    public void testValidaNomeEvento() {
        System.out.println("validaNomeEvento");
        String ID = "12th International CDIO Conference, Turku, Finland";

        boolean expResult = true;
        boolean result = instance.validaNomeEvento(ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNovosOrganizadores method, of class CorrigirEventosImportadosController.
     */
    @Test
    public void testGetNovosOrganizadores() {
        System.out.println("getNovosOrganizadores");
        instance.resetNovosOrganizadores();
        instance.getNovosOrganizadores().add(u);
        List<Utilizador> expResult = new ArrayList();
        expResult.add(u);
        List<Utilizador> result = instance.getNovosOrganizadores();
        assertEquals(expResult, result);
    }

    /**
     * Test of resetNovosOrganizadores method, of class CorrigirEventosImportadosController.
     */
    @Test
    public void testResetNovosOrganizadores() {
        System.out.println("resetNovosOrganizadores");
        instance.resetNovosOrganizadores();
        int result = instance.getNovosOrganizadores().size();
        int expResult = 0;
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isOrganizador method, of class CorrigirEventosImportadosController.
     */
    @Test
    public void testIsOrganizador() {
        System.out.println("isOrganizador");
        String orgID = "teste@isep.ipp.pt";
        boolean expResult = true;
        boolean result = instance.isOrganizador(orgID);
        assertEquals(expResult, result);
    }
    
}
