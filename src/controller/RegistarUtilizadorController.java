package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Utilizador;

/**
 *
 * @author Nuno Silva
 */
public class RegistarUtilizadorController {

    private Empresa m_empresa;
    private Utilizador m_utilizador;

    public RegistarUtilizadorController(Empresa empresa) {
        this.m_empresa = empresa;
    }

    public void novoUtilizador() {
        this.m_utilizador = m_empresa.getM_registaUtilizador().novoUtilizador();
    }

    public Utilizador setDados(String strUsername, String strPassword, String strNome, String strEmail) {
        this.m_utilizador.setM_strUsername(strUsername);
        this.m_utilizador.setM_strPassword(strPassword);
        this.m_utilizador.setM_strNome(strNome);
        this.m_utilizador.setM_strEmail(strEmail);

        if ((this.m_empresa.getM_registaUtilizador()).registaUtilizador(this.m_utilizador)) {
            return this.m_utilizador;
        } else {
            return null;
        }
    }
}
