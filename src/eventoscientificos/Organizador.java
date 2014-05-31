/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;



/**
 *
 * @author Nuno Silva
 */

public class Organizador
{
    private final String m_strNome;
    private Utilizador m_utilizador;

    public Organizador(String strId, Utilizador u )
    {
        m_strNome = u.getNome();
        this.setUtilizador(u);
    }

    private void setUtilizador(Utilizador u)
    {
        m_utilizador = u;
    }
    
    public boolean valida()
    {
        return true;
    }
    
    public String getNome()
    {
        return m_strNome;
    }
    
    public Utilizador getUtilizador()
    {
        return m_utilizador;
    }

    @Override
    public String toString()
    {
        return m_utilizador.toString();
    }
}
