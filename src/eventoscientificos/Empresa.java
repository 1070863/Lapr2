package eventoscientificos;


import java.util.*;

/**
 *
 * @author Nuno Silva
 */

public class Empresa
{
    private List<Utilizador> m_listaUtilizadores;
    private List<Evento> m_listaEventos;

    public Empresa()
    {
        m_listaUtilizadores = new ArrayList<Utilizador>();
        m_listaEventos = new ArrayList<Evento>();

        fillInData();
    }

    public Utilizador novoUtilizador()
    {
        return new Utilizador();
    }
    
    public boolean registaUtilizador(Utilizador u)
    {
        if( u.valida() && validaUtilizador(u) )
            return addUtilizador(u);
        else
            return false;
    }
    
    // alterada na iteração 2
    private boolean validaUtilizador(Utilizador u)
    {
        for(Utilizador uExistente : m_listaUtilizadores)
        {
            if( uExistente.mesmoQueUtilizador(u) )
                return false;
        }  
        return true;
    }
    
    public Evento novoEvento()
    {
        return new Evento();
    }

    public boolean registaEvento(Evento e)
    {
        if( e.valida() && validaEvento(e) )
            return addEvento(e);
        else
            return false;
    }
    
    private boolean validaEvento(Evento e)
    {
        return true;
    }

    public Utilizador getUtilizador(String strId)
    {
        for(Utilizador u:this.m_listaUtilizadores)
        {
            String s1 = u.getUsername();
            if(s1.equalsIgnoreCase(strId))
                return u;
        }  
        return null;
    }
    
    public Utilizador getUtilizadorEmail(String strEmail)
    {
        for(Utilizador u:this.m_listaUtilizadores)
        {
            String s1 = u.getEmail();
            if(s1.equalsIgnoreCase(strEmail))
                return u;
        }
    
        return null;
    }
    
    private boolean addUtilizador(Utilizador u)
    {
        return m_listaUtilizadores.add(u);
    }

    private boolean addEvento(Evento e)
    {
        return m_listaEventos.add(e);
    }
    
    public List<Evento> getEventosOrganizador(String strId)
    {
        List<Evento> leOrganizador = new ArrayList<Evento>();

        Utilizador u = getUtilizador(strId);
        
        if(u != null )
        {
            for( Iterator<Evento> it = m_listaEventos.listIterator(); it.hasNext(); )
            {
                Evento e = it.next();
                List<Organizador> lOrg = e.getListaOrganizadores();
             
                boolean bRet = false;
                for(Organizador org:lOrg)
                {
                    if (org.getUtilizador().equals(u))
                    {
                        bRet = true;
                        break;
                    }
                }
                if( bRet )
                    leOrganizador.add(e);
            }
        }
        return leOrganizador;
    }
    
    public List<Evento> getListaEventosPodeSubmeter()
    {
        List<Evento> le = new ArrayList<Evento>();
        
        for(Evento e:m_listaEventos)
        {
            if (e.aceitaSubmissoes())
            {
                le.add(e);
            }
        }
        
        return le;
    }

    private void fillInData() 
    {
        int max_users = 50;
        int max_organizadores = 5;
        int max_revisores = 25;
        int max_submissoes = 10;
        for(int users=0;users<max_users;users++)
        {
            String id = "user" + users;
            String ds = "Utilizador " + users; 
            
            Utilizador u = new Utilizador(id,"12345",ds,id +"@xxx.pt");
            this.m_listaUtilizadores.add(u);
            
            // System.out.println( u );
        }
        
        Evento e1 = new Evento("ESOFT Workshop", "Workshop sobre Engenharia de Software");
        this.m_listaEventos.add(e1);
        
        System.out.println( "Organizadores de evento1" );
        for(int organizadores=0;organizadores<max_organizadores;organizadores++)
        {
            Utilizador utl = this.m_listaUtilizadores.get(organizadores);
            e1.addOrganizador(utl.getUsername(),utl);
            
            System.out.println( utl.toString() );
        }
        CP cp = e1.novaCP();
        for(int revisores=0;revisores<max_revisores;revisores++)
        {
            Utilizador utl = this.m_listaUtilizadores.get(revisores);
            Revisor r = cp.addMembroCP(utl.getUsername(),utl);
            cp.registaMembroCP(r);
        }
        e1.setCP(cp);
        
        for(int submissoes=0;submissoes<max_submissoes;submissoes++)
        {
            Submissao sub = e1.novaSubmissao();
            Artigo art = sub.novoArtigo();
            
            art.setTitulo("Artigo " + submissoes);
            sub.setArtigo(art);
            e1.addSubmissao(sub);
        }
    }
}