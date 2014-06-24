package controller;

import eventoscientificos.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;
import states.EventoCriadoFicheiroState;

/**
 * Classe de teste à classe CarregarEventosController.
 *
 * @author GRUPO66 LAPR2
 */
public class CarregarEventosControllerTest {

    private CarregarEventosController instance;
    private List<Evento> listaEventos;
    private Evento evento;
    private Empresa empresa;

    public CarregarEventosControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParserConfigurationException, SAXException, IOException {
        empresa = new Empresa();
        instance = new CarregarEventosController(empresa);
        evento = new Evento();
        evento.setTitulo("12th International CDIO Conference, Turku, Finland");
        evento.setState(new EventoCriadoFicheiroState(evento));
        listaEventos = new ArrayList<>();
        listaEventos.add(evento);
        instance.setFicheiro("EventList_CDIO.csv");
        empresa.getM_registoEventos().getEvento("12th International CDIO Conference, Turku, Finland");
    }

    @After
    public void tearDown() {
    }

     /**
     * Test of mostrarListaProvisoria method, of class
     * CarregarEventosController.
     */
    @Test
    public void testSetFicheiro() throws Exception {
        System.out.println("setFicheiro");
        int expResult = instance.setFicheiro("ficheiro.xpto");
        int result = 1;
        assertEquals(expResult, result);
    }

    /**
     * Test of mostrarListaProvisoria method, of class
     * CarregarEventosController.
     */
    @Test
    public void testMostrarListaProvisoria() {
        System.out.println("mostrarListaProvisoria");
        String expResult = listaEventos.get(0).getM_strTitulo();
        String result = instance.mostrarListaProvisoria().get(0).getM_strTitulo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEvento method, of class CarregarEventosController.
     */
    @Test
    public void testSetEvento() {
        System.out.println("setEvento");
        instance.setEvento(evento);
        String expResult = evento.getM_strTitulo();
        String result = empresa.getM_registoEventos().getEvento("12th International CDIO Conference, Turku, Finland").getM_strTitulo();

        assertEquals(expResult, result);
    }

    /**
     * Test of apagaEventosDesnecessarios method, of class CarregarEventosController.
     */
    @Test
    public void testApagaEventosDesnecessarios() {
        System.out.println("apagaEventosDesnecessarios");
        instance.apagaEventosDesnecessarios();
        int result = instance.mostrarListaProvisoria().size();
        int expResult = 0;
        assertEquals(expResult, result);
    }



}
