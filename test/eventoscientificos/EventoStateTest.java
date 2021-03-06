/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import states.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class EventoStateTest {
    
    /**
     * Test of setLidoFicheiro method, of class EventoState.
     */
    @Test
    public void testCriadoFicheiro() {
        System.out.println("SetCriadoFicheiro");
        Evento e = new Evento();
        EventoState instance = new EventoCriadoFicheiroState(new Evento());
        boolean expResult = false;
        boolean result = instance.setLidoFicheiro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setLidoFicheiro method, of class EventoState.
     */
    @Test
    public void testSetLidoFicheiro() {
        System.out.println("SetLidoFicheiro");
        Evento e = new Evento();
        EventoState instance = new EventoLidoFicheiroState(new Evento());
        boolean expResult = false;
        boolean result = instance.setLidoFicheiro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    /**
     * Test of setCriado method, of class EventoState.
     */
    @Test
    public void testSetCriado() {
        System.out.println("SetCriado");
        Evento e = new Evento();
        EventoState instance = new EventoCriadoState(new Evento());
        boolean expResult = false;
        boolean result = instance.setCriado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setRegistado method, of class EventoState.
     */
    @Test
    public void testSetRegistado() {
        System.out.println("SetRegistado");
        Evento e = new Evento();
        EventoState instance = new EventoRegistadoState(e);
        boolean expResult = false;
        boolean result = instance.setRegistado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTopicosDefinidos method, of class EventoState.
     */
    @Test
    public void testSetTopicosDefinidos() {
        System.out.println("setTopicosDefinidos");
        EventoState instance = new EventoTopicosDefinidosState(new Evento());
        boolean expResult = false;
        boolean result = instance.setTopicosDefinidos();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCPDefinida method, of class EventoState.
     */
    @Test
    public void testSetCPDefinida() {
        System.out.println("setCPDefinida");
        EventoState instance = new EventoCPDefinidaState(new Evento());
        boolean expResult = false;
        boolean result = instance.setCPDefinida();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDistribuido method, of class EventoState.
     */
    @Test
    public void testSetDistribuido() {
        System.out.println("setDistribuido");
        EventoState instance = new EventoDistribuidoState(new Evento());
        boolean expResult = false;
        boolean result = instance.setDistribuido();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRevisto method, of class EventoState.
     */
    @Test
    public void testSetRevisto() {
        System.out.println("setRevisto");
        EventoState instance = new EventoRevistoState(new Evento());
        boolean expResult = false;
        boolean result = instance.setRevisto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDecidido method, of class EventoState.
     */
    @Test
    public void testSetDecidido() {
        System.out.println("setDecidido");
        EventoState instance = new EventoDecididoState(new Evento());
        boolean expResult = false;
        boolean result = instance.setDecidido();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNotificado method, of class EventoState.
     */
    @Test
    public void testSetNotificado() {
        System.out.println("setNotificado");
        EventoState instance = new EventoNotificadoState(new Evento());
        boolean expResult = false;
        boolean result = instance.setNotificado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCameraReady method, of class EventoState.
     */
    @Test
    public void testSetCameraReady() {
        System.out.println("setCameraReady");
        EventoState instance = new EventoCameraReadyState(new Evento());
        boolean expResult = false;
        boolean result = instance.setCameraReady();
        assertEquals(expResult, result);
    }

    /**
     * Test of valida method, of class EventoState.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        EventoState instance = new EventoStateImpl();
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);
    }

    public class EventoStateImpl implements EventoState {

        public boolean setCriadoFicheiro() {
            return false;
        }
        
        public boolean setLidoFicheiro() {
            return false;
        }
        
        public boolean setCriado() {
            return false;
        }

        public boolean setRegistado() {
            return false;
        }

        public boolean setTopicosDefinidos() {
            return false;
        }

        public boolean setCPDefinida() {
            return false;
        }

        public boolean setDistribuido() {
            return false;
        }

        public boolean setRevisto() {
            return false;
        }

        public boolean setDecidido() {
            return false;
        }

        public boolean setNotificado() {
            return false;
        }

        public boolean setCameraReady() {
            return false;
        }

        public boolean valida() {
            return false;
        }

        @Override
        public boolean setValorRegistoDefinido() {
           return false;
        }
    }
    
}
