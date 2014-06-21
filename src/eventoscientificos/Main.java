package eventoscientificos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        Evento e = new Evento("ev1", "afoisaf");
        Evento e2 = new Evento("ev2", "afoisaf");
        Evento e3 = new Evento("ev14", "afoisaf");

        Utilizador u = new Utilizador("SF", "u", "sfs", "hs@jdd.com");
        Utilizador u1 = new Utilizador("SF", "u1", "sfs", "hsf@jdd.com");
        Utilizador u2 = new Utilizador("SF", "u1", "sfs", "hsf@jdd.com");


        Topico t = new Topico("coisas ", "decoise«as");
        Topico t1 = new Topico("coisas1 ", "decoise«as");
        Topico t2 = new Topico("coisas2 ", "decoise«as");

        e.addTopico(t);
        e.addTopico(t1);
        e.addTopico(t2);
        e2.addTopico(t);
        
        e.addOrganizador("sfs", u);
        e2.addOrganizador("sfs", u);
        e3.addOrganizador("sfs", u);

        empresa.getM_registaUtilizador().registaUtilizador(u);
        empresa.getM_registaUtilizador().registaUtilizador(u1);

        empresa.getM_registoEventos().registaEvento(e);
        empresa.getM_registoEventos().registaEvento(e2);
        empresa.getM_registoEventos().registaEvento(e3);

        MenuUI uiMenu = new MenuUI(empresa);

    }
}
