package controller;


import eventoscientificos.CP;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Revisor;
import eventoscientificos.Topico;
import eventoscientificos.Utilizador;
import java.util.List;

/**
 *
 * @author Nuno Silva
 */

public class CriarCPController
{
    private Empresa m_empresa;
    private Evento m_evento;
    private CP m_cp;

    public CriarCPController(Empresa empresa)
    {
        m_empresa = empresa;
    }

    public List<Evento> getEventosOrganizador(String strId)
    {
        return m_empresa.getEventosOrganizador(strId);
    }
    
    public List<Topico> getTopicosEvento()
    {
        if( m_evento != null )
            return m_evento.getTopicos();
        else
            return null;
    }
    
    public void selectEvento(Evento e)
    {
        m_evento = e;
        
        m_cp = m_evento.novaCP();
    }
    
    public Revisor addMembroCP(String strId)
    {
        Utilizador u = m_empresa.getUtilizador(strId);
        
        if( u!=null)
            return m_cp.addMembroCP( strId, u );
        else
            return null;
    }
    
    public boolean registaMembroCP( Revisor r )
    {
        return m_cp.registaMembroCP(r);
    }
    
    public void setCP()
    {
        m_evento.setCP(m_cp); 
    }
    
    public void setListaTopicosRevisor(Revisor r, List<Topico> listaTopicosRevisor)
    {
        if( m_cp.getListaRevisores().contains(r) )
            r.setListaTopicos( listaTopicosRevisor );
    }
}

