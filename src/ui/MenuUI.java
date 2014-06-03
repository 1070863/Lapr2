package ui;


import eventoscientificos.Empresa;
import java.io.IOException;
import utils.*;

/**
 *
 * @author Nuno Silva
 */

public class MenuUI
{
    private Empresa m_empresa;
    private String opcao;

    public MenuUI(Empresa empresa)
    {
        m_empresa = empresa;
    }

    public void run() throws IOException
    {
        do
        {
            //opcao = "1";

            System.out.println("1. Registar utilizador");
            System.out.println("2. Criar Evento Científico");
            System.out.println("3. Criar Comissão de Programa");
            System.out.println("4. Submeter Artigo");
            System.out.println("9. Criar Tópicos de Evento");
            System.out.println("0. Sair");

            opcao = Utils.readLineFromConsole("Introduza opção: ");

            if( opcao.equals("1") )
            {
                RegistarUtilizadorUI uiRU = new RegistarUtilizadorUI(m_empresa);
                uiRU.run();
            }

            if( opcao.equals("2") )
            {
                CriarEventoCientificoUI uiCEC = new CriarEventoCientificoUI(m_empresa);
                uiCEC.run();
            }
            
            if( opcao.equals("3") )
            {
                CriarCPUI uiCCP = new CriarCPUI(m_empresa);
                uiCCP.run();
            }

            if( opcao.equals("4") )
            {
                SubmeterArtigoUI uiSA = new SubmeterArtigoUI(m_empresa);
                uiSA.run();
            }
            if ( opcao.equals("9") )
            {
                CriarTopicoEventoUI uiCTE = new CriarTopicoEventoUI(m_empresa);
                uiCTE.run();
            }
        }
        while (!opcao.equals("0") );
    }
}
