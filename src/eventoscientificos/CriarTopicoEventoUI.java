/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;


import java.util.List;
import utils.Utils;

/**
 *
 * @author iazevedo
 */
public class CriarTopicoEventoUI {

    private Empresa m_empresa;
    private CriarTopicoEventoController m_controllerCTE;
    

    public CriarTopicoEventoUI(Empresa empresa) 
    {
        m_empresa = empresa;
        m_controllerCTE = new CriarTopicoEventoController(m_empresa);

    }

    public void run() 
    {
        String strIdOrganizador = introduzIdOrganizador();
        List<Evento> le = m_controllerCTE.getEventosOrganizador(strIdOrganizador);
        apresentaEventosOrganizador(strIdOrganizador, le);
                 
        Evento e = selecionaEvento(le);
        
        if (e != null)
        {
            m_controllerCTE.setEvento(e);
        
            adicionaTopicos();        
              
            System.out.println("Terminado.");
        }
        else
            System.out.println("Criação de tópico de evento cancelada.");

    }

    private String introduzIdOrganizador()
    {
        return Utils.readLineFromConsole("Introduza Id Organizador: ");
    }
    
    private void apresentaEventosOrganizador(String strIdOrganizador, List<Evento> le)
    {
        System.out.println("Eventos do organizador " + strIdOrganizador + ":");
        
        int index = 0;
        for(Evento e : le)
        {
            index++;

            System.out.println(index + ". " + e.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancelar");
    }

    private Evento selecionaEvento(List<Evento> le)
    {
        String opcao;
        int nOpcao;
        do
        {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        }
        while (nOpcao < 0 || nOpcao > le.size());

        if( nOpcao == 0 )
            return null;
        else
            return le.get(nOpcao - 1);
    }

    private void adicionaTopicos()
    {
        String strResposta;
        
        strResposta = Utils.readLineFromConsole("Introduzir Topico (S/N)? ");
        
        while (strResposta.equalsIgnoreCase("S"))
        {
                       
            String strCodigo = Utils.readLineFromConsole("Introduza o código ACM do Tópico: ");
            String strDescricao = Utils.readLineFromConsole("Introduza a descrição do Tópico: ");
            
            
            Topico t = m_controllerCTE.addTopico(strCodigo,strDescricao);

            if( t == null )
                System.out.println("Tópico não criado.");
            else
            {
                System.out.println("Tópico: " + t.toString() );
                           
                if( confirmaTopico() )
                {
                    if( m_controllerCTE.registaTopico( t ) )
                        System.out.println("Tópico adicionado.");
                    else 
                        System.out.println("Tópico não adicionado.");
                }
            }
            
            strResposta = Utils.readLineFromConsole("Introduzir Topico (S/N)? ");
        }
        
    }
    
    private boolean confirmaTopico()
    {
        String strConfirma;
        do
        {
            strConfirma = Utils.readLineFromConsole("Confirma novo tópico (S/N): ");
        }
        while ( !strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n") );

        if( strConfirma.equalsIgnoreCase("s") )
            return true;
        else
            return false;
    }  
    
    

}
