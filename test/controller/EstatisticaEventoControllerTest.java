/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import eventoscientificos.Distribuicao;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.RevisaoArtigo;
import eventoscientificos.Submissao;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import states.EventoDecididoState;
import states.SubmissaoAceiteState;
import states.SubmissaoCriadaState;

/**
 *
 * @author Lopes
 */
public class EstatisticaEventoControllerTest {
    private EstatisticaEventoController instance;
    private List<Evento> listaEventos;
    private Evento evento;
    private Empresa empresa;
    private Submissao s, s1;
    public EstatisticaEventoControllerTest() {
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
        instance = new EstatisticaEventoController(empresa);
        evento = new Evento();
        evento.setTitulo("12th International CDIO Conference, Turku, Finland");
        evento.setState(new EventoDecididoState(evento));
        empresa.getM_registoEventos().registaEvento(evento);
        listaEventos = new ArrayList<>();
        listaEventos.add(evento);

        RevisaoArtigo ra = new RevisaoArtigo();
        RevisaoArtigo ra1 = new RevisaoArtigo();
        
        s = new Submissao();
        s.setRevisaoArtigo(ra);
        s.getRevisaoArtigo().setAdequacao("4");
        s.getRevisaoArtigo().setConfianca("1");
        s.getRevisaoArtigo().setOriginalidade("5");
        s.getRevisaoArtigo().setQualidade("3");
        s1 = new Submissao();
        s1.setRevisaoArtigo(ra1);
        s1.getRevisaoArtigo().setAdequacao("4");
        s1.getRevisaoArtigo().setConfianca("5");
        s1.getRevisaoArtigo().setOriginalidade("5");
        s1.getRevisaoArtigo().setQualidade("4");
        
        evento.getListaSubmissoes().add(s);
        evento.getListaSubmissoes().add(s1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getListaEventosDecididoNotificado method, of class EstatisticaEventoController.
     */
    @Test
    public void testGetListaEventosDecididoNotificado() {
        System.out.println("getListaEventosDecididoNotificado");
        List<Evento> expResult = listaEventos;
        List<Evento> result = instance.getListaEventosDecididoNotificado();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTaxaAceitacao method, of class EstatisticaEventoController.
     */
    @Test
    public void testGetTaxaAceitacao() {
        System.out.println("getTaxaAceitacao");

        s.setState(new SubmissaoAceiteState(s));
        s1.setState(new SubmissaoCriadaState(s1));
        
        evento.getListaSubmissoes().add(s);
        evento.getListaSubmissoes().add(s1);
        
        String expResult = "50,00 %";
        String result = instance.getTaxaAceitacao(evento);
        assertEquals(expResult, result);

    }

    /**
     * Test of getValorMedioAvaliacao - Parametro Confianca, of class EstatisticaEventoController.
     */
    @Test
    public void testGetValorMedioAvaliacaoConfianca() {
        System.out.println("getValorMedioAvaliacao - Confianca");

        String expResult = "3,00%";
        String result = instance.getValorMedioAvaliacao(evento, "Confianca");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getValorMedioAvaliacao - Parametro Confianca, of class EstatisticaEventoController.
     */
    @Test
    public void testGetValorMedioAvaliacaoAdequacao() {
        System.out.println("getValorMedioAvaliacao - Adequacao");

        String expResult = "4,00%";
        String result = instance.getValorMedioAvaliacao(evento, "Adequacao");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getValorMedioAvaliacao - Parametro Originalidade, of class EstatisticaEventoController.
     */
    @Test
    public void testGetValorMedioAvaliacaOriginalidade() {
        System.out.println("getValorMedioAvaliacao - Originalidade");

        String expResult = "5,00%";
        String result = instance.getValorMedioAvaliacao(evento, "Originalidade");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getValorMedioAvaliacao - Parametro Qualidade, of class EstatisticaEventoController.
     */
    @Test
    public void testGetValorMedioAvaliacaoQualidade() {
        System.out.println("getValorMedioAvaliacao - Qualidade");

        String expResult = "3,50%";
        String result = instance.getValorMedioAvaliacao(evento, "Qualidade");
        assertEquals(expResult, result);
    }
}
