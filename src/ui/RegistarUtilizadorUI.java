package ui;


import controller.RegistarUtilizadorController;
import eventoscientificos.Empresa;
import eventoscientificos.Utilizador;
import utils.*;


/**
 *
 * @author Nuno Silva
 */

public class RegistarUtilizadorUI
{
    private Empresa m_empresa;
    private RegistarUtilizadorController m_controllerRU;

    public RegistarUtilizadorUI( Empresa empresa )
    {
        m_empresa = empresa;
        m_controllerRU = new RegistarUtilizadorController(m_empresa);
    }

    public void run()
    {
        novoUtilizador();

        Utilizador utilizador = introduzDadosUtilizador();

        apresentaUtilizador( utilizador );
    }

    private void novoUtilizador()
    {
        m_controllerRU.novoUtilizador();
    }

    private Utilizador introduzDadosUtilizador()
    {
        String strUsername = Utils.readLineFromConsole("Introduza Username: ");

        String strPassword = Utils.readLineFromConsole("Introduza Password: ");

        String strNome = Utils.readLineFromConsole("Introduza Nome: ");

        String strEmail = Utils.readLineFromConsole("Introduza Email: ");

        return m_controllerRU.setDados(strUsername, strPassword, strNome, strEmail);
    }

    private void apresentaUtilizador( Utilizador utilizador )
    {
        if(utilizador == null)
            System.out.println("Utilizador não registado.");
        else
            System.out.println(utilizador.toString() );
    }
}