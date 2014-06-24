/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import controller.ImportacaoDadosController;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Pedro
 */
public class ImportacaoDadosUI extends JFrame  {
    private Empresa m_empresa;
    private ImportacaoDadosController importacaoDadosController;
    
    /**
     * Opção
     * 1-Ler eventos
     * 2-Ler artigos
     * 3-Ler revisões artigos
     */
    private int opcao;
    
    public ImportacaoDadosUI(Empresa empresa) {
        super("Carregar Eventos Cientificos");
        this.m_empresa = empresa;
        importacaoDadosController = new ImportacaoDadosController();
    }

    public void run(int opcao) throws ParserConfigurationException, SAXException {
        ImportacaoDadosUI idUI = new ImportacaoDadosUI(m_empresa);

        this.opcao = opcao;
        try {
            boolean ficheiroValido = false;
            while (!ficheiroValido) {
                JFileChooser jfcCarregarEventos = new JFileChooser();
                definirFiltro(jfcCarregarEventos);
                int resp = jfcCarregarEventos.showOpenDialog(idUI);
                if (resp == JFileChooser.APPROVE_OPTION) {
                    File ficheiro = jfcCarregarEventos.getSelectedFile();
                    int validacaoFicheiro = importacaoDadosController.validaFicheiro(ficheiro.getName());

                    switch (validacaoFicheiro) {
                        case 0:
                            jfcCarregarEventos.setVisible(false);
                            ficheiroValido = true;
                            if(this.opcao==1)
                                importacaoDadosController.lerEventos(ficheiro.getAbsolutePath(), m_empresa);
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(idUI, "Tipo de ficheiro desconhecido!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(idUI, "Ficheiro sem eventos válidos!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                            break;
                    }

                } else {
                    ficheiroValido = true;
                }
            }
        } catch (IOException excecao) {
            JOptionPane.showMessageDialog(idUI, "Ficheiro inválido!", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void definirFiltro(JFileChooser jfcCarregarEventos) {
        jfcCarregarEventos.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {

                if (f.isDirectory()) {
                    return true;
                }
                String extensao = extensao(f);
                if (extensao != null) {
                    return (extensao.equals("csv"));

                }
                if (extensao != null) {
                    return (extensao.equals("csv"));

                }
                return false;
            }

            @Override

            public String getDescription() {
                return "*.csv";
            }

            public String extensao(File f) {
                String extensao = null;
                String s = f.getName();
                int i = s.lastIndexOf(".");
                if (i != -1) {
                    extensao = s.substring(i + 1).toLowerCase();
                }
                return extensao;
            }
        });
    }

    /*private void mostrarEventos() {
        List<Evento> listaEventosProvisoria = carregarEventosController.mostrarListaProvisoria();
        System.out.println("mostrarEventos: " + listaEventosProvisoria.size());
                
                
        int contador = 0;
        boolean flag = true;
        for (Evento evento : listaEventosProvisoria) {
            int resp = JOptionPane.showConfirmDialog(this, evento.toString(), "Confirmar dados do evento!", JOptionPane.YES_NO_CANCEL_OPTION);

            if (resp == JOptionPane.YES_OPTION) {
                carregarEventosController.setEvento(evento);
                contador++;
                JOptionPane.showMessageDialog(this, "Evento carregado com sucesso!");
            } else if (resp == JOptionPane.CANCEL_OPTION) {
                listaEventosProvisoria = new ArrayList<>();
                if (contador > 0) {
                    JOptionPane.showMessageDialog(this, contador + " eventos aceites carregados com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum evento carregado do ficheiro!");
                }
                flag = false;
                dispose();
                break;
            }
        }
        if (flag == true) {
            JOptionPane.showMessageDialog(this, "Todos os eventos lidos", "Carregar Eventos", JOptionPane.INFORMATION_MESSAGE);
        }
    */
}
