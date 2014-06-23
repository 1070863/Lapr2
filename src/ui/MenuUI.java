package ui;

import eventoscientificos.Empresa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.KeyStroke;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import tratarficheiros.Serializacao;

/**
 * Cria a janela principal da aplicação aonde estarão disponíveis todas as
 * funcionalidades.
 *
 * @author Grupo66 LAPR2
 */
public class MenuUI extends JFrame {

    private Empresa m_empresa;
    private static final int JANELA_POSICAO_X = 50;
    private static final int JANELA_POSICAO_Y = 50;

    /**
     * Construtor por omissão cria uma janela com os menus Eventos e Ajuda.
     */
    public MenuUI(Empresa empresa) {

        super("Gestão de Eventos Cíentificos");
        this.m_empresa = empresa;
        JMenuBar menuBar = new JMenuBar();

        setJMenuBar(menuBar);

        menuBar.add(menuAdministrador());
        menuBar.add(menuOrganizador());
        menuBar.add(menuRevisor());
        menuBar.add(menuAutor());
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
            Serializacao guardarFicheiro = new Serializacao(m_empresa);
            try {
                guardarFicheiro.escreverDadosFicheiro();
                dispose();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao guardar os dados!",
                        "Impossivel guardar os dados!", JOptionPane.ERROR_MESSAGE);
                dispose();

            }
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
        menu.add(criarItemCarregarEventos());
        menu.add(criarItemMigrarDados());
        
