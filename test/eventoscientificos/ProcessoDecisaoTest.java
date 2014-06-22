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
 * Esta é a classe de teste da classe ProcessoDecisao do package eventoscientificos
 */
public class ProcessoDecisaoTest {
    private static String aceite;
    private static List<Revisor> listaRevisor;
    private static Revisor revisor1, revisor2, revisor3;
    private static Artigo artigo;
    private static Topico topico1, topico2, topico3;
    private static MecanismoDecisao1 mecanismoDecisao1;
    private static ProcessoDecisao instance;
    private static RevisaoArtigo revisaoArtigo;
    private static List<RevisaoArtigo> listaRevisaoArtigo;
    private static List<Decisao> listaDecisao;
    private static Empresa empresa;
    private static Decisao m_decisao;
    
    
    public ProcessoDecisaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    /**
     * os objetos são todos instanciados antes de cada método
     */
    @Before
    public void setUp() {
        aceite="aceite";
        revisor1 = new Revisor();
        revisor2 = new Revisor();
        revisor3 = new Revisor();
        listaRevisor = new ArrayList<>();
        artigo = new Artigo();
        instance = new ProcessoDecisao();
        revisaoArtigo = new RevisaoArtigo();
        revisaoArtigo.setTextoJustificativo("apenas para testar");
        revisaoArtigo.setAdequacao("4");
        revisaoArtigo.setConfianca("3");
        revisaoArtigo.setOriginalidade("4");
        revisaoArtigo.setQualidade("3");
        revisaoArtigo.setM_artigo(artigo);
       // revisaoArtigo.setM_listaRevisores(listaRevisor);
        revisaoArtigo.setRecomendacao(true);
        listaRevisaoArtigo = new ArrayList<>();
        listaRevisaoArtigo.add(revisaoArtigo);
        m_decisao = new Decisao(aceite);
        listaDecisao=new ArrayList<Decisao>();
        listaDecisao.add(m_decisao);
 
        instance.setM_listaRevisao(listaRevisaoArtigo);
        instance.setM_decisao(m_decisao);
        instance.setM_listaDecisao(listaDecisao);
        instance.setMecanismoDecisao(1);
        instance.setMecanismoDecisao(mecanismoDecisao1);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Teste do método setMecanismoDecisao, da class ProcessoDecisao.
     * aproveitei que a instancia processoDecisão já está instãnciado e 
     * bastou fazer o sete e depois o get.
     */
    @Test
    public void testSetMecanismoDecisao_int() {
        System.out.println("setMecanismoDecisao");
        int m = 1;
        instance.setMecanismoDecisao(m);
        String result=instance.getMecanismoDecisao().toString();
        String expResult= new MecanismoDecisao1().toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Teste do método getM_listaDistribuicao, da class ProcessoDecisao.
     *  aproveitei que a instancia processoDecisão   listaDestribuição 
     * já estavam instãnciados e invoquei o get que tem de me devolver a listaDestribuicao 
     * e assim sendo basta compara-las
     * 
     */
    @Test
    public void testGetM_listaDistribuicao() {
        System.out.println("getM_listaRevisao");
        List<RevisaoArtigo> expResult = listaRevisaoArtigo;
        List<RevisaoArtigo> result = instance.getM_listaDistribuicao();
        assertEquals(expResult, result);

    }

    /**
     * Teste do método decide, da class ProcessoDecisao. visto que já tenho as 
     * instancias criadas optei por invocar o método decide para acrescentar uma 
     * decisão a uma lista de decisões, adicionar o teste passa
     */
    @Test
    public void testDecide() {
        System.out.println("decide");
        boolean result =  listaDecisao.add(mecanismoDecisao1.decide(instance));
        boolean expResult = true;
        
        assertEquals(expResult, result);
    }

    /**
     * Teste do método novaDecisao, da class ProcessoDecisao.
     * basta criar uma nova decisao e recorrer ao get para ver se retorna
     * a mesma caso retorne o  teste passa
     */
    @Test
    public void testNovaDecisao() {
        System.out.println("novaDecisao");
        
        Decisao result = instance.novaDecisao();
        Decisao expResult = instance.getM_decisao();
        assertEquals(expResult, result);

    }

    /**
     * Teste do método getM_listaDecisao of class ProcessoDecisao.
     * aproveitei que listaDecisao já estava instânciada e  com recuro ao get
     * Compareias, caso o metodo get retorne o mesmo objeto o teste passa.
     */
    @Test
    public void testGetM_listaDecisao() {
        System.out.println("getM_listaDistribuicao");
        List<Decisao> expResult = listaDecisao;
        List<Decisao> result = instance.getM_listaDecisao();
        assertEquals(expResult, result);
    
    }


    /**
     * Teste do método getMecanismoDecisao, de class ProcessoDecisao.
     *criei um novo mecanismo e depois usando a instance (que é do tipo ProcessoDecisao)
     * fiz o set do mecanismo criado e depois o get caso o objeto devolvido seja igual o teste passa
     * 
     */
    @Test
    public void testGetMecanismoDecisao() {
        System.out.println("getMecanismoDecisao");
        MecanismoDecisao mec= new MecanismoDecisao1();
        instance.setMecanismoDecisao(mec);
        MecanismoDecisao expResult = mec;
        MecanismoDecisao result = instance.getMecanismoDecisao();
        assertEquals(expResult, result);

    }



    /**
     * Teste do método equals, da class ProcessoDecisao.
     * crio um objeto e compara-o com a instancia
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new ProcessoDecisao();
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
       
    }
    
}
