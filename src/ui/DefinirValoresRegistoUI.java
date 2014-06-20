package ui;

import excecoes.PrecoInvalidoException;
import controller.DefinirValoresRegistoController;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import java.util.List;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * Janela de interface gráfica para a definição de preço de registos no evento.
 *
 * @author GRUPO66 LAPR2
 */
public class DefinirValoresRegistoUI extends javax.swing.JDialog {

    private Evento m_eventoSelecionado;
    private DefinirValoresRegistoController m_controllerDFR;

    private static String strId;
    private static Empresa m_empresa;
    private static final String[] formulaOpcao = {"Fórmula 1", "Fórmula 2"};
    private static final int JANELA_POSICAO_X = 500;
    private static final int JANELA_POSICAO_Y = 100;
    private double fullPaper;
    private double shortPaper;
    private double posterPaper;

    /**
     * Construtor completo da janela de interface gráfica ao Sub Menu Definir
     * Valores de Registo.
     */
    public DefinirValoresRegistoUI(javax.swing.JFrame pai, boolean b, Empresa m_empresa, String strId) {
        initComponents();
        m_empresa = m_empresa;
        m_controllerDFR = new DefinirValoresRegistoController(m_empresa);
        List<Evento> le = this.m_controllerDFR.getEventosOrganizador(strId);
        m_eventoSelecionado = apresentaEventosOrganizador(le);
        m_controllerDFR.selectEvento(m_eventoSelecionado);
        preencheFormulas();

        pack();
        setResizable(false);
        setLocation(JANELA_POSICAO_X, JANELA_POSICAO_Y);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbLegenda1 = new javax.swing.JLabel();
        lblFP = new javax.swing.JLabel();
        lblSP = new javax.swing.JLabel();
        lblPP = new javax.swing.JLabel();
        jtfFullPaperPrice = new javax.swing.JTextField();
        jtfPosterPaperPrice = new javax.swing.JTextField();
        jtfShortPaperPrice = new javax.swing.JTextField();
        lbLegenda2 = new javax.swing.JLabel();
        btnDefinir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jcbFormulas = new javax.swing.JComboBox();
        lbLegenda4 = new javax.swing.JLabel();
        lbLegenda5 = new javax.swing.JLabel();
        lbLegenda6 = new javax.swing.JLabel();
        lbLegenda7 = new javax.swing.JLabel();
        lbLegenda8 = new javax.swing.JLabel();
        lbLegenda9 = new javax.swing.JLabel();
        lbLegenda3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaFormulas = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Definir Valores de Registo");

        lbLegenda1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbLegenda1.setText("Defina os valores dos Artigos");

        lblFP.setText("Preço Full Paper:");

        lblSP.setText("Preço Short Paper:");

        lblPP.setText("Preço Poster Paper:");

        lbLegenda2.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbLegenda2.setText("Defina a fórmula de cálculo a usar");

        btnDefinir.setText("Definir");
        btnDefinir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefinirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Formula a aplicar:");

        jcbFormulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFormulasActionPerformed(evt);
            }
        });

        lbLegenda4.setText("FPp-preço Full Paper");

        lbLegenda5.setText("SPp-preço Short Paper ");

        lbLegenda6.setText("PPp-preço Poster Paper ");

        lbLegenda7.setText("FPn-numero de Full Papers");

        lbLegenda8.setText("SPn-numero de Short Papers");

        lbLegenda9.setText("PPn-numero de Poster Papers ");

        lbLegenda3.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbLegenda3.setText("Legenda");

        jtaFormulas.setEditable(false);
        jtaFormulas.setColumns(20);
        jtaFormulas.setFont(new java.awt.Font("Times New Roman", 3, 13)); // NOI18N
        jtaFormulas.setRows(5);
        jScrollPane2.setViewportView(jtaFormulas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFP)
                                    .addComponent(lblSP)
                                    .addComponent(lblPP)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jcbFormulas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfPosterPaperPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jtfShortPaperPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jtfFullPaperPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLegenda1)
                            .addComponent(lbLegenda2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)))
                .addContainerGap(133, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDefinir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btnCancelar)
                .addGap(157, 157, 157))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbLegenda3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLegenda6)
                            .addComponent(lbLegenda5)
                            .addComponent(lbLegenda4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLegenda7)
                            .addComponent(lbLegenda8)
                            .addComponent(lbLegenda9))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLegenda1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFP)
                    .addComponent(jtfFullPaperPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSP)
                    .addComponent(jtfShortPaperPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPP)
                    .addComponent(jtfPosterPaperPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(lbLegenda2)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbFormulas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbLegenda3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLegenda4)
                    .addComponent(lbLegenda7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLegenda5)
                    .addComponent(lbLegenda8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLegenda6)
                    .addComponent(lbLegenda9))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDefinir)
                    .addComponent(btnCancelar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para tratar o evento gerado aqunado da mudança de itens na
     * combobox.
     *
     * @param evt mudança de itens selecionados na combobox
     */
    private void jcbFormulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFormulasActionPerformed
        if (jcbFormulas.getSelectedIndex() == 0) {
            jtaFormulas.setText("\n\nTotal = FPp * FPn + SPp * SPn + PPp * PPn");
        } else {
            jtaFormulas.setText("Se SPn > 0 e PPn > 0\n\n"
                    + "FPp * FPn + SPp * (SPn * FPn / 2) + PPp * (PPn * FPn / 2)\n\n"
                    + "Se SPn = 0 e PPn > 0\n\n"
                    + "FPp * FPn + PPp * (PPn * FPn / 2)\n\n"
                    + "Se SPn > 0 e PPn = 0\n\n"
                    + "FPp * FPn + SPp * (SPn * FPn / 2)");
        }
    }//GEN-LAST:event_jcbFormulasActionPerformed

    /**
     * Método de tratamento do evento despoletado pelo botão Definir,
     * verificando a validade dos dados e soliciatando uma confirmação dos dados
     * que devem ser definidos.
     *
     * @param evt clicar no botão definir
     */
    private void btnDefinirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefinirActionPerformed
        if (validaCampos()) {
            int confirma = JOptionPane.showConfirmDialog(this,
                    "\nDefinir os seguintes valores de registo?"
                    + "\n Preço Full Paper: " + jtfFullPaperPrice.getText()
                    + "\n Preço Short Paper:  " + jtfShortPaperPrice.getText()
                    + "\n Preço Poster Paper: " + jtfPosterPaperPrice.getText()
                    + "\n Fórmula de Cálculo: " + jcbFormulas.getSelectedItem(),
                    "Confirmar Valores de Registo", ConfirmationCallback.YES_NO_OPTION);
            if (confirma == 0) {
                setValores();
                if (this.m_controllerDFR.termina()) {
                    JOptionPane.showMessageDialog(this, "Os valores de registo foram definidos com sucesso.");
                    dispose();
                    System.out.println(this.m_eventoSelecionado.getM_registoNoEvento().toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Os não foram definidos.",
                            "Definir Valores de Registo", ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnDefinirActionPerformed
    /**
     * Método de tratamento do evento despoletado pelo botão Cancelar,
     * soliciatando uma confirmação do cancelamento e tratando a confirmação.
     *
     * @param evt clicar no botão cancelar
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int confirma = JOptionPane.showConfirmDialog(this,
                "Terminar a definição dos valores de registo?", "Confirmar", ConfirmationCallback.YES_NO_OPTION);
        if (confirma == 0) {
            dispose();
            this.m_controllerDFR.termina();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(DefinirValoresRegistoUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefinirValoresRegistoUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefinirValoresRegistoUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefinirValoresRegistoUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DefinirValoresRegistoUI dialog = new DefinirValoresRegistoUI(new javax.swing.JFrame(), true, m_empresa, strId);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDefinir;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcbFormulas;
    private javax.swing.JTextArea jtaFormulas;
    private javax.swing.JTextField jtfFullPaperPrice;
    private javax.swing.JTextField jtfPosterPaperPrice;
    private javax.swing.JTextField jtfShortPaperPrice;
    private javax.swing.JLabel lbLegenda1;
    private javax.swing.JLabel lbLegenda2;
    private javax.swing.JLabel lbLegenda3;
    private javax.swing.JLabel lbLegenda4;
    private javax.swing.JLabel lbLegenda5;
    private javax.swing.JLabel lbLegenda6;
    private javax.swing.JLabel lbLegenda7;
    private javax.swing.JLabel lbLegenda8;
    private javax.swing.JLabel lbLegenda9;
    private javax.swing.JLabel lblFP;
    private javax.swing.JLabel lblPP;
    private javax.swing.JLabel lblSP;
    // End of variables declaration//GEN-END:variables

    /**
     * Carrega a informação das fórmulas numa combobox para apresentalção na
     * janela de interface gráfica.
     */
    private void preencheFormulas() {
        for (int i = 0; i < formulaOpcao.length; i++) {
            jcbFormulas.addItem(formulaOpcao[i]);
        }
    }

    /**
     * Apresenta a lista de eventos do Organizador e permite selecionar o Evento
     * para o qual irá criar definir os valores de Registo.
     *
     * @param le lista de eventos do Organizador
     * @return Evento para o qual devem ser definidos os valores de registo
     */
    private Evento apresentaEventosOrganizador(List<Evento> le) {
        String[] lstEventos = new String[le.size()];
        for (int i = 0; i < lstEventos.length; i++) {
            lstEventos[i] = le.get(i).getM_strTitulo();
        }
        String eventoSelected = (String) JOptionPane.showInputDialog(this,
                "Selecione o Evento",
                "Selecionar Evento",
                JOptionPane.QUESTION_MESSAGE,
                null,
                lstEventos,
                lstEventos[0]);

        Evento e = null;
        for (int i = 0; i < le.size(); i++) {
            if (le.get(i).getM_strTitulo().equalsIgnoreCase(eventoSelected)) {
                e = le.get(i);
            }
        }
        return e;
    }

    /**
     * Valida a informação dos campos de texto da interface gráfica bem como os
     * seus valores.
     *
     * @return verdadeiro ou falso em função da validação dos campos.
     */
    private boolean validaCampos() {
        if (jtfFullPaperPrice.getText().isEmpty()
                || jtfShortPaperPrice.getText().isEmpty()
                || jtfPosterPaperPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Os campos devem estar todos preenchidos.\n ",
                    "Definir Valores de Registo", ERROR_MESSAGE);
            return false;
        }
        return validaValores();
    }

    /**
     * Valida os valores numéricos dos campos de texto da UI.
     *
     * @return verdadeiro ou falso em função da validação dos campos.
     */
    private boolean validaValores() {
        try {
            fullPaper = Double.parseDouble(jtfFullPaperPrice.getText());
            shortPaper = Double.parseDouble(jtfShortPaperPrice.getText());
            posterPaper = Double.parseDouble(jtfPosterPaperPrice.getText());
            if (fullPaper < 0 || shortPaper < 0 || posterPaper < 0) {
                String mensagem = "Os preços não podem ser negativos!!!";
                throw new PrecoInvalidoException(mensagem);
            }
            return true;
        } catch (NumberFormatException excecao) {
            JOptionPane.showMessageDialog(this,
                    "Os preços devem ser valores numéricos.",
                    "Definir Valores de Registo",
                    JOptionPane.WARNING_MESSAGE);
        } catch (PrecoInvalidoException excecao) {
            JOptionPane.showMessageDialog(this,
                    "Os preços não devem ser valores negativos.",
                    "Definir Valores de Registo",
                    JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    /**
     * Encaminha os valores à classe Controller para serem atribuidos aos
     * Valores de Registo no Evento.
     */
    private void setValores() {
        this.m_controllerDFR.defineValorFP(fullPaper);
        this.m_controllerDFR.defineValorSP(shortPaper);
        this.m_controllerDFR.defineValorPP(posterPaper);
        int opcao = jcbFormulas.getSelectedIndex();
        switch (opcao) {
            case 0: {
                this.m_controllerDFR.defineFormula1();
                break;
            }
            case 1: {
                this.m_controllerDFR.defineFormula2();
                break;
            }
        }
    }
}
