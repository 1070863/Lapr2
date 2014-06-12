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

    public void setDataLimiteSubmissão(String strDataLimiteSubmissão)
    {
        m_evento.setDataLimiteSubmissão(strDataLimiteSubmissão);
    }
    
    public void setDataLimiteRevisao(String strDataLimiteRevisao) {
        m_evento.setDataLimiteRevisao(strDataLimiteRevisao);
    }
        
    public void setDataLimiteRegisto(String strDataLimiteRegisto) {
        m_evento.setDataLimiteRegisto(strDataLimiteRegisto);
    }

    public void setNumeroMaximoTopicos(int nMaxTopicos) {
        m_evento.setnMaxTopicos(nMaxTopicos);
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
    
    /**
 * Valida o nome do evento
 * @param ID nome do evento que tem de ser unico
 * @return false se não existir, true se já existir um evento com este nome
 */
    public boolean validaEvento(String ID) {
        if (m_empresa.getM_registoEventos().getEvento(ID) == null) {
            return false;
        } else {
            return true;
        }
    }
}

