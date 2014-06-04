package eventoscientificos;


import java.util.*;

/**
 *
 * @author Nuno Silva
 */

public class Empresa
{
    private List<Evento> m_listaEventos;
    private RegistaUtilizador m_registaUtilizador;

    public Empresa()
    {
        m_registaUtilizador= new RegistaUtilizador();
        m_listaEventos = new ArrayList<Evento>();

        //fillInData();
    }

    public Utilizador novoUtilizador()
    {
        return m_registaUtilizador.novoUtilizador();
    }
    
    public boolean registaUtilizador(Utilizador u)
    {
      return   m_registaUtilizador.registaUtilizador(u);
       
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

   
    private boolean addEvento(Evento e)
    {
        return m_listaEventos.add(e);
    }
    
    public List<Evento> getEventosOrganizador(String strId)
    {
        List<Evento> leOrganizador = new ArrayList<Evento>();

        Utilizador u = m_registaUtilizador.getUtilizador(strId);
        
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
/*
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
            this.m_registaUtilizador.addUtilizador(u);
            
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
    }*/
}