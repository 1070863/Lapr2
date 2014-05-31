/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nuno Silva
 */
public class Revisor
{
    private String m_strNome;
    private Utilizador m_utilizador;

    // adicionada na iteração 1
    private List<Topico> m_listaTopicos = new ArrayList<Topico>();
    
    public Revisor(Utilizador u)
    {
        m_strNome = u.getNome();
        m_utilizador = u;
    }
    
    // adicionada na iteração 2
    public void setListaTopicos(List<Topico> listaTopicos)
    {
        m_listaTopicos.addAll( listaTopicos );
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
        String strRevisor = m_utilizador.toString() + ": ";
        
        String strTopicos = "";
        for( Topico t: m_listaTopicos )
        {
            strTopicos += t.toString();
        }
        
        strRevisor += strTopicos;

        return strRevisor;
    }
}
