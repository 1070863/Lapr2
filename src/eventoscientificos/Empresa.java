package eventoscientificos;


import java.util.*;

/**
 *
 * @author Nuno Silva
 */

public class Empresa
{
    private RegistoEventos m_registoEventos;
    private RegistoUtilizador m_registoUtilizador;

    public Empresa()
    {
        m_registoUtilizador= new RegistoUtilizador();
        m_registoEventos = new RegistoEventos(this);

        //fillInData();
    }
    
    public RegistoEventos getM_registoEventos() {
        return m_registoEventos;
    }

    public void setM_registoEventos(RegistoEventos m_registoEventos) {
        this.m_registoEventos = m_registoEventos;
    }

    public RegistoUtilizador getM_registaUtilizador() {
        return m_registoUtilizador;
    }

    public void setM_registaUtilizador(RegistoUtilizador m_registaUtilizador) {
        this.m_registoUtilizador = m_registaUtilizador;
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
            this.m_registoUtilizador.addUtilizador(u);
            
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