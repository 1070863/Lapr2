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
    
    /**
     * Construtor do Controller onde é passada a empresa por parametro
     * @param empresa 
     */
    public RegistarUtilizadorController(Empresa empresa)
    {
        m_empresa = empresa;
    }
/**
 * Chama o método novoUtilizador do RegistoUtilizador e cria um novo utilizador
 */
    public void novoUtilizador()
    {
        this.m_utilizador = m_empresa.getM_registaUtilizador().novoUtilizador();
    }
/**
 * chama novoUtilizador para criar um novo utilizador e preenche-o 
 * recorrendo aos sets da classe Utilizador
 * @param strNome
 * @param strPassword
 * @param strUsername
 * @param strEmail
 * @return Utilizador
 */
    public Utilizador setDados(String strNome, String strPassword, String strUsername, String strEmail)
    {
        novoUtilizador();
        
        this.m_utilizador.setM_strNome(strNome);
        this.m_utilizador.setM_strPassword(strPassword);
        this.m_utilizador.setM_strUsername(strUsername);
        this.m_utilizador.setM_strEmail(strEmail);
        
        return m_utilizador;
    }
    /**
     * Chama o metodo Regista Utilizador da classe RegistoUtilizador para 
     * adicionar o utilizador a lista existente caso seja bem sucedido 
     * devolve true
     * @param m_Utilizador
     * @return boolean
     */
    public boolean ValidarUtilizador (Utilizador m_Utilizador)
    {
        
        if( (m_empresa.getM_registaUtilizador()).registaUtilizador(m_utilizador) )
        {
           return true;
           
        }    
        else
            return false;
       
    }
/**
 * 
 * @return Utilizador
 */
    public Utilizador getM_utilizador() {
        return m_utilizador;
    }

}