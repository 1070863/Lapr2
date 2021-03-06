package ui;

import controller.RegistoNoEventoController;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import java.text.DecimalFormat;
import java.util.List;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Janela de interface gráfica para o Pagamento de um Registo num determinado
 * Evento.
 *
 * @author GRUPO66 LAPR2
 */
public class RegistoNoEventoUI extends JDialog {

    private Evento m_eventoSelecionado;
    private RegistoNoEventoController m_controllerRNE;
    private List<Evento> le;
    private static String strId;
    private static Empresa m_empresa;

    private static final int JANELA_POSICAO_X = 500;
    private static final int JANELA_POSICAO_Y = 100;
    DecimalFormat format = new DecimalFormat("0.00");
    private static final String[] formasOpcao = {"CanadaExpress", "VisaoLight"};
    private static final String[] dataMes = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio",
        "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    private static final String[] dataAno = {"2014", "2015", "2016", "2017", "2018", "2019", "2020"};
    private static final String[] dataMes31 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
        "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private static float valor;

    /**
     * Creates new form PagamentoRegistoUI
     */
    public RegistoNoEventoUI(javax.swing.JFrame pai, boolean modal, Empresa m_empresa, String strIda) {
        initComponents();
        strId = strIda;
        m_empresa = m_empresa;
        this.m_controllerRNE = new RegistoNoEventoController(this.m_empresa);
        this.le = this.m_controllerRNE.getEventosAutorSubAceites(strId);
        this.m_eventoSelecionado = apresentaEventosAutorSubAceites(this.le);
        this.m_controllerRNE.selectEvento(this.m_eventoSelecionado);
        preencheFormasPagamento();
        preencheValor();
        preencheData();

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

        jLabel1 = new javax.swing.JLabel();
        jtfNumFullPapers = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfNumShortPapers = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfNumPosterPapers = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfValorPagar1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcbMetodosPagamento = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfNumeroCartao = new javax.swing.JTextField();
        jtfValorPagar = new javax.swing.JTextField();
        btnPagar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jcbAno = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcbAnoLimite = new javax.swing.JComboBox();
        jcbMesLimite = new javax.swing.JComboBox();
        jcbMesValidade = new javax.swing.JComboBox();
        jcbdiaValidade = new javax.swing.JComboBox();
        jcbDiaLimite = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagamento do Registo");

        jLabel1.setText("Numero de Full PaPers:");

        jtfNumFullPapers.setEditable(false);
        jtfNumFullPapers.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("Numero de Short PaPers:");

        jtfNumShortPapers.setEditable(false);
        jtfNumShortPapers.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setText("Numero de Poster PaPers:");

        jtfNumPosterPapers.setEditable(false);
        jtfNumPosterPapers.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setText("Valor a pagar:");

        jtfValorPagar1.setEditable(false);
        jtfValorPagar1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Selecione o método de pagamento:");

        jLabel6.setText("Data Validade do cartão:");

        jLabel7.setText("Numero do cartão:");

        jLabel8.setText("Data Limite:");

        jLabel9.setText("Valor:");

        jtfNumeroCartao.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtfValorPagar.setEditable(false);
        jtfValorPagar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnPagar.setText("Efeturar Pagamento");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Dia");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Mês");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ano");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Dia");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Mês");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Ano");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(29, 29, 29)))
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbDiaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbMesLimite, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbAnoLimite, 0, 51, Short.MAX_VALUE)))
                            .addComponent(jtfValorPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jtfNumeroCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbdiaValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbMesValidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbAno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbMetodosPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfNumPosterPapers, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfValorPagar1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfNumFullPapers, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfNumShortPapers))))))
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNumFullPapers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNumShortPapers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfNumPosterPapers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfValorPagar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbMetodosPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMesValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbdiaValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfNumeroCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(4, 4, 4)
                                .addComponent(jcbAnoLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcbMesLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbDiaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(11, 11, 11)
                        .addComponent(jtfValorPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPagar)
                            .addComponent(btnCancelar))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel8)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel9))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Tratamento do evento gerado quando o botão cancelar é premido.
     *
     * @param evt premir o botão cancelar
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int confirma = JOptionPane.showConfirmDialog(this,
                "Cancelar o pagamento do Registo no Evento?", "Confirmar", ConfirmationCallback.YES_NO_OPTION);
        if (confirma == 0) {
            dispose();
            this.m_controllerRNE.termina();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    /**
     * Tratamento do evento gerado quando o botão Efetuar Pagamento é premido.
     *
     * @param evt premir o botão cancelar
     */
    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int confirma = JOptionPane.showConfirmDialog(this,
                "Confirma o pagamento?\nValor: " + jtfValorPagar + "\nCartão: " + jtfNumeroCartao, "Confirmar",
                ConfirmationCallback.YES_NO_OPTION);
        if (confirma == 0) {

            if (defineRegisto(jcbMetodosPagamento.getSelectedIndex(), jcbdiaValidade.getSelectedIndex(),
                    jcbMesValidade.getSelectedIndex(), jcbAno.getSelectedIndex(), jcbDiaLimite.getSelectedIndex(),
                    jcbMesLimite.getSelectedIndex(), jcbAnoLimite.getSelectedIndex(), valor, jtfNumeroCartao.getText())) {
                JOptionPane.showMessageDialog(null, "O seu Registo no evento foi efetuado com sucesso!.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "O seu Registo no evento não foi efetuado!!!",
                        "Pagamento do Registo",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnPagarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistoNoEventoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistoNoEventoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistoNoEventoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistoNoEventoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistoNoEventoUI dialog = new RegistoNoEventoUI(new javax.swing.JFrame(), true, m_empresa, strId);
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
    private javax.swing.JButton btnPagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox jcbAno;
    private javax.swing.JComboBox jcbAnoLimite;
    private javax.swing.JComboBox jcbDiaLimite;
    private javax.swing.JComboBox jcbMesLimite;
    private javax.swing.JComboBox jcbMesValidade;
    private javax.swing.JComboBox jcbMetodosPagamento;
    private javax.swing.JComboBox jcbdiaValidade;
    private javax.swing.JTextField jtfNumFullPapers;
    private javax.swing.JTextField jtfNumPosterPapers;
    private javax.swing.JTextField jtfNumShortPapers;
    private javax.swing.JTextField jtfNumeroCartao;
    private javax.swing.JTextField jtfValorPagar;
    private javax.swing.JTextField jtfValorPagar1;
    // End of variables declaration//GEN-END:variables

    /**
     * Carrega a informação das fórmulas numa combobox para apresentalção na
     * janela de interface gráfica.
     */
    private void preencheFormasPagamento() {
        for (int i = 0; i < formasOpcao.length; i++) {
            jcbMetodosPagamento.addItem(formasOpcao[i]);
        }
    }

    /**
     * Carrega a informação dos dias, meses e anos numa combobox para
     * apresentação na janela de interface gráfica.
     */
    private void preencheData() {
        for (int i = 0; i < dataAno.length; i++) {
            jcbAno.addItem(dataAno[i]);
            jcbAnoLimite.addItem(dataAno[i]);
        }
        for (int j = 0; j < dataMes.length; j++) {
            jcbMesLimite.addItem(dataMes[j]);
            jcbMesValidade.addItem(dataMes[j]);
        }
        for (int h = 0; h < dataMes31.length; h++) {
            jcbdiaValidade.addItem(dataMes31);
            jcbDiaLimite.addItem(dataMes31);
        }
    }

    /**
     * Apresenta a lista de eventos do Autor e permite selecionar o Evento para
     * o qual irá pagar os valores de Registo.
     *
     * @param le lista de eventos do Autor
     * @return Evento para o qual devem ser pagos os valores de registo
     */
    private Evento apresentaEventosAutorSubAceites(List<Evento> le) {
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
     * Calcula o valor a pagar e devolve-o à janela de interface gráfica.
     *
     * @return valor a pagar pelo registo
     */
    private double calculaValorPagamento(String id) {
        return this.m_controllerRNE.calculaValor(id);
    }

    /**
     * Preenche os campos do valor a pagar em função do valor calculado.
     */
    private void preencheValor() {
        valor = (float) calculaValorPagamento(strId);
        jtfValorPagar.setText(format.format(valor));
        jtfValorPagar1.setText(format.format(valor));
    }

    /**
     * Envia os dados itroduzidos pelo utilizador á controller.
     *
     * @param metodoPagamento método de pagamento externo
     * @param diaValidade dia da validade do cartão de crédito
     * @param mesValidade mês da validade do cartão de crédito
     * @param anoValidade ano da validade do cartão de crédito
     * @param diaLimite dia até ao qual os valores devem estar disponiveis
     * @param mesLimite mês até ao qual os valores devem estar disponiveis
     * @param anoLimite ano até ao qual os valores devem estar disponiveis
     * @param valor valor a ser autorizado
     * @param numeroCartao numero do cartão
     * @return verdadeiro ou falso em função do registo no evento
     */
    private boolean defineRegisto(int metodoPagamento, int diaValidade, int mesValidade, int anoValidade,
            int diaLimite, int mesLimite, int anoLimite, float valor, String numeroCartao) {
        try {
            int numeroCC = Integer.parseInt(numeroCartao);
            return this.m_controllerRNE.defineRegisto(formasOpcao[metodoPagamento], dataMes31[diaValidade], dataMes[mesValidade], dataAno[anoValidade],
                    dataMes31[diaLimite], dataMes[mesLimite], dataAno[anoLimite], valor, numeroCartao);
        } catch (NumberFormatException excecao) {
            JOptionPane.showMessageDialog(this,
                    "O numero do cartão de crédito deve ser um valor numérico.",
                    "Numero do Cartão de Crédito",
                    JOptionPane.WARNING_MESSAGE);
            jtfNumeroCartao.requestFocus();
        }
        return false;
    }

}
