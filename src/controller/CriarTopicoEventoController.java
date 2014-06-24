/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Topico;
import java.util.List;

/**
 *
 * @author iazevedo
 */

public class CriarTopicoEventoController {
    
    private Empresa m_empresa;
    private Evento m_evento;
    

    public CriarTopicoEventoController(Empresa empresa) 
    {
        m_empresa = empresa;
    }
    
    public List<Evento> getEventosOrganizador(String strId)
    {
        return m_empresa.getM_registoEventos().getEventosOrgRegistados(strId);
    }
    
   public void setEvento(Evento e)
   {
        m_evento = e;
   }
   public Topico addTopico(String strCodigo, String strDescricao)
   {
       Topico t = m_evento.novoTopico();
       
       t.setCodigoACM(strCodigo);
       t.setDescricao(strDescricao);
       
       
       if ( m_evento.validaTopico(t))
           return t;
       else
           return null;
   }
   
   public boolean registaTopico(Topico t)
   {
       return m_evento.addTopico(t);
   }
    
}

