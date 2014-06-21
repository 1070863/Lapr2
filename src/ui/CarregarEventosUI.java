/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.CarregarEventosController;
import eventoscientificos.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Lopes
 */
public class CarregarEventosUI extends JFrame {

    private CarregarEventosController carregarEventosController;
    private Empresa m_empresa;

    public CarregarEventosUI(Empresa empresa) {
        super("Carregar Eventos Cientificos");
        this.m_empresa = empresa;
        carregarEventosController = new CarregarEventosController(m_empresa);
    }

    public void run() throws ParserConfigurationException, SAXException {
        CarregarEventosUI ceUI = new CarregarEventosUI(m_empresa);

        try {
            boolean ficheiroValido = false;
            while (!ficheiroValido) {
                JFileChooser jfcCarregarEventos = new JFileChooser();
                definirFiltro(jfcCarregarEventos);
                int resp = jfcCarregarEventos.showOpenDialog(ceUI);
                if (resp == JFileChooser.APPROVE_OPTION) {
                    File eventos = jfcCarregarEventos.getSelectedFile();
                    int ficheiro = carregarEventosController.setFicheiro(eventos.getName());

                    switch (ficheiro) {
                        case 0:
                            jfcCarregarEventos.setVisible(false);
                            ficheiroValido = true;
                            mostrarEventos();
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(ceUI, "Tipo de ficheiro desconhecido!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(ceUI, "Ficheiro sem eventos válidos!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                            break;
                    }

                } else {
                    ficheiroValido = true;
                }
            }
        } catch (IOException excecao) {
            JOptionPane.showMessageDialog(ceUI, "Ficheiro inválido!", "ERRO!", JOptionPane.ERROR_MESSAGE);
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
                    return (extensao.equals("csv") || extensao.equals("xml"));

                }
                if (extensao != null) {
                    return (extensao.equals("csv"));

                }
                if (extensao != null) {
                    return (extensao.equals("xml"));

                }
                return false;
            }

            @Override

            public String getDescription() {
                return "*.csv, *.xml";
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

    private void mostrarEventos() {
        List<Evento> listaEventosProvisoria = carregarEventosController.mostrarListaProvisoria();
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
    }
}
