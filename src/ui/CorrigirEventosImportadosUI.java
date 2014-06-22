/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.CorrigirEventosImportadosController;
import eventoscientificos.*;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static utils.Data.String2Data;

/**
 *
 * @author Lopes
 */
public class CorrigirEventosImportadosUI extends javax.swing.JDialog {

    private static Empresa empresa;
    private CorrigirEventosImportadosController corrigirEventosImportadosController;

    private static final int JANELA_POSICAO_X = 200, JANELA_POSICAO_Y = 200;
    private int iEvento = -1;

    public CorrigirEventosImportadosUI(Empresa empresa) {
        this.empresa = empresa;

    }

    /**
     * Creates new form SubmissaoArtigoUI
     */
    public CorrigirEventosImportadosUI(java.awt.Frame parent, boolean modal, Empresa empresa) {
        super(parent, modal);
        initComponents();
        this.empresa = empresa;
        corrigirEventosImportadosController = new CorrigirEventosImportadosController(empresa);
        if (corrigirEventosImportadosController.getListaEventosCarregados().size() > 0) {
            for (Evento evento : corrigirEventosImportadosController.getListaEventosCarregados()) {
                cmbEvento.addItem(evento.getM_strTitulo());
            }
        }
    }

    /**
     * arranca janela
     */
    public void run() {

        pack();
        setResizable(false);
        setLocation(JANELA_POSICAO_X, JANELA_POSICAO_Y);
        setVisible(true);
        jPanelEscolherEvento.setVisible(true);
        jPanelDadosCorrigir.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEscolherEvento = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        cmbEvento = new javax.swing.JComboBox();
        jButtonOk = new javax.swing.JButton();
        jPanelDadosCorrigir = new javax.swing.JPanel();
        lblTitulo3 = new javax.swing.JLabel();
        jTextTitulo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        lblDescricao1 = new javax.swing.JLabel();
        jTextLocal = new javax.swing.JTextField();
        lblLocal = new javax.swing.JLabel();
        lblLocal1 = new javax.swing.JLabel();
        jTextCidade = new javax.swing.JTextField();
        lblLocal2 = new javax.swing.JLabel();
        jTextPais = new javax.swing.JTextField();
        jDateChooserInicio = new com.toedter.calendar.JDateChooser();
        lblDataInicio = new javax.swing.JLabel();
        lblDataFim = new javax.swing.JLabel();
        jDateChooserFim = new com.toedter.calendar.JDateChooser();
        jDateChooserLSubmissao = new com.toedter.calendar.JDateChooser();
        jDateChooserRevisao = new com.toedter.calendar.JDateChooser();
        lblDataLSubmissao1 = new javax.swing.JLabel();
        lblDataLimiteRevisao1 = new javax.swing.JLabel();
        lblDataLimiteRegisto2 = new javax.swing.JLabel();
        lblDataLimiteRegisto3 = new javax.swing.JLabel();
        jDateChooserSubmissaoFinal = new com.toedter.calendar.JDateChooser();
        jDateChooserRegisto = new com.toedter.calendar.JDateChooser();
        lblDataInicio1 = new javax.swing.JLabel();
        lblNumMaxTopicos = new javax.swing.JLabel();
        jTextnMaxTopicos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListOrganizadores = new javax.swing.JList();
        lbOrganizadores = new javax.swing.JLabel();
        jButtonAdicionarOrg = new javax.swing.JButton();
        jButtonContinuar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Corrigir Eventos Importados");

        lblTitulo1.setText("Evento a corrigir:");

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEscolherEventoLayout = new javax.swing.GroupLayout(jPanelEscolherEvento);
        jPanelEscolherEvento.setLayout(jPanelEscolherEventoLayout);
        jPanelEscolherEventoLayout.setHorizontalGroup(
            jPanelEscolherEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEscolherEventoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbEvento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOk)
                .addGap(21, 21, 21))
        );
        jPanelEscolherEventoLayout.setVerticalGroup(
            jPanelEscolherEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEscolherEventoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelEscolherEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo1)
                    .addComponent(cmbEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOk))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        lblTitulo3.setText("Título:");

        txtDescricao.setColumns(20);
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        lblDescricao1.setText("Descrição:");

        lblLocal.setText("Local:");

        lblLocal1.setText("Cidade:");

        lblLocal2.setText("País:");

        jDateChooserInicio.setDateFormatString("dd/MMM/yyyy");

        lblDataInicio.setText("Data Inicio:");

        lblDataFim.setText("Data Fim:");

        jDateChooserFim.setDateFormatString("dd/MMM/yyyy");

        jDateChooserLSubmissao.setDateFormatString("dd/MMM/yyyy");

        jDateChooserRevisao.setDateFormatString("dd/MMM/yyyy");

        lblDataLSubmissao1.setText("Data Limite de Submissão:");

        lblDataLimiteRevisao1.setText("Data Limite de Revisão:");

        lblDataLimiteRegisto2.setText("Data Limite de Submissão Final:");

        lblDataLimiteRegisto3.setText("Data Limite de Registo:");

        jDateChooserSubmissaoFinal.setDateFormatString("dd/MMM/yyyy");

        jDateChooserRegisto.setDateFormatString("dd/MMM/yyyy");

        lblDataInicio1.setText("Nota: Submissão < Revisão < Submissão Final < Registo < Inicio < Fim");

        lblNumMaxTopicos.setText("Número Máximo de Tópicos por Artigo:");

        jScrollPane1.setViewportView(jListOrganizadores);

        lbOrganizadores.setText("Organizadores do Evento:");

        jButtonAdicionarOrg.setText("Adicionar");
        jButtonAdicionarOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarOrgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDadosCorrigirLayout = new javax.swing.GroupLayout(jPanelDadosCorrigir);
        jPanelDadosCorrigir.setLayout(jPanelDadosCorrigirLayout);
        jPanelDadosCorrigirLayout.setHorizontalGroup(
            jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosCorrigirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosCorrigirLayout.createSequentialGroup()
                        .addComponent(lblLocal)
                        .addGap(2, 2, 2)
                        .addComponent(jTextLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLocal1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLocal2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextPais, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDataInicio1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosCorrigirLayout.createSequentialGroup()
                            .addComponent(lblNumMaxTopicos)
                            .addGap(8, 8, 8)
                            .addComponent(jTextnMaxTopicos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(115, 115, 115)))
                    .addGroup(jPanelDadosCorrigirLayout.createSequentialGroup()
                        .addComponent(lbOrganizadores)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosCorrigirLayout.createSequentialGroup()
                        .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosCorrigirLayout.createSequentialGroup()
                                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDataLSubmissao1)
                                    .addComponent(lblDataLimiteRevisao1))
                                .addGap(73, 73, 73)
                                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooserLSubmissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooserRevisao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosCorrigirLayout.createSequentialGroup()
                                .addComponent(lblTitulo3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosCorrigirLayout.createSequentialGroup()
                                .addComponent(lblDescricao1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosCorrigirLayout.createSequentialGroup()
                                .addComponent(lblDataLimiteRegisto2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooserSubmissaoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosCorrigirLayout.createSequentialGroup()
                                .addComponent(lblDataLimiteRegisto3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                .addComponent(jDateChooserRegisto, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosCorrigirLayout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAdicionarOrg))
                            .addGroup(jPanelDadosCorrigirLayout.createSequentialGroup()
                                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDataInicio)
                                    .addComponent(lblDataFim))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooserFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooserInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))))
                        .addGap(18, 18, 18))))
        );
        jPanelDadosCorrigirLayout.setVerticalGroup(
            jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosCorrigirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo3)
                    .addComponent(jTextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblLocal2))
                    .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblLocal1))
                    .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblLocal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDataInicio)
                    .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataFim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataLSubmissao1)
                    .addComponent(jDateChooserLSubmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataLimiteRevisao1)
                    .addComponent(jDateChooserRevisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataLimiteRegisto2)
                    .addComponent(jDateChooserSubmissaoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataLimiteRegisto3)
                    .addComponent(jDateChooserRegisto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDataInicio1)
                .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosCorrigirLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanelDadosCorrigirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumMaxTopicos)
                            .addComponent(jTextnMaxTopicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbOrganizadores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanelDadosCorrigirLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                        .addComponent(jButtonAdicionarOrg)))
                .addContainerGap())
        );

        jButtonContinuar.setText("Continuar");
        jButtonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContinuarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEscolherEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelDadosCorrigir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jButtonContinuar)
                .addGap(71, 71, 71)
                .addComponent(jButtonCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelEscolherEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDadosCorrigir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonContinuar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cancela e volta à janela anterior
     *
     * @param evt
     */
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * Se todos os dados estiverem correctos, pede para introduzir organizador e
     * se este for introduzido, declara sucesso. Uso da library jCalendar tirado
     * do seguinte site: http://toedter.com/software/
     *
     * @param evt
     */
    private void jButtonContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContinuarActionPerformed

        try { 
            if (!jTextTitulo.getText().isEmpty() && !txtDescricao.getText().isEmpty() && jTextnMaxTopicos.getText() != null) {
                if (corrigirEventosImportadosController.validaNomeEvento(jTextTitulo.getText())) {
                    Integer.parseInt(jTextnMaxTopicos.getText());
                    if (jDateChooserLSubmissao.getDate().before(jDateChooserRevisao.getDate())) {
                        if (jDateChooserRevisao.getDate().before(jDateChooserSubmissaoFinal.getDate())) {
                            if (jDateChooserSubmissaoFinal.getDate().before(jDateChooserRegisto.getDate())) {
                                if (jDateChooserRegisto.getDate().before(jDateChooserInicio.getDate())) {
                                    if (jDateChooserInicio.getDate().before(jDateChooserFim.getDate()) || jDateChooserInicio.getDate().equals(jDateChooserFim.getDate())) {

//                                        List<Utilizador> utilizadoresTemp = new ArrayList<Utilizador>();
//
//                                        String texto = "Titulo: " + jTextTitulo.getText();
//                                        texto += "\nDescrição: " + txtDescricao.getText();
//
//                                        texto += "\n";
//                                        int nOrganizadores = 0;
//                                        String idOrganizador = "";
//                                        while (nOrganizadores >= 0 && idOrganizador != null) {
//                                            idOrganizador = JOptionPane.showInputDialog(this, "ID Organizador de Evento:", "Adicionar Organizador", JOptionPane.QUESTION_MESSAGE);
//
//                                            if (idOrganizador != null) {
//                                                Utilizador u = empresa.getM_registaUtilizador().getUtilizador(idOrganizador);
//
//                                                if (u != null && !utilizadoresTemp.contains(u)) {
//                                                    utilizadoresTemp.add(u);
//                                                    texto += "\nUtilizador " + (nOrganizadores + 1) + ": " + u.getM_strNome();
//                                                    nOrganizadores++;
//                                                } else {
//                                                    JOptionPane.showMessageDialog(this, "Organizador não adicionado!", "Erro!", JOptionPane.ERROR_MESSAGE);
//                                                }
//                                                int resposta = JOptionPane.showConfirmDialog(this, "Quer adicionar mais Organizadores?", "Adicionar Organizador",
//                                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//
//                                                if (resposta == JOptionPane.NO_OPTION && nOrganizadores > 0) {
//                                                    nOrganizadores = -1;
//                                                } else if (resposta == JOptionPane.NO_OPTION && nOrganizadores == 0) {
//                                                    JOptionPane.showMessageDialog(this, "Não adicionou nenhum Organizador!", "Erro!", JOptionPane.ERROR_MESSAGE);
//                                                }
//
//                                            } else {
//                                                JOptionPane.showMessageDialog(this, "Não adicionou nenhum Organizador!", "Erro!", JOptionPane.ERROR_MESSAGE);
//
//                                            }
//                                        }
//                                        if (nOrganizadores == -1) {
//                                            int adicionarDados = JOptionPane.showConfirmDialog(this, texto, "Confirmação de dados.", JOptionPane.YES_NO_OPTION);
//
//                                            if (adicionarDados == JOptionPane.NO_OPTION) {
//                                                dispose();
//                                            } else {
                                                corrigirEventosImportadosController.setTitulo(jTextTitulo.getText());
                                                corrigirEventosImportadosController.setDescricao(txtDescricao.getText());
                                                corrigirEventosImportadosController.setLocal(jTextLocal.getText());
                                                corrigirEventosImportadosController.setCidade(jTextCidade.getText());
                                                corrigirEventosImportadosController.setPais(jTextPais.getText());
                                                System.out.println("setDataInicio: " + jDateChooserInicio.getDateFormatString());
                                                corrigirEventosImportadosController.setDataInicio(jDateChooserInicio.getDateFormatString());
                                                corrigirEventosImportadosController.setDataFim(jDateChooserFim.getDateFormatString());
                                                corrigirEventosImportadosController.setDataLimiteSubmissão(jDateChooserLSubmissao.getDateFormatString());
                                                corrigirEventosImportadosController.setDataLimiteRevisao(jDateChooserRevisao.getDateFormatString());
                                                corrigirEventosImportadosController.setDataLimiteRegisto(jDateChooserRegisto.getDateFormatString());
                                                corrigirEventosImportadosController.setDataLimiteSubmissaoFinal(jDateChooserSubmissaoFinal.getDateFormatString());

//                                                for (Utilizador uExistente : utilizadoresTemp) {
//                                                    criarEventoCController.addOrganizador(uExistente.getM_strUsername());
//                                                }
                                                corrigirEventosImportadosController.registaEvento();

                                                JOptionPane.showMessageDialog(this, "Evento registado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                                                dispose();
//                                            }
//                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Data de inicio tem de ser anterior ou igual à data de fim!", "Erro na data", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Data limite de registo tem de ser anterior à data de inicio!", "Erro na data", JOptionPane.INFORMATION_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Data limite de revisão tem de ser anterior à data limite submissão final!", "Erro na data", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Data limite submissão finalo tem de ser anterior à data limite de registo!", "Erro na data", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Data limite de submissão tem de ser anterior à data limite de revisão!", "Erro na data", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Erro! Evento já existe. Introduza novo nome", "Erro!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (jTextTitulo.getText().isEmpty() || txtDescricao.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Erro! Introduza dados em falta.", "Erro!", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "Erro! Numero inválido.", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException exception) {
            JOptionPane.showMessageDialog(this, "Erro! Data inválida.", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonContinuarActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        iEvento = cmbEvento.getSelectedIndex();
        if(iEvento != -1){
            //jPanelDadosCorrigir.setVisible(true);
            Evento eventoCorrigir = corrigirEventosImportadosController.getListaEventosCarregados().get(iEvento);
            corrigirEventosImportadosController.setStrTitulo_old(eventoCorrigir.getM_strTitulo());
            jTextTitulo.setText(eventoCorrigir.getM_strTitulo());
            txtDescricao.setText(eventoCorrigir.getM_strDescricao());
            jTextLocal.setText(eventoCorrigir.getM_local().getM_strLocal());
            jTextCidade.setText(eventoCorrigir.getM_local().getM_strCidade());
            jTextPais.setText(eventoCorrigir.getM_local().getM_strPais());
            
            try
            {
                Date dataInicio = String2Data(eventoCorrigir.getM_strDataInicio()).getTime();
                jDateChooserInicio.setDate(dataInicio);
                Date dataFim = String2Data(eventoCorrigir.getM_strDataFim()).getTime();
                jDateChooserFim.setDate(dataFim);
                Date dataLSubmissao = String2Data(eventoCorrigir.getDataLimiteSubmissao()).getTime();
                jDateChooserLSubmissao.setDate(dataLSubmissao);
                Date dataRevisao = String2Data(eventoCorrigir.getDataLimiteRevisao()).getTime();
                jDateChooserRevisao.setDate(dataRevisao);
                Date dataSubmissaoFinal = String2Data(eventoCorrigir.getDataLimiteSubmissaoFinal()).getTime();
                jDateChooserSubmissaoFinal.setDate(dataSubmissaoFinal);
                Date dataRegisto = String2Data(eventoCorrigir.getDataLimiteRegisto()).getTime();
                jDateChooserRegisto.setDate(dataRegisto);
            }
            catch(NullPointerException exception)
            {
                
            }
            
            jTextnMaxTopicos.setText(""+eventoCorrigir.getnMaxTopicos());

            System.out.println("Organizaodres: " + eventoCorrigir.getListaOrganizadores().size());
            jListOrganizadores.setModel(corrigirEventosImportadosController.listaDeOrganizadores(eventoCorrigir));
           // jListOrganizadores.add((Component) eventoCorrigir.getListaOrganizadores());
            
          
                    
        }else{
            JOptionPane.showMessageDialog(this, "Tem que seleccionar um evento primeiro");
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonAdicionarOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarOrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAdicionarOrgActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CorrigirEventosImportadosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CorrigirEventosImportadosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CorrigirEventosImportadosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CorrigirEventosImportadosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CorrigirEventosImportadosUI dialog = new CorrigirEventosImportadosUI(new javax.swing.JFrame(), true, empresa);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbEvento;
    private javax.swing.JButton jButtonAdicionarOrg;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonContinuar;
    private javax.swing.JButton jButtonOk;
    private com.toedter.calendar.JDateChooser jDateChooserFim;
    private com.toedter.calendar.JDateChooser jDateChooserInicio;
    private com.toedter.calendar.JDateChooser jDateChooserLSubmissao;
    private com.toedter.calendar.JDateChooser jDateChooserRegisto;
    private com.toedter.calendar.JDateChooser jDateChooserRevisao;
    private com.toedter.calendar.JDateChooser jDateChooserSubmissaoFinal;
    private javax.swing.JList jListOrganizadores;
    private javax.swing.JPanel jPanelDadosCorrigir;
    private javax.swing.JPanel jPanelEscolherEvento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextCidade;
    private javax.swing.JTextField jTextLocal;
    private javax.swing.JTextField jTextPais;
    private javax.swing.JTextField jTextTitulo;
    private javax.swing.JTextField jTextnMaxTopicos;
    private javax.swing.JLabel lbOrganizadores;
    private javax.swing.JLabel lblDataFim;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblDataInicio1;
    private javax.swing.JLabel lblDataLSubmissao1;
    private javax.swing.JLabel lblDataLimiteRegisto2;
    private javax.swing.JLabel lblDataLimiteRegisto3;
    private javax.swing.JLabel lblDataLimiteRevisao1;
    private javax.swing.JLabel lblDescricao1;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblLocal1;
    private javax.swing.JLabel lblLocal2;
    private javax.swing.JLabel lblNumMaxTopicos;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JTextArea txtDescricao;
    // End of variables declaration//GEN-END:variables

}