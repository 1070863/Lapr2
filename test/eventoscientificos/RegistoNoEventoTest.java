/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Toshiba
 */
public class RegistoNoEventoTest {

    private Autor m_Autor;
    private Utilizador m_Utilizador;
    private RegistoNoEvento m_registo;
    private List<Submissao> m_listaSubmisoesAceites;
    private float valor;

    public RegistoNoEventoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.m_listaSubmisoesAceites = new ArrayList<>();
        this.m_registo = new RegistoNoEvento();
        this.m_Autor = new Autor();
        this.m_Autor.setM_Utilizador(m_Utilizador);
        this.m_Utilizador = new Utilizador("NomeTeste", "jmrs", "", "jm@qqq.com");
        this.m_registo.setM_autor(m_Autor);
        this.m_registo.setM_valor(3);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getM_autor method, of class RegistoNoEvento. Nota: Set e get
     * testado em simultâneo.
     */
    @Test
    public void testGetM_autor() {
        System.out.println("getM_autor");
        this.m_registo.setM_autor(this.m_Autor);
        Autor expResult = this.m_Autor;
        Autor result = this.m_registo.getM_autor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_listaSubmisoesAceites method, of class RegistoNoEvento.
     * Nota: Set e get testado em simultâneo.
     */
    @Test
    public void testGetM_listaSubmisoesAceites() {
        System.out.println("getM_listaSubmisoesAceites");
        this.m_registo.setM_listaSubmisoesAceites(this.m_listaSubmisoesAceites);
        List<Submissao> expResult = this.m_listaSubmisoesAceites;
        List<Submissao> result = this.m_registo.getM_listaSubmisoesAceites();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_valor method, of class RegistoNoEvento.
     */
    @Test
    public void testGetM_valor() {
        System.out.println("getM_valor");
        this.m_registo.setM_valor(3.6);
        double expResult = 3.6;
        double result = this.m_registo.getM_valor();
        assertEquals(expResult, result, 0.0);
    }

//    /**
//     * Test of pagamentoVisaoLight method, of class RegistoNoEvento.
//     * Nota: métodos externos de pagamento.
//     */
//    @Test
//    public void testPagamentoVisaoLight() {
//        System.out.println("pagamentoVisaoLight");
//        String strNumCC = "";
//        String dataValidadeCC = "";
//        float valorAutoriza = 0.0F;
//        String dataLimiteAutoriza = "";
//        RegistoNoEvento instance = new RegistoNoEvento();
//        instance.pagamentoVisaoLight(strNumCC, dataValidadeCC, valorAutoriza, dataLimiteAutoriza);
//    }
//
//    /**
//     * Test of pagamentoCanadaExpress method, of class RegistoNoEvento.
//     *Nota: métodos externos de pagamento.
//     */
//    @Test
//    public void testPagamentoCanadaExpress() {
//        System.out.println("pagamentoCanadaExpress");
//        Date dataValidade = null;
//        String strNumCC = "";
//        float fValorADCC = 0.0F;
//        Date dataLimite = null;
//        RegistoNoEvento instance = new RegistoNoEvento();
//        instance.pagamentoCanadaExpress(dataValidade, strNumCC, fValorADCC, dataLimite);
//    }
    /**
     * Test of toString method, of class RegistoNoEvento.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        this.m_registo.setM_listaSubmisoesAceites(this.m_listaSubmisoesAceites);
        this.m_registo.setM_autor(this.m_Autor);
        String expResult = "Autor: "+this.m_Autor.getM_strNome()+"\nSubmissões: "+"\nValor: " +this.m_registo.getM_valor();
        String result = this.m_registo.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class RegistoNoEvento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        RegistoNoEvento instance = this.m_registo;
        boolean expResult = true;
        boolean result = instance.equals(this.m_registo);
        assertEquals(expResult, result);
    }

}
