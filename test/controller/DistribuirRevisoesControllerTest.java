package controller;

import eventoscientificos.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import states.EventoCPDefinidaState;

/**
 * Classe de teste à classe DistribuirRevisoesController.
 *
 * @author GRUPO66 LAPR2
 */
public class DistribuirRevisoesControllerTest {

    private static Empresa empresa;
    private static DistribuirRevisoesController instance;
    private static Evento evento;
    private static List<Evento> listaEventos;
    private static Utilizador utilizador;
    private static ProcessoDistribuicao processoDistribuicao;
    private static List<MecanismoDistribuicao> listaMecanismoDistribuicoes;
    private static MecanismoDistribuicao mecanismoDistribuicao;
    private static Mecanismo1 mecanismo1;
    private static List<Distribuicao> listaDistribuicoes;
    private static Submissao submissao;
    private static Artigo artigo;


    public DistribuirRevisoesControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {

        empresa = new Empresa();
        evento = new Evento("titulo1", "descricao1");
        utilizador = new Utilizador("Utilizador1", "UN1", "123", "u1@isep.pt");
        empresa.getM_registaUtilizador().addUtilizador(utilizador);
        evento.addOrganizador("UN1", utilizador);
        empresa.getM_registoEventos().registaEvento(evento);
        listaMecanismoDistribuicoes = new ArrayList<>();
        mecanismo1 = new Mecanismo1();
        listaMecanismoDistribuicoes.add(mecanismo1);
        artigo = new Artigo();
        artigo.setTitulo("tituloartigo1");
        artigo.setResumo("resumoartigo1");
        submissao = new Submissao();
        submissao.setArtigo(artigo);
        evento.addSubmissao(submissao);  
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
     * Test of getM_evento e setM_evento method, of class
     * DistribuirRevisoesController.
     */
    @Test
    public void testGetM_evento() {
        System.out.println("getM_evento");
        instance = new DistribuirRevisoesController(empresa);
        instance.setEvento(evento);
        Evento expResult = evento;
        Evento result = instance.getM_evento();
        assertEquals(expResult, result);
    }

    /**
     * Test of novaDistribuicaoOrganizador method, of class
     * DistribuirRevisoesController.
     */
    @Test
    public void testNovaDistribuicaoOrganizador() {
        System.out.println("novaDistribuicaoOrganizador");
        instance = new DistribuirRevisoesController(empresa);
        String orgID = "UN1";
        List<Evento> expResult = new ArrayList<>();
        expResult.add(evento);
        evento.setState(new EventoCPDefinidaState(evento));
        List<Evento> result = instance.novaDistribuicaoOrganizador(orgID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProcessoDistribuicao method, of class
     * DistribuirRevisoesController.
     */
    @Test
    public void testGetProcessoDistribuicao() {
        System.out.println("getProcessoDistribuicao");
        instance = new DistribuirRevisoesController(empresa);
        processoDistribuicao = new ProcessoDistribuicao();
        evento.setProcessoDistribuicao(processoDistribuicao);
        instance.setEvento(evento);
        ProcessoDistribuicao expResult = processoDistribuicao;
        ProcessoDistribuicao result = instance.getProcessoDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMecanismoDistribuicao method, of class
     * DistribuirRevisoesController.
     */
    @Test
    public void testGetMecanismoDistribuicao() {
        System.out.println("getMecanismoDistribuicao");
        instance = new DistribuirRevisoesController(empresa);
        empresa.getM_registoEventos().setM_listaMecanismoDistribuicao(listaMecanismoDistribuicoes);
        List<MecanismoDistribuicao> expResult = listaMecanismoDistribuicoes;
        List<MecanismoDistribuicao> result = instance.getMecanismoDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Test of RegistaDistribuicao method, of class
     * DistribuirRevisoesController.
     */
    @Test
    public void testRegistaDistribuicao() {
        System.out.println("RegistaDistribuicao");
        instance = new DistribuirRevisoesController(empresa);
        processoDistribuicao = new ProcessoDistribuicao();
        evento.setProcessoDistribuicao(processoDistribuicao);
        instance.setEvento(evento);
        instance.RegistaDistribuicao();
        ProcessoDistribuicao expResult = processoDistribuicao;
        ProcessoDistribuicao result = instance.getProcessoDistribuicao();

    }

    /**
     * Test of getListaDistribuicoes method, of class
     * DistribuirRevisoesController.
     */
    @Test
    public void testGetListaDistribuicoes() {
        System.out.println("getListaDistribuicoes");
        instance = new DistribuirRevisoesController(empresa);
        instance.setListaDistribuicoes(listaDistribuicoes);
        List<Distribuicao> expResult = listaDistribuicoes;
        List<Distribuicao> result = instance.getListaDistribuicoes();
        assertEquals(expResult, result);

    }
}
