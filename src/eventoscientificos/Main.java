package eventoscientificos;

import ui.MenuUI;

/**
 * Classe main do projeto de LAPR2
 *
 * @author Grupo66 LAPR2
 */
public class Main {

    /**
     * Inicia o programa gerando uma janela do tipo JFrame com as opções
     * disponíveis no sistema.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        MenuUI uiMenu = new MenuUI(empresa);
    }
}