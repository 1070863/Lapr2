/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;


import tratarficheiros.LerFicheiroEventoXML;
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
public class LerFicheiroEventoXMLTest {
    
    private static Empresa empresa;
    private static RegistoUtilizador registoUtilizador;
    private static RegistoEventos registoEventos;
    private LerFicheiroEventoXML instance;
    
    
    public LerFicheiroEventoXMLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        empresa = new Empresa();
        empresa.getM_registaUtilizador().addUtilizador(empresa.getM_registaUtilizador().novoUtilizador());
        
        empresa.getM_registaUtilizador().setUtilizador("Ximena Vargas");
        empresa.getM_registaUtilizador().setUtilizadorEmail("xvargas@ing.uchile.cl");
        
        Evento evento = new Evento();
        evento.setTitulo("2013 Latin American Regional CDIO Meeting");
        evento.setLocal("Universidad de Chile");
        evento.setDataInicio("Monday, April 1, 2013");
        evento.setDataFim("Wednesday, April 3, 2013");
        
        
        //empresa.setM_registoEventos(new RegistoEventos(empresa));
        empresa.getM_registoEventos().registaEvento(evento);
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
     * Test of lerEventosXML method, of class LerFicheiroEventoXML.
     */
    /*@Test
    public void testLerEventosXML() throws Exception {
        System.out.println("lerEventosXML");
        String expResult = empresa.getM_registoEventos().getEvento("2013 Latin American Regional CDIO Meeting").getM_strDataInicio();      
        Empresa empresa2 = new Empresa();
        instance.LerFicheiro("EventList_teste.xml", empresa2);
        String resultado = empresa2.getM_registoEventos().getM_listaEventos().get(0).getM_strDataInicio();
        assertEquals(expResult, resultado);

    }*/
    
}
