package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Utilizador;

/**
 *
 * @author Nuno Silva
 */

public class CriarEventoCientificoController
{
    private Empresa m_empresa;
    private Evento m_evento;

    public CriarEventoCientificoController(Empresa empresa)
    {
        m_empresa = empresa;
    }

    public void novoEvento()
    {
        m_evento = m_empresa.getM_registoEventos().novoEvento();
    }

    public String getEventoString()
    {
        return m_evento.toString();
    }

    public void setTitulo(String strTitulo)
    {
        m_evento.setTitulo(strTitulo);
    }
    
    public void setDescricao(String strDescricao)
    {
        m_evento.setDescricao(strDescricao);
    }

    public void setLocal(String strLocal)
    {
        m_evento.setLocal(strLocal);
    }
    
    public void setDataInicio(String strDataInicio)
    {
        m_evento.setDataInicio(strDataInicio);
    }

    public void setDataFim(String strDataFim)
    {
        m_evento.setDataFim(strDataFim);
    }
    
    // adicionado na iteração 2
    public void setDataLimiteSubmissão(String strDataLimiteSubmissão)
    {
        m_evento.setDataLimiteSubmissão(strDataLimiteSubmissão);
    }
    
        public void setDataLimiteRevisao(String strDataLimiteRevisao) {
        m_evento.setDataLimiteRevisao(strDataLimiteRevisao);
    }

    public boolean addOrganizador(String strId)
    {
        Utilizador u = m_empresa.getM_registaUtilizador().getUtilizador(strId);
        
        if( u!=null)
            return m_evento.addOrganizador( strId, u );
        else
            return false;
    }
    
    public boolean registaEvento()
    {
        return m_empresa.getM_registoEventos().registaEvento(m_evento);
    }
}