        return menu;
    }

    /**
     * Cria item do menu Administrador com a opção Criar Eventos
     *
     * @return item Criar Eventos para adicionar ao Menu
     */
    private JMenuItem criarItemCriarEventos() {
        JMenuItem item = new JMenuItem("Criar Eventos", KeyEvent.VK_1);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CriarEventoCientificoUI ce = new CriarEventoCientificoUI(new java.awt.Frame(), true, m_empresa);
                ce.run();
            }
        }
        );
        return item;
    }

    /**
     * Cria item do menu Administrador com a opção Carregar Eventos Automáticos.
     *
     * @return item Criar Eventos para adicionar ao Menu
     */
    private JMenuItem criarItemCarregarEventos() {
        JMenuItem item = new JMenuItem("Carregar Eventos", KeyEvent.VK_2);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarregarEventosUI carEv = new CarregarEventosUI(m_empresa);
                try {
                    carEv.run();
                } catch (ParserConfigurationException ex) {
                    //joption
                } catch (SAXException ex) {
                    //joption
                }
            }
        }
        );
        return item;
    }
    
    /**
     * Cria item do menu Administrador com a opção Migração de dados.
     * @return 
     */
    private JMenu criarItemMigrarDados() {
        JMenu item = new JMenu("Migração de dados");
        item.add(criarItemImportarEventos());
        item.add(criarItemImportarArtigos());
        item.add(criarItemImportarRevisoesArtigos());
        
        return item;
    }
    /**
     * Importar eventos
     * @return JMenuItem
     */
    private JMenuItem criarItemImportarEventos() {
        JMenuItem item = new JMenuItem("Importar Eventos", KeyEvent.VK_E);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImportacaoDadosUI ie = new ImportacaoDadosUI(m_empresa);
                try {
                    ie.run(1);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(MenuUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(MenuUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        return item;
    }
    /**
     * Importar artigos
     * @return JMenuItem
     */
    private JMenuItem criarItemImportarArtigos() {
        JMenuItem item = new JMenuItem("Importar Artigos", KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImportacaoDadosUI ia = new ImportacaoDadosUI(m_empresa);
                try {
                    ia.run(2);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(MenuUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(MenuUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        return item;
    }
    /**
     * Importar revisões de artigos
     * @return JMenuItem
     */
    private JMenuItem criarItemImportarRevisoesArtigos() {
        JMenuItem item = new JMenuItem("Importar Revisões Artigos", KeyEvent.VK_R);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImportacaoDadosUI ir = new ImportacaoDadosUI(m_empresa);
                try {
                    ir.run(3);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(MenuUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(MenuUI.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        menu.add(criarSubMenuDefinirValoresRegisto());
        menu.add(criarSubMenuCorrigirEventosImportados());
        menu.add(criarSubMenuExportarPagamentos());
        return menu;
    }

    /**
     * Cria item do menu Organizador com a opção Criar Tópicos.
     *
     * @return item Criar Tópicos para adicionar ao Menu
     */
    private JMenuItem criarSubMenuDefinirTopicos() {
        JMenuItem item = new JMenuItem("Definir Tópicos de Evento", KeyEvent.VK_1);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strId = JOptionPane.showInputDialog("Introduza o seu id:");
                if (strId.isEmpty()) {
                    dispose();
                }
                if (m_empresa.getM_registaUtilizador().getUtilizador(strId) == null) {
                    JOptionPane.showMessageDialog(null, "Não está Registado no sistema!!!", "Definir Tópicos de Artigo", ERROR_MESSAGE);
                } else if (m_empresa.getM_registoEventos().getEventosOrganizador(strId).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não é Organizador de Eventos!!!", "Definir Tópicos de Artigo", ERROR_MESSAGE);
                } else {
                    DefinirTopicosEventoUI defTEUI = new DefinirTopicosEventoUI(MenuUI.this, true, m_empresa, strId);
                }
            }
        }
        );
        return item;
    }

    /**
     * Cria item do menu Organizador com a opção Criar Tópicos.
     *
     * @return item Criar Tópicos para adicionar ao Menu
     */
    private JMenuItem criarSubMenuDefinirValoresRegisto() {
        JMenuItem item = new JMenuItem("Definir Valores de Registo", KeyEvent.VK_6);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strId = JOptionPane.showInputDialog("Introduza o seu id:");
                if (strId.isEmpty()) {
                    dispose();
                }
                if (m_empresa.getM_registaUtilizador().getUtilizador(strId) == null) {
                    JOptionPane.showMessageDialog(null, "Não está Registado no sistema!!!", "Definir Valores de Registo", ERROR_MESSAGE);
                } else if (m_empresa.getM_registoEventos().getEventosOrganizador(strId).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não é Organizador de Eventos!!!", "Definir Valores de Registo", ERROR_MESSAGE);
                } else {
                    DefinirValoresRegistoUI defVRUI = new DefinirValoresRegistoUI(MenuUI.this, true, m_empresa, strId);
                }
            }
        }
        );
        return item;
    }
    
    /**
     * Cria item do menu Organizador com a opçãoExportar Pagamentos de Registos.
     *
     * @return item Criar Tópicos para adicionar ao Menu
     */
    private JMenuItem criarSubMenuExportarPagamentos() {
        JMenuItem item = new JMenuItem("Exportar Pagamentos de Registos", KeyEvent.VK_8);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strId = JOptionPane.showInputDialog("Introduza o seu id:");
                if (strId.isEmpty()) {
                    dispose();
                }
                if (m_empresa.getM_registaUtilizador().getUtilizador(strId) == null) {
                    JOptionPane.showMessageDialog(null, "Não está Registado no sistema!!!", "Exportar Pagamentos de Registos", ERROR_MESSAGE);
                } else if (m_empresa.getM_registoEventos().getEventosOrganizador(strId).isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "Não é Organizador de Eventos!!!", "Exportar Pagamentos de Registos", ERROR_MESSAGE);
                } else {
//                    ExportarPagamentosRegisto expPRUI = new ExportarPagamentosRegisto(MenuUI.this, true, m_empresa, strId);
                }
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
                String strId = JOptionPane.showInputDialog("Introduza o seu id:");
                if (strId.isEmpty()) {
                    dispose();
                }
                if (m_empresa.getM_registaUtilizador().getUtilizador(strId) == null) {
                    JOptionPane.showMessageDialog(null, "Não está Registado no sistema!!!", "Criar Comissão de Programa", ERROR_MESSAGE);
                } else if (m_empresa.getM_registoEventos().getEventosOrganizador(strId).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não é Organizador de Eventos!!!", "Criar Comissão de Programa", ERROR_MESSAGE);
                } else {
                    CriarCPUI uiCCP = new CriarCPUI(MenuUI.this, true, m_empresa, strId);
                }
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
                DistribuirRevisoesUI dr = new DistribuirRevisoesUI(new java.awt.Frame(), true, m_empresa);
                dr.run();
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
                DecidirSobreArtigoUI dialog = new DecidirSobreArtigoUI(new javax.swing.JFrame(), true, m_empresa);
                dialog.run();
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
                NotificarAutoresUI dialog = new NotificarAutoresUI(new javax.swing.JFrame(), true, m_empresa);
                dialog.run();
            }
        }
        );
        return item;
    }
    
        /**
     * Cria item do menu Organizador com a opção corrigir eventos importados.
     *
     * @return item Notificar Autores para adicionar ao Menu
     */
    private JMenuItem criarSubMenuCorrigirEventosImportados() {
        JMenuItem item = new JMenuItem("Corrigir Eventos Importados", KeyEvent.VK_7);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CorrigirEventosImportadosUI cei = new CorrigirEventosImportadosUI(new javax.swing.JFrame(), true, m_empresa);
                cei.run();
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
                RevisaoArtigoUI ra = new RevisaoArtigoUI(new java.awt.Frame(), true, m_empresa);
                ra.run();
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
    private JMenu menuAutor() {
        JMenu menu = new JMenu("Autor");
        menu.setMnemonic(KeyEvent.VK_U);

        menu.add(criarSubMenuSubmeterArtigo());
        menu.add(criarSubMenuRegistoEvento());

        return menu;
    }

    /**
     * Cria item do menu Utilizador com a opção Registo no Evento.
     *
     * @return item Registo no Evento para adicionar ao Menu
     */
    private JMenuItem criarSubMenuRegistoEvento() {
        JMenuItem item = new JMenuItem("Registo no Evento", KeyEvent.VK_R);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strId = JOptionPane.showInputDialog("Introduza o seu id:");
                if (m_empresa.getM_registaUtilizador().getUtilizador(strId) == null) {
                    JOptionPane.showMessageDialog(null, "Não está Registado no sistema!!!", "Registo no Evento", ERROR_MESSAGE);
                } else if (m_empresa.getM_registoEventos().getEventosOrganizador(strId).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não está indicao como autor", "Registo no Evento", ERROR_MESSAGE);
                } else {
                    PagamentoRegistoUI pagRUI = new PagamentoRegistoUI(MenuUI.this, true, m_empresa, strId);
                }
            }
        }
        );
        return item;
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
                        true, m_empresa);
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
                SubmeterArtigoUI submeterArtigo = new SubmeterArtigoUI(new java.awt.Frame(), true, m_empresa);
                submeterArtigo.run();
            }
        }
        );
        return item;
    }

    /**
     * Cria o menu Utilizador não registado.
     *
     * @return menu Utilizador não registado
     */
    private JMenu menuUtilizador() {
        JMenu menu = new JMenu("Registo Utilizador");
        menu.setMnemonic(KeyEvent.VK_R);

        menu.add(criarSubMenuRegistaUtiliz());

        return menu;
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
                JOptionPane.showMessageDialog(MenuUI.this,
                        "@Copyright\nLAPR2 2013/2014\nGrupo 66",
                        "Gestão de Eventos Científicos",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return item;
    }

}
