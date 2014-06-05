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
public class RegistoEventosTest {

    private Empresa empresa = new Empresa();
    private RegistoEventos re = new RegistoEventos(empresa);
    private Utilizador u = new Utilizador("username", "pwd", "nome", "email");
    private RegistoUtilizador ru = new RegistoUtilizador();
    private Evento e = new Evento("titulo1", "descricao1");

    @Before
    public void setUp() {
    }

    /**
     * Test of registaEvento method, of class RegistoEventos.
     */
    @Test
    public void testRegistaEvento() {

        System.out.println("registaEvento");

        boolean expResult = true;
        boolean result = re.registaEvento(new Evento("macaco", "Simio"));
        assertEquals(expResult, result);

    }

    /**
     * Test of getEventosOrganizador method, of class RegistoEventos.
     */
    @Test
    public void testGetEventosOrganizador() {

        ru.addUtilizador(u);
        empresa.setM_registaUtilizador(ru);
        empresa.setM_registoEventos(re);
        e.addOrganizador("username", u);
        re.registaEvento(e);
        System.out.println("getEventosOrganizador");
        String strId = "username";
        List<Evento> expResult = new ArrayList<>();
        expResult.add(e);
        List<Evento> result = empresa.getM_registoEventos().getEventosOrganizador(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaEventosPodeSubmeter method, of class RegistoEventos.
     */
    @Test
    public void testGetListaEventosPodeSubmeter() {
        re.registaEvento(e);
        System.out.println("getListaEventosPodeSubmeter");
        List<Evento> expResult = new ArrayList<>();
        expResult.add(e);
        List<Evento> result = re.getListaEventosPodeSubmeter();
        assertEquals(expResult, result);
    }

}

