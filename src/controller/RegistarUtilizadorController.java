package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Utilizador;
import eventoscientificos.RegistoUtilizador;

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
        this.m_utilizador = m_empresa.getM_registaUtilizador().novoUtilizador();
    }

    public Utilizador setDados(String strNome, String strPassword, String strUsername, String strEmail)
    {
        novoUtilizador();
        System.out.println(strNome);
        System.out.println(strPassword);
        System.out.println(strUsername);
        System.out.println(strEmail);
        
        this.m_utilizador.setM_strNome(strNome);
        this.m_utilizador.setM_strPassword(strPassword);
        this.m_utilizador.setM_strUsername(strUsername);
        this.m_utilizador.setM_strEmail(strEmail);
        
        return m_utilizador;
    }
    public boolean ValidarUtilizador (Utilizador m_Utilizador)
    {
        
        if( (m_empresa.getM_registaUtilizador()).registaUtilizador(m_utilizador) )
        {
           return true;
           
        }    
        else
            return false;
       
    }

    public Utilizador getM_utilizador() {
        return m_utilizador;
    }

}