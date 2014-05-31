package eventoscientificos;

import utils.*;

/**
 *
 * @author Nuno Silva
 */

public class CriarEventoCientificoUI
{
    private Empresa m_empresa;
    private CriarEventoCientificoController m_controllerCEC;

    public CriarEventoCientificoUI( Empresa empresa )
    {
        m_empresa = empresa;
        m_controllerCEC = new CriarEventoCientificoController(m_empresa);
    }

    public void run()
    {
        novoEvento();

        introduzTitulo();
        introduzDescricao();
        introduzLocal();
        introduzDataInicio();
        introduzDataFim();
        introduzDataLimiteSubmissão();
        adicionaOrganizadores();
        
        apresentaEvento();
        
        if( confirmaCriacaoEvento() )
        {
            if( m_controllerCEC.registaEvento() )
                System.out.println("Evento registado.");
            else 
                System.out.println("Evento não registado.");
        }
    }

    private void novoEvento()
    {
        m_controllerCEC.novoEvento();
    }

    private void introduzTitulo()
    {
        String strTitulo = Utils.readLineFromConsole("Introduza Titulo: ");

        m_controllerCEC.setTitulo(strTitulo);
    }

    private void introduzDescricao()
    {
        String strDescricao = Utils.readLineFromConsole("Introduza Descrição: ");

        m_controllerCEC.setDescricao(strDescricao);
    }

    private void introduzLocal()
    {
        String strLocal = Utils.readLineFromConsole("Introduza Local: ");

        m_controllerCEC.setLocal(strLocal);
    }

    private void introduzDataInicio()
    {
        String strDataInicio = Utils.readLineFromConsole("Introduza Data de Início: ");

        m_controllerCEC.setDataInicio(strDataInicio);
    }

    private void introduzDataFim()
    {
        String strDataFim = Utils.readLineFromConsole("Introduza Data de Fim: ");

        m_controllerCEC.setDataFim(strDataFim);
    }

    private void introduzDataLimiteSubmissão()
    {
        String strDataLimiteSubmissão = Utils.readLineFromConsole("Introduza Data Limite de Submissão: ");

        m_controllerCEC.setDataLimiteSubmissão(strDataLimiteSubmissão);
    }

    private void adicionaOrganizadores()
    {
        String strResposta;
        do
        {
            String strId = Utils.readLineFromConsole("Introduza Id do Organizador: ");

            boolean bAdicionado = m_controllerCEC.addOrganizador(strId);

            if( bAdicionado )
                System.out.println("Organizador adicionado.");
            else
                System.out.println("Organizador não adicionado.");
            
            strResposta = Utils.readLineFromConsole("Introduzir outro organizador (S/N)? ");
        }
        while (strResposta.equalsIgnoreCase("S"));
    }
    
    private void apresentaEvento()
    {
        System.out.println("Evento: ");
     
        System.out.println( m_controllerCEC.getEventoString() );
    }
    
    private boolean confirmaCriacaoEvento()
    {
        String strConfirma;
        do
        {
            strConfirma = Utils.readLineFromConsole("Confirma criação de evento (S/N): ");
        }
        while ( !strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n") );

        if( strConfirma.equalsIgnoreCase("s") )
            return true;
        else
            return false;
    }
}