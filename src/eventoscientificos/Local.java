/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

/**
 *
 * @author Nuno Silva
 */

public class Local
{
    private String m_strLocal;

    public Local()
    {
    }
    
    public void setLocal(String strLocal)
    {
        m_strLocal = strLocal;
    }

    @Override
    public String toString()
    {
        return m_strLocal;
    }
}
