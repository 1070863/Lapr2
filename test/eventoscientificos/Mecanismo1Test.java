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
public class Mecanismo1Test {

    private static List<Revisor> listaRevisor;
    private static Revisor revisor1, revisor2, revisor3;
    private static Artigo artigo;
    private static Topico topico1, topico2, topico3;
    private static Mecanismo1 instance;
    private static ProcessoDistribuicao processoDistribuicao;
    private static Distribuicao distribuicao;
    private static List<Distribuicao> listaDistribuicao;
    private static List<Submissao> listaSubmissoes;
    private static Submissao submissao;
    private static CP cp;
    private static Empresa empresa;
    private static List<Topico> listaTopicos1, listaTopicos2, listaTopicos3, listaTopicos4;

    public Mecanismo1Test() {

        topico1 = new Topico();
        topico1.setCodigoACM("1");
        topico1.setDescricao("teste1");
        topico2 = new Topico();
        topico2.setCodigoACM("2");
        topico2.setDescricao("teste2");
        topico3 = new Topico();
        topico3.setCodigoACM("3");
        topico3.setDescricao("teste3");
        revisor1 = new Revisor();
        listaTopicos1 = new ArrayList<>();
        listaTopicos1.add(topico1);
        revisor1.setM_listaTopicos(listaTopicos1);
        revisor2 = new Revisor();
        listaTopicos2 = new ArrayList<>();
        listaTopicos2.add(topico2);
        revisor2.setM_listaTopicos(listaTopicos2);
        revisor3 = new Revisor();
        listaTopicos3 = new ArrayList<>();
        listaTopicos3.add(topico3);
        revisor3.setM_listaTopicos(listaTopicos3);
        listaRevisor = new ArrayList<>();
        artigo = new Artigo();
        listaTopicos4 = new ArrayList<>();
        listaTopicos4.add(topico1);
        listaTopicos4.add(topico2);
        listaTopicos4.add(topico3);
        artigo.setListaTopicos(listaTopicos4);
        instance = new Mecanismo1();
        distribuicao = new Distribuicao();
        distribuicao.setM_artigo(artigo);
        distribuicao.setM_listaRevisores(listaRevisor);
        listaDistribuicao = new ArrayList<>();
        listaDistribuicao.add(distribuicao);
        listaSubmissoes = new ArrayList<>();
        submissao = new Submissao();
        cp = new CP();
        cp.getListaRevisores().add(revisor1);
        cp.getListaRevisores().add(revisor2);
        cp.getListaRevisores().add(revisor3);
        listaRevisor = cp.getListaRevisores();
        processoDistribuicao = new ProcessoDistribuicao();
        processoDistribuicao.setM_cp(cp);
        processoDistribuicao.setM_distribuicao(distribuicao);
        processoDistribuicao.setM_listaDistribuicao(listaDistribuicao);
        processoDistribuicao.setM_listaSubmissoes(listaSubmissoes);
        submissao.setArtigo(artigo);
        listaSubmissoes.add(submissao);

    }

    @BeforeClass
    public static void setUpClass() {
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
     * Test of getlRev & setlRev methods, of class Mecanismo1.
     */
    @Test
    public void testGetlRev() {
        System.out.println("getlRev");
        instance.setlRev(listaRevisor);
        List<Revisor> expResult = listaRevisor;
        List<Revisor> result = instance.getlRev();
        assertEquals(expResult, result);
    }

    /**
     * Test of getnAtribuicoes & setnAtribuicoes methods, of class Mecanismo1.
     */
    @Test
    public void testGetnAtribuicoes() {
        System.out.println("getnAtribuicoes");
        instance.setnAtribuicoes(3);
        int expResult = 3;
        int result = Mecanismo1.getnAtribuicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of distribui method, of class Mecanismo1.
     */
    @Test
    public void testDistribui() {
        System.out.println("distribui");
        int expResult = listaDistribuicao.size();
        int result = instance.distribui(processoDistribuicao).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNome method, of class Mecanismo1.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        String expResult = "Mecanismo1";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Mecanismo1.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Mecanismo1();
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

}
