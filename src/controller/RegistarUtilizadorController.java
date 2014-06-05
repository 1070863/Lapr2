package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Utilizador;


/**
 *
 * @author Nuno Silva
 */

public class RegistarUtilizadorController
{
    private Empresa m_empresa;
    private Utilizador m_utilizador;

    public RegistarUtilizadorController(Empresa empresa)
    {
        m_empresa = empresa;
    }

    public void novoUtilizador()
    {
        m_utilizador = m_empresa.getM_registaUtilizador().novoUtilizador();
    }

    public Utilizador setDados(String strUsername, String strPassword, String strNome, String strEmail)
    {
        m_utilizador.setUsername(strUsername);
        m_utilizador.setPassword(strPassword);
        m_utilizador.setNome(strNome);
        m_utilizador.setEmail(strEmail);
        
        if( (m_empresa.getM_registaUtilizador()).registaUtilizador(m_utilizador) )
            return m_utilizador;
        else
            return null;
    }
}

