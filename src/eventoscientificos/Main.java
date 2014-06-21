package eventoscientificos;

import java.io.IOException;
import javax.swing.JOptionPane;
import tratarficheiros.Serializacao;
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
        
        Serializacao lerFicheiro = new Serializacao(empresa);
        try {
            lerFicheiro.lerDadosFicheiro();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não existem dados para inicializar a aplicação!", "Carregar dados", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inicializar a aplicação:"+ex.getMessage(), 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        MenuUI uiMenu = new MenuUI(empresa);

    }
}
