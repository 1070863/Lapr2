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
        m_evento.getState().setCriado();
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
    
    public void setCidade(String strCidade) {
        m_evento.setCidade(strCidade);
    }

    public void setPais(String strPais) {
        m_evento.setPais(strPais);
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
        m_evento.setDataLimiteSubmissao(strDataLimiteSubmissão);
    }
    
    public void setDataLimiteRevisao(String strDataLimiteRevisao) {
        m_evento.setDataLimiteRevisao(strDataLimiteRevisao);
    }
        
    public void setDataLimiteRegisto(String strDataLimiteRegisto) {
        m_evento.setDataLimiteRegisto(strDataLimiteRegisto);
    }
    
    public void setDataLimiteSubmissaoFinal(String strDataLimiteSubmissaoFinal) {
        m_evento.setDataLimiteSubmissaoFinal(strDataLimiteSubmissaoFinal);
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
        m_evento.getState().setRegistado();
        return m_empresa.getM_registoEventos().registaEvento(m_evento);
    }
    
    /**
 * Valida o nome do evento
 * @param ID nome do evento que tem de ser unico
 * @return true se não existir, false se já existir um evento com este nome
 */
    public boolean validaEvento(String ID) {
        if (m_empresa.getM_registoEventos().getEvento(ID) == null) {
            return true;
        } else {
            return false;
        }
    }
}

