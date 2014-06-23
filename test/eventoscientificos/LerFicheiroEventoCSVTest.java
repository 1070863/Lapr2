/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

import tratarficheiros.LerFicheiroEventoCSV;
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
public class LerFicheiroEventoCSVTest {

    private LerFicheiroEventoCSV instance;
    private Utilizador utilizador, utilizador2;
    private Evento evento, evento2;
    private Empresa empresa, empresa2;
    private List<String[]> listaString;
    private String[] s1, s2;

    public LerFicheiroEventoCSVTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        utilizador = new Utilizador("Doris Brodeur", "DorisB", "123", "cdio2013@mit.edu");
        utilizador2 = new Utilizador("Paul Revere", "PaulR", "123", "revere@harvard.edu");
        instance = new LerFicheiroEventoCSV();
        empresa = new Empresa();
        evento = empresa.getM_registoEventos().novoEvento();
        evento.setTitulo("EventoTitulo");
        empresa.getM_registoEventos().registaEvento(evento);
        empresa.getM_registaUtilizador().addUtilizador(utilizador);
        empresa.getM_registaUtilizador().addUtilizador(utilizador2);
        evento.addOrganizador("DorisB", utilizador);

        listaString = new ArrayList<>();
        s1 = new String[4];
        s2 = new String[4];
        s1[0] = "Date";
        s1[1] = "Duration";
        s1[2] = "Organizer";
        s1[3] = "Email";
        s2[0] = "Sunday, June 12, 2016";
        s2[1] ="5";
        s2[2] = "Doris Brodeur";
        s2[3] ="cdio2013@mit.edu";
        listaString.add(s1);
        listaString.add(s2);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calculoDataFim method, of class LerFicheiroEventoCSV.
     */
    @Test
    public void testCalculoDataFim() throws Exception {
        System.out.println("calculoDataFim");
        int coluna = 1;
        int linha = 1;
        String expResult = "Friday, June 17, 2016";
        String result = instance.calculoDataFim(listaString, linha, coluna);
        assertEquals(expResult, result);
    }

    /**
     * Test of organizador method, of class LerFicheiroEventoCSV.
     */
    @Test
    public void testOrganizador() {
        System.out.println("organizador");
        int coluna = 1;
        int linha = 1;
        instance.organizador(listaString, linha, coluna, empresa);
        Utilizador expResult = utilizador;
        Utilizador result = empresa.getM_registoEventos().getEvento("EventoTitulo").getListaOrganizadores().get(0).getM_utilizador();
        assertEquals(expResult, result);
    }
}
