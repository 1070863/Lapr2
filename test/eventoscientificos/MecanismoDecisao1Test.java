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
 * @author Pereira
 */
public class MecanismoDecisao1Test {
    private String aceite;
    private static List<Revisor> listaRevisor;
    private static Revisor revisor1, revisor2, revisor3;
    private static Artigo artigo;
    private static Topico topico1, topico2, topico3;
    private static MecanismoDecisao1 instance;
    private static ProcessoDecisao processoDecisao;
    private static RevisaoArtigo revisaoArtigo;
    private static List<RevisaoArtigo> listaRevisaoArtigo;
    private static List<Decisao> listaDecisao;
    private static Empresa empresa;
    private static Decisao m_decisao;
  
    public MecanismoDecisao1Test() {
     
    }
    
    @BeforeClass
    public static void setUpClass() {
    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        aceite="aceite";
        revisor1 = new Revisor();
        revisor2 = new Revisor();
        revisor3 = new Revisor();
        listaRevisor = new ArrayList<>();
        artigo = new Artigo();
        instance = new MecanismoDecisao1();
        revisaoArtigo = new RevisaoArtigo();
        revisaoArtigo.setTextoJustificativo("apenas para testar");
        revisaoArtigo.setAdequacao("4");
        revisaoArtigo.setConfianca("3");
        revisaoArtigo.setOriginalidade("4");
        revisaoArtigo.setQualidade("3");
        revisaoArtigo.setM_artigo(artigo);
        //revisaoArtigo.setM_listaRevisores(listaRevisor);
        revisaoArtigo.setRecomendacao(true);
        listaRevisaoArtigo = new ArrayList<>();
        listaRevisaoArtigo.add(revisaoArtigo);
        m_decisao = new Decisao(aceite);
        listaDecisao=new ArrayList<Decisao>();
        listaDecisao.add(m_decisao);
        processoDecisao= new ProcessoDecisao();
        processoDecisao.setM_listaRevisao(listaRevisaoArtigo);
        processoDecisao.setM_decisao(m_decisao);
        processoDecisao.setM_listaDecisao(listaDecisao);
        processoDecisao.setMecanismoDecisao(1);
        processoDecisao.setMecanismoDecisao(instance);


     
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Teste do método decide , da class MecanismoDecisao1, este método é 
     * reescrito da interface MecanismoDecisao.
     */
    @Test
    public void testDecide() {
        System.out.println("decide");
        ProcessoDecisao pd = processoDecisao;
        MecanismoDecisao1 instance = new MecanismoDecisao1();
        String result = instance.decide(pd).getDecisao();
        String expResult = m_decisao.getDecisao();
        assertEquals(expResult, result);

    }

    /**
     * Test do método getNome, da class MecanismoDecisao1 este método terá sempre o mesmo nome
     * peque basta testar se o get corresponde a esse nome.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        MecanismoDecisao1 instance = new MecanismoDecisao1();
        String expResult = "MecanismoDecisao1";
        String result = instance.getNome();
        assertEquals(expResult, result);
       
    }
    /**
     * Test do método equals, da class MecanismoDecisao1 optei por criar um objeto 
     * MecanismoDecisao1 e testar se é igual á variavel previamente instânciada no inico.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new MecanismoDecisao1();
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
