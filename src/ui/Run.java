package ui;


import eventoscientificos.Empresa;
import eventoscientificos.LerFicheiroEventoXML;
import eventoscientificos.Utilizador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Cria a janela principal da aplicação aonde estarão disponíveis todas as
 * funcionalidades.
 *
 * @author Grupo66 LAPR2
 */
public class Run extends JFrame {

    private static final int JANELA_POSICAO_X = 50;
    private static final int JANELA_POSICAO_Y = 50;
    
    private Empresa empresa;

    /**
     * Construtor por omissão cria uma janela com os menus Eventos e Ajuda.
     */
    public Run() {

        super("Gestão de Eventos Cíentificos");
        
        this.empresa = new Empresa();
        this.empresa.getM_registaUtilizador().novoUtilizador();
        Utilizador u1 = new Utilizador("pedro", "pedro", "pedro", "pedro@mail.pt");
        Utilizador u2 = new Utilizador("Super Mário", "mario", "mario", "sm@mail.pt");
        this.empresa.getM_registaUtilizador().addUtilizador(u1);
        this.empresa.getM_registaUtilizador().addUtilizador(u2);
        
      /*  LerFicheiroEventoXML lerEventos = new LerFicheiroEventoXML("EventList_CDIO.xml", 
                empresa);
        try {
            lerEventos.lerEventosXML();
        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(null,"Erro a ler o ficheiro xml!");
        } catch (SAXException ex) {
            JOptionPane.showMessageDialog(null,"Erro a ler o ficheiro xml!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Não fo possivel ler o ficheiro xml!");
        }*/

        JMenuBar menuBar = new JMenuBar();

        setJMenuBar(menuBar);

        menuBar.add(menuAdministrador());
        menuBar.add(menuOrganizador());
        menuBar.add(menuRevisor());
        menuBar.add(menuUtilizador());
        menuBar.add(menuAjuda());

        add(new JLabel(new ImageIcon("isep_logo.jpg")));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fechar();
            }
        });
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pack();
        setResizable(false);
        setLocation(JANELA_POSICAO_X, JANELA_POSICAO_Y);
        setVisible(true);
    }

    /**
     * Constrói uma janela da classe JOptionPane questionando sobre a pretensão
     * de fechar a aplicação e reage em função da resposta.
     */
    private void fechar() {
        String[] opSimNao = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this,
                "Deseja fechar a aplicação?",
                "Gestão de Eventos Cíentificos",
                0,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opSimNao,
                opSimNao[1]);

        final int SIM = 0;
        if (resposta == SIM) {
            dispose();
        }
    }
//MENU ADMINISTRADOR

    /**
     * Cria item do menu Administrador com a opção Criar Eventos
     *
     * @return item Criar Eventos para adicionar ao Menu
     */
    private JMenu menuAdministrador() {
        JMenu menu = new JMenu("Administrador");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.add(criarItemCriarEventos());

        return menu;
    }

    /**
     * Cria item do menu Administrador com a opção Criar Eventos
     *
     * @return item Criar Eventos para adicionar ao Menu
     */
    private JMenuItem criarItemCriarEventos() {
        JMenuItem item = new JMenuItem("Criar Eventos", KeyEvent.VK_C);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        }
        );
        return item;
    }
