package ui;

import controller.EstatisticaEventoController;
import eventoscientificos.*;

/**
 * Classe que serve de interface gráfica ao processo de apresenta de estatísticas de Evento
 *
 * @author GRUPO66 LAPR2
 */
public class EstatisticaEventoUI extends javax.swing.JFrame {
    
    private static Empresa m_empresa;
    private EstatisticaEventoController estatisticaEventoController;
    private static final int JANELA_POSICAO_X = 200, JANELA_POSICAO_Y = 200;
    private int iEvento = -1;
    
        public EstatisticaEventoUI(Empresa empresa) {
        this.m_empresa = empresa;

    }
    /**
     * Creates new form EstatisticaEventoUI
     */
    public EstatisticaEventoUI(java.awt.Frame parent, boolean modal, Empresa empresa) {
        super("Estisticas Eventos Cientificos");
        //super(parent, modal);
        initComponents();
        this.m_empresa = empresa;
        estatisticaEventoController = new EstatisticaEventoController(empresa);
        if (estatisticaEventoController.getListaEventosDecididoNotificado().size() > 0) {
            for (Evento evento : estatisticaEventoController.getListaEventosDecididoNotificado()) {
                jComboBoxEvento.addItem(evento.getM_strTitulo());
            }
        }
    }

    
         /**
     * Apresentação de janela
     */
    public void run() {
 
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

        jComboBoxEvento = new javax.swing.JComboBox();
        jLabelEvento = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();
        jLabelTaxaAceitacao = new javax.swing.JLabel();
        jLabelTaxaAceitacaoRes = new javax.swing.JLabel();
        jLabelTaxaConfiancaRes = new javax.swing.JLabel();
        jLabelValoresMedios = new javax.swing.JLabel();
        jLabelQualidade = new javax.swing.JLabel();
        jLabelOriginalidade = new javax.swing.JLabel();
        jLabelAdequacao = new javax.swing.JLabel();
        jLabelConfianca = new javax.swing.JLabel();
        jLabelConfiancaRes = new javax.swing.JLabel();
        jLabelAdequacaoRes = new javax.swing.JLabel();
        jLabelOriginalidadeRes = new javax.swing.JLabel();
        jLabelQualidadeRes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBoxEvento.setActionCommand("cmbEvento");

        jLabelEvento.setText("Evento:");

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jLabelTaxaAceitacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTaxaAceitacao.setText("Taxa de Aceitação:");

        jLabelValoresMedios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelValoresMedios.setText("Valores Médios:");

        jLabelQualidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelQualidade.setText("Qualidade");

        jLabelOriginalidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelOriginalidade.setText("Originalidade");

        jLabelAdequacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelAdequacao.setText("Adequação");

        jLabelConfianca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelConfianca.setText("Confiança");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelValoresMedios)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabelTaxaConfiancaRes))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEvento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOk))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelQualidade)
                            .addComponent(jLabelTaxaAceitacao)
                            .addComponent(jLabelOriginalidade)
                            .addComponent(jLabelAdequacao)
                            .addComponent(jLabelConfianca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelConfiancaRes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTaxaAceitacaoRes))
                            .addComponent(jLabelAdequacaoRes)
                            .addComponent(jLabelOriginalidadeRes)
                            .addComponent(jLabelQualidadeRes))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEvento)
                    .addComponent(jButtonOk))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTaxaAceitacao)
                    .addComponent(jLabelTaxaAceitacaoRes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTaxaConfiancaRes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelValoresMedios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelConfianca)
                    .addComponent(jLabelConfiancaRes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdequacao)
                    .addComponent(jLabelAdequacaoRes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOriginalidade)
                    .addComponent(jLabelOriginalidadeRes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQualidade)
                    .addComponent(jLabelQualidadeRes))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        iEvento = jComboBoxEvento.getSelectedIndex();
        if(iEvento != -1){
            Evento e = estatisticaEventoController.getListaEventosDecididoNotificado().get(iEvento);
            jLabelTaxaAceitacaoRes.setText(estatisticaEventoController.getTaxaAceitacao(e));
            jLabelConfiancaRes.setText(estatisticaEventoController.getValorMedioAvaliacao(e, "Confianca"));
            jLabelAdequacaoRes.setText(estatisticaEventoController.getValorMedioAvaliacao(e, "Adequacao"));
            jLabelOriginalidadeRes.setText(estatisticaEventoController.getValorMedioAvaliacao(e, "Originalidade"));
            jLabelQualidadeRes.setText(estatisticaEventoController.getValorMedioAvaliacao(e, "Qualidade"));
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

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
            java.util.logging.Logger.getLogger(EstatisticaEventoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstatisticaEventoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstatisticaEventoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstatisticaEventoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CriarEventoCientificoUI dialog = new CriarEventoCientificoUI(new javax.swing.JFrame(), true, m_empresa);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox jComboBoxEvento;
    private javax.swing.JLabel jLabelAdequacao;
    private javax.swing.JLabel jLabelAdequacaoRes;
    private javax.swing.JLabel jLabelConfianca;
    private javax.swing.JLabel jLabelConfiancaRes;
    private javax.swing.JLabel jLabelEvento;
    private javax.swing.JLabel jLabelOriginalidade;
    private javax.swing.JLabel jLabelOriginalidadeRes;
    private javax.swing.JLabel jLabelQualidade;
    private javax.swing.JLabel jLabelQualidadeRes;
    private javax.swing.JLabel jLabelTaxaAceitacao;
    private javax.swing.JLabel jLabelTaxaAceitacaoRes;
    private javax.swing.JLabel jLabelTaxaConfiancaRes;
    private javax.swing.JLabel jLabelValoresMedios;
    // End of variables declaration//GEN-END:variables
}
