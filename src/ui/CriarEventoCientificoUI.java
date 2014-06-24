package ui;

import controller.CriarEventoCientificoController;
import eventoscientificos.Empresa;
import eventoscientificos.Utilizador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Classe que serve de interface gráfica ao processo de criação de eventos cientificos
 *
 * @author GRUPO66 LAPR2
 */
public class CriarEventoCientificoUI extends javax.swing.JDialog {

    private static Empresa empresa;
    private CriarEventoCientificoController criarEventoCController;
    
    private static final int JANELA_POSICAO_X = 200, JANELA_POSICAO_Y = 200;

    public CriarEventoCientificoUI(Empresa empresa) {
        this.empresa = empresa;

    }

    /**
     * Creates new form SubmissaoArtigoUI
     */
    public CriarEventoCientificoUI(java.awt.Frame parent, boolean modal, Empresa empresa) {
        super(parent, modal);
        initComponents();
        this.empresa = empresa;
        criarEventoCController = new CriarEventoCientificoController(empresa);

    }

    /**
     * arranca janela
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

        lblDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        lblTitulo = new javax.swing.JLabel();
        jTextTitulo = new javax.swing.JTextField();
        lblLocal = new javax.swing.JLabel();
        jTextLocal = new javax.swing.JTextField();
        lblDataInicio = new javax.swing.JLabel();
        jDateChooserInicio = new com.toedter.calendar.JDateChooser();
        lblDataFim = new javax.swing.JLabel();
        jDateChooserFim = new com.toedter.calendar.JDateChooser();
        lblDataLSubmissao = new javax.swing.JLabel();
        jDateChooserLSubmissao = new com.toedter.calendar.JDateChooser();
        lblDataLimiteRevisao = new javax.swing.JLabel();
        jDateChooserRevisao = new com.toedter.calendar.JDateChooser();
        jButtonContinuar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        lblDataLimiteRegisto = new javax.swing.JLabel();
        jDateChooserRegisto = new com.toedter.calendar.JDateChooser();
        lblNumMaxTopicos = new javax.swing.JLabel();
        jTextnMaxTopicos = new javax.swing.JTextField();
        lblDataInicio1 = new javax.swing.JLabel();
        jDateChooserSubmissaoFinal = new com.toedter.calendar.JDateChooser();
        lblDataLimiteRegisto1 = new javax.swing.JLabel();
        lblLocal1 = new javax.swing.JLabel();
        jTextCidade = new javax.swing.JTextField();
        lblLocal2 = new javax.swing.JLabel();
        jTextPais = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar Evento Cientifico");

        lblDescricao.setText("Descrição:");

        txtDescricao.setColumns(20);
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        lblTitulo.setText("Título:");

        lblLocal.setText("Local:");

        lblDataInicio.setText("Data Inicio:");

        jDateChooserInicio.setDateFormatString("dd/MMM/yyyy");

        lblDataFim.setText("Data Fim:");

        jDateChooserFim.setDateFormatString("dd/MMM/yyyy");

        lblDataLSubmissao.setText("Data Limite de Submissão:");

        jDateChooserLSubmissao.setDateFormatString("dd/MMM/yyyy");

        lblDataLimiteRevisao.setText("Data Limite de Revisão:");

        jDateChooserRevisao.setDateFormatString("dd/MMM/yyyy");

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

        lblDataLimiteRegisto.setText("Data Limite de Registo:");

        jDateChooserRegisto.setDateFormatString("dd/MMM/yyyy");

        lblNumMaxTopicos.setText("Número Máximo de Tópicos por Artigo:");

        lblDataInicio1.setText("Nota: Submissão < Revisão < Submissão Final < Registo < Inicio < Fim");

        jDateChooserSubmissaoFinal.setDateFormatString("dd/MMM/yyyy");

        lblDataLimiteRegisto1.setText("Data Limite de Submissão Final:");

        lblLocal1.setText("Cidade:");

        lblLocal2.setText("País:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDataInicio1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblDataLimiteRegisto1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooserSubmissaoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDataLimiteRegisto)
                                    .addComponent(lblNumMaxTopicos))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jTextnMaxTopicos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDateChooserRegisto, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblDataInicio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitulo)
                                    .addComponent(lblDescricao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jTextTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jButtonContinuar))
                                    .addComponent(lblDataFim)
                                    .addComponent(lblDataLSubmissao)
                                    .addComponent(lblDataLimiteRevisao))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonCancelar)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooserFim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jDateChooserLSubmissao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jDateChooserRevisao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
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
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(jTextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLocal2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLocal1)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblLocal)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDataInicio)
                    .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataFim))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataLSubmissao)
                    .addComponent(jDateChooserLSubmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataLimiteRevisao)
                    .addComponent(jDateChooserRevisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataLimiteRegisto1)
                    .addComponent(jDateChooserSubmissaoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataLimiteRegisto)
                    .addComponent(jDateChooserRegisto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDataInicio1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumMaxTopicos)
                    .addComponent(jTextnMaxTopicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonContinuar)
                    .addComponent(jButtonCancelar))
                .addGap(23, 23, 23))
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
                if (criarEventoCController.validaEvento(jTextTitulo.getText())) {
                    if (jDateChooserLSubmissao.getDate().before(jDateChooserRevisao.getDate())) {
                        if (jDateChooserRevisao.getDate().before(jDateChooserSubmissaoFinal.getDate())) {
                            if (jDateChooserSubmissaoFinal.getDate().before(jDateChooserRegisto.getDate())) {
                                if (jDateChooserRegisto.getDate().before(jDateChooserInicio.getDate())) {
                                    if (jDateChooserInicio.getDate().before(jDateChooserFim.getDate()) || jDateChooserInicio.getDate().equals(jDateChooserFim.getDate())) {
                                        if (Integer.parseInt(jTextnMaxTopicos.getText()) > 0) {

                                            List<Utilizador> utilizadoresTemp = new ArrayList<Utilizador>();

                                            String texto = "Titulo: " + jTextTitulo.getText();
                                            texto += "\nDescrição: " + txtDescricao.getText();

                                            texto += "\n";
                                            int nOrganizadores = 0;
                                            String idOrganizador = "";
                                            while (nOrganizadores >= 0 && idOrganizador != null) {
                                                idOrganizador = JOptionPane.showInputDialog(this, "ID Organizador de Evento:", "Adicionar Organizador", JOptionPane.QUESTION_MESSAGE);

                                                if (idOrganizador != null) {
                                                    Utilizador u = empresa.getM_registaUtilizador().getUtilizador(idOrganizador);

                                                    if (u != null && !utilizadoresTemp.contains(u)) {
                                                        utilizadoresTemp.add(u);
                                                        texto += "\nUtilizador " + (nOrganizadores + 1) + ": " + u.getM_strNome();
                                                        nOrganizadores++;
                                                    } else {
                                                        JOptionPane.showMessageDialog(this, "Organizador não adicionado!", "Erro!", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                    int resposta = JOptionPane.showConfirmDialog(this, "Quer adicionar mais Organizadores?", "Adicionar Organizador",
                                                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                                                    if (resposta == JOptionPane.NO_OPTION && nOrganizadores > 0) {
                                                        nOrganizadores = -1;
                                                    } else if (resposta == JOptionPane.NO_OPTION && nOrganizadores == 0) {
                                                        JOptionPane.showMessageDialog(this, "Não adicionou nenhum Organizador!", "Erro!", JOptionPane.ERROR_MESSAGE);
                                                    }

                                                } else {
                                                    JOptionPane.showMessageDialog(this, "Não adicionou nenhum Organizador!", "Erro!", JOptionPane.ERROR_MESSAGE);

                                                }
                                            }
                                            if (nOrganizadores == -1) {
                                                int adicionarDados = JOptionPane.showConfirmDialog(this, texto, "Confirmação de dados.", JOptionPane.YES_NO_OPTION);

                                                if (adicionarDados == JOptionPane.NO_OPTION) {
                                                    dispose();
                                                } else {
                                                    criarEventoCController.novoEvento();
                                                    criarEventoCController.setTitulo(jTextTitulo.getText());
                                                    criarEventoCController.setDescricao(txtDescricao.getText());
                                                    criarEventoCController.setLocal(jTextLocal.getText());
                                                    criarEventoCController.setCidade(jTextCidade.getText());
                                                    criarEventoCController.setPais(jTextPais.getText());
                                                    criarEventoCController.setDataInicio(jDateChooserInicio.getDateFormatString());
                                                    criarEventoCController.setDataFim(jDateChooserFim.getDateFormatString());
                                                    criarEventoCController.setDataLimiteSubmissão(jDateChooserLSubmissao.getDateFormatString());
                                                    criarEventoCController.setDataLimiteRevisao(jDateChooserRevisao.getDateFormatString());
                                                    criarEventoCController.setDataLimiteRegisto(jDateChooserRegisto.getDateFormatString());
                                                    criarEventoCController.setDataLimiteSubmissaoFinal(jDateChooserSubmissaoFinal.getDateFormatString());

                                                    for (Utilizador uExistente : utilizadoresTemp) {
                                                        criarEventoCController.addOrganizador(uExistente.getM_strUsername());
                                                    }
                                                    criarEventoCController.registaEvento();

                                                    JOptionPane.showMessageDialog(this, "Evento registado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                                                    dispose();
                                                }
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Número máximo de eventos deve ser maior do que zero!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
                                        }
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
            java.util.logging.Logger.getLogger(CriarEventoCientificoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarEventoCientificoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarEventoCientificoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarEventoCientificoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CriarEventoCientificoUI dialog = new CriarEventoCientificoUI(new javax.swing.JFrame(), true, empresa);
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
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonContinuar;
    private com.toedter.calendar.JDateChooser jDateChooserFim;
    private com.toedter.calendar.JDateChooser jDateChooserInicio;
    private com.toedter.calendar.JDateChooser jDateChooserLSubmissao;
    private com.toedter.calendar.JDateChooser jDateChooserRegisto;
    private com.toedter.calendar.JDateChooser jDateChooserRevisao;
    private com.toedter.calendar.JDateChooser jDateChooserSubmissaoFinal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextCidade;
    private javax.swing.JTextField jTextLocal;
    private javax.swing.JTextField jTextPais;
    private javax.swing.JTextField jTextTitulo;
    private javax.swing.JTextField jTextnMaxTopicos;
    private javax.swing.JLabel lblDataFim;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblDataInicio1;
    private javax.swing.JLabel lblDataLSubmissao;
    private javax.swing.JLabel lblDataLimiteRegisto;
    private javax.swing.JLabel lblDataLimiteRegisto1;
    private javax.swing.JLabel lblDataLimiteRevisao;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblLocal1;
    private javax.swing.JLabel lblLocal2;
    private javax.swing.JLabel lblNumMaxTopicos;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtDescricao;
    // End of variables declaration//GEN-END:variables

}