//MENU ORGANIZADOR

    /**
     * Cria o menu organizador que irá ser composto por 5 sub-menus.
     *
     * @return menu Organizador
     */
    private JMenu menuOrganizador() {
        JMenu menu = new JMenu("Organizador");
        menu.setMnemonic(KeyEvent.VK_O);

        menu.add(criarSubMenuDefinirTopicos());
        menu.add(criarSubMenuCriarCP());
        menu.add(criarSubMenuDistribRevs());
        menu.add(criarSubMenuDecidSArtigo());
        menu.add(criarSubMenuNotificaAutores());

        return menu;
    }

    /**
     * Cria item do menu Organizador com a opção Criar Tópicos.
     *
     * @return item Criar Tópicos para adicionar ao Menu
     */
    private JMenuItem criarSubMenuDefinirTopicos() {
        JMenuItem item = new JMenuItem("Criar Tópicos de Evento", KeyEvent.VK_1);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        );
        return item;
    }

    /**
     * Cria item do menu Organizador com a opção Criar CP(Comissão de Programa).
     *
     * @return item Criar CP para adicionar ao Menu
     */
    private JMenuItem criarSubMenuCriarCP() {
        JMenuItem item = new JMenuItem("Criar CP", KeyEvent.VK_2);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        );
        return item;
    }

    /**
     * Cria item do menu Organizador com a opção Distribuir Revisões.
     *
     * @return item Distribuir Revisões para adicionar ao Menu
     */
    private JMenuItem criarSubMenuDistribRevs() {
        JMenuItem item = new JMenuItem("Distribuir Revisões", KeyEvent.VK_3);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        );
        return item;
    }

    /**
     * Cria item do menu Organizador com a opção Decidir sobre Artigo.
     *
     * @return item Decidir Sobre Artigo para adicionar ao Menu
     */
    private JMenuItem criarSubMenuDecidSArtigo() {
        JMenuItem item = new JMenuItem("Decidir Sobre Artigo", KeyEvent.VK_4);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        );
        return item;
    }

    /**
     * Cria item do menu Organizador com a opção Notificar Autores.
     *
     * @return item Notificar Autores para adicionar ao Menu
     */
    private JMenuItem criarSubMenuNotificaAutores() {
        JMenuItem item = new JMenuItem("Notificar Autores", KeyEvent.VK_5);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        );
        return item;
    }
//MENU REVISOR

    /**
     * Cria o menu Revisor com a opção Submeter Revisão
     *
     * @return menu Revisor para adicionar ao Menu
     */
    private JMenu menuRevisor() {
        JMenu menu = new JMenu("Revisor");
        menu.setMnemonic(KeyEvent.VK_R);
        menu.add(criarItemSubmeterRevisão());

        return menu;
    }

    /**
     * Cria item do menu Revisor com a opção Submeter Revisão.
     *
     * @return item Submeter Revisão para adicionar ao Menu
     */
    private JMenuItem criarItemSubmeterRevisão() {
        JMenuItem item = new JMenuItem("Submeter Revisão", KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        );
        return item;
    }

    /**
     * Cria o menu Utilizador que irá ser composto por 2 sub-menus.
     *
     * @return menu Utilizador
     */
    private JMenu menuUtilizador() {
        JMenu menu = new JMenu("Utilizador");
        menu.setMnemonic(KeyEvent.VK_U);

        menu.add(criarSubMenuRegistaUtiliz());
        menu.add(criarSubMenuSubmeterArtigo());

        return menu;
    }

    /**
     * Cria item do menu Utilizador com a opção Registar Utilizador.
     *
     * @return item Registar Utilizador para adicionar ao Menu
     */
    private JMenuItem criarSubMenuRegistaUtiliz() {
        JMenuItem item = new JMenuItem("Registar Utilizador", KeyEvent.VK_R);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistarUtilizadorUI ru = new RegistarUtilizadorUI(new java.awt.Frame(),  
                        true, empresa);
                ru.run();
            }
        }
        );
        return item;
    }

    /**
     * Cria item do menu Utilizador com a opção Submeter Artigo.
     *
     * @return item Submeter Artigo para adicionar ao Menu
     */
    private JMenuItem criarSubMenuSubmeterArtigo() {
        JMenuItem item = new JMenuItem("Submeter Artigo", KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmeterArtigoUI submeterArtigo = new SubmeterArtigoUI(new java.awt.Frame(), 
                        true, empresa);
                submeterArtigo.run();
            }
        }
        );
        return item;
    }

    /**
     * Cria menu Ajuda com um sub menu.
     *
     * @return menu ajuda
     */
    private JMenu menuAjuda() {
        JMenu menu = new JMenu("Ajuda");
        menu.setMnemonic(KeyEvent.VK_A);

        menu.add(criarItemAcerca());

        return menu;
    }

    /**
     * Cria item do menu Ajuda com a opção Acerca.
     *
     * @return item Acerca para adicionar ao Menu
     */
    private JMenuItem criarItemAcerca() {
        JMenuItem item = new JMenuItem("Acerca", KeyEvent.VK_C);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Run.this,
                        "@Copyright\nLAPR2 2013/2014",
                        "Gestão de Eventos Científicos",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return item;
    }

}
