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
public class ProcessoDistribuicaoTest {

    private static ProcessoDistribuicao instance;
    private static Submissao submissao;
    private static Artigo artigo;
    private static Utilizador u1, u2, u3, u4;
    private static Revisor r1, r2, r3, r4;
    private static Topico t1, t2;
    private static CP cp;

    private static Distribuicao distribuicao;
    private static List<Revisor> listaRevisores;
    private static List<Distribuicao> listaDistribuicoes;
    private static List<Submissao> ListaSubmissao;
    private static List<Topico> topicoArtigo;
    private static List<Topico> topicoAutorExtra;

    public ProcessoDistribuicaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
       instance = new ProcessoDistribuicao();
        distribuicao = new Distribuicao();
        listaRevisores = new ArrayList();
        listaDistribuicoes = new ArrayList();
        ListaSubmissao = new ArrayList();
        topicoArtigo = new ArrayList();
        topicoAutorExtra = new ArrayList();

        submissao = new Submissao();
        t1 = new Topico();
        t1.setCodigoACM("codigo1");
        t2 = new Topico();
        t2.setCodigoACM("codigo2");

        topicoArtigo.add(t1);
        topicoAutorExtra.add(t2);
        artigo = new Artigo();
        artigo.setListaTopicos(topicoArtigo);
        submissao.setArtigo(artigo);

        u1 = new Utilizador("Utilizador 1", "ut1", "111", "ut1@isep.pt");
        u2 = new Utilizador("Utilizador 2", "ut2", "222", "ut2@isep.pt");
        u3 = new Utilizador("Utilizador 3", "ut3", "333", "ut3@isep.pt");
        u4 = new Utilizador("Utilizador 4", "ut4", "444", "ut4@isep.pt");
        r1 = new Revisor(u1);
        r1.setM_listaTopicos(topicoArtigo);
        r2 = new Revisor(u2);
        r2.setM_listaTopicos(topicoArtigo);
        r3 = new Revisor(u3);
        r3.setM_listaTopicos(topicoAutorExtra);
        r4 = new Revisor(u4);
        r4.setM_listaTopicos(topicoArtigo);

        cp = new CP();
        cp.registaMembroCP(r1);
        cp.registaMembroCP(r2);
        cp.registaMembroCP(r3);
        cp.registaMembroCP(r4);

        listaRevisores.add(r1);
        listaRevisores.add(r4);
        distribuicao.setM_artigo(artigo);
        distribuicao.setM_listaRevisores(listaRevisores);
        listaDistribuicoes.add(distribuicao);

        ListaSubmissao.add(submissao);

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
     * Test of setMecanismoDistribuicao method, of class ProcessoDistribuicao.
     */
    @Test
    public void testSetMecanismoDistribuicao_int() {
        System.out.println("setMecanismoDistribuicao");
        int m = 1;
        instance.setMecanismoDistribuicao(m);
        String result = instance.getMecanismoDistribuicao().toString();
        String expResult = new Mecanismo1().toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of distribuicaoistribui method, of class
     * ProcessoDistribuicao.
     */
    @Test
    public void testDistribui() {
        System.out.println("distribui");
        instance.setM_cp(cp);
        instance.setMecanismoDistribuicao(1);
        instance.setM_listaSubmissoes(ListaSubmissao);

        int expResult = 3;
        List<Distribuicao> result = instance.distribui();
        assertEquals(expResult, result.get(0).getM_listaRevisores().size());
    }

    /**
     * Test of novaDistribuicao method, of class
     * ProcessoDistribuicao.
     */
    @Test
    public void testNovaDistribuicao() {
        System.out.println("novaDistribuicao");
        int expResult = 0;
        Distribuicao result = instance.novaDistribuicao();
        assertEquals(expResult, result.getM_listaRevisores().size());
    }

    /**
     * Test of getM_listaDistribuicao & setM_listaDistribuicao method, of class
     * ProcessoDistribuicao.
     */
    @Test
    public void testGetM_listaDistribuicao() {
        System.out.println("getM_listaDistribuicao");
        instance.setM_listaDistribuicao(listaDistribuicoes);
        List<Distribuicao> expResult = new ArrayList();
        expResult.add(distribuicao);
        List<Distribuicao> result = instance.getM_listaDistribuicao();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getM_listaSubmissoes methodistribuicao, of class
     * ProcessoDistribuicao.
     */
    @Test
    public void testGetM_listaSubmissoes() {
        System.out.println("getM_listaSubmissoes");
        instance.setM_listaSubmissoes(ListaSubmissao);
        List<Submissao> expResult = new ArrayList();
        expResult.add(submissao);

        List<Submissao> result = instance.getM_listaSubmissoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_distribuicaoistribuicao methodistribuicao, of class
     * ProcessoDistribuicao.
     */
    @Test
    public void testGetM_distribuicao() {
        System.out.println("getM_distribuicao");
        instance.setM_distribuicao(distribuicao);

        Distribuicao expResult = distribuicao;
        Distribuicao result = instance.getM_distribuicao();

        assertEquals(expResult, result);
    }

    /**
     * Test of getMecanismoDistribuicao methodistribuicao, of class
     * ProcessoDistribuicao.
     */
    @Test
    public void testGetMecanismoDistribuicao() {
        System.out.println("getMecanismoDistribuicao");
        MecanismoDistribuicao m = new Mecanismo1();
        instance.setMecanismoDistribuicao(m);
        MecanismoDistribuicao expResult = m;
        MecanismoDistribuicao result = instance.getMecanismoDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_cp methodistribuicao, of class ProcessoDistribuicao.
     */
    @Test
    public void testGetM_cp() {
        System.out.println("getM_cp");
        instance.setM_cp(cp);
        CP expResult = cp;
        CP result = instance.getM_cp();
        assertEquals(expResult, result);
    }   
    
    /**
     * Test of equals methodistribuicao, of class ProcessoDistribuicao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Mecanismo1();
        instance.setMecanismoDistribuicao(1);
        boolean expResult = true;
        boolean result = instance.getMecanismoDistribuicao().equals(obj);
        assertEquals(expResult, result);
    }
    
}
