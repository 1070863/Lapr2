package eventoscientificos;


import java.util.*;

/**
 *
 * @author Nuno Silva
 */

public class CP
{
    List<Revisor> m_listaRevisores;

    public CP()
    {
        m_listaRevisores = new ArrayList();
    }

    public Revisor addMembroCP( String strId, Utilizador u )
    {
        Revisor r = new Revisor(u);
        
        if( r.valida() && validaMembroCP(r) )
            return r;
        else
            return null;
    }
    
    private boolean validaMembroCP(Revisor r)
    {
        return true;
    }
    
    public boolean registaMembroCP(Revisor r)
    {
        return m_listaRevisores.add(r);
    }
    
    @Override
    public String toString()
    {
        String strCP = "Membros de CP: ";
        for( ListIterator<Revisor> it = m_listaRevisores.listIterator(); it.hasNext(); )
        {
            strCP += it.next().toString();
            if( it.hasNext() )
                strCP += ", ";
        }
        return strCP;
    }

    public List<Revisor> getListaRevisores() 
    {
        return this.m_listaRevisores;
    }
}