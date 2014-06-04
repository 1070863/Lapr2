package eventoscientificos;

import ui.MenuUI;
import ui.Run;

/**
 * Classe main do projeto de LAPR2
 *
 * @author Grupo66 LAPR2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new Run();
            Empresa empresa = new Empresa();

            MenuUI uiMenu = new MenuUI(empresa);

            uiMenu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
