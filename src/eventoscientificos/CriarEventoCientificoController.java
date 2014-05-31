package eventoscientificos;

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
        m_evento = m_empresa.novoEvento();
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

    public boolean addOrganizador(String strId)
    {
        Utilizador u = m_empresa.getUtilizador(strId);
        
        if( u!=null)
            return m_evento.addOrganizador( strId, u );
        else
            return false;
    }
    
    public boolean registaEvento()
    {
        return m_empresa.registaEvento(m_evento);
    }
}

