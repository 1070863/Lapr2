package ui;

import controller.CriarCPController;
import eventoscientificos.CP;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Revisor;
import eventoscientificos.Topico;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * Classe que serve de interface gráfica ao processo de criação de CP.
 *
 * @author GRUPO66 LAPR2
 */
public class CriarCPUI extends javax.swing.JDialog {

    private CriarCPController m_controllerCCP;
    private CP m_cp;
    private Evento eventoSelected;
    private Revisor r;
    private List<Topico> lstTopicos;
    private static Empresa m_empresa;
    private static String strId;
    private static final int JANELA_POSICAO_X = 500;
    private static final int JANELA_POSICAO_Y = 100;

    /**
     * Creates new form CriarCPUI
     */
    public CriarCPUI(javax.swing.JFrame pai, boolean modal, Empresa m_empresa, String strId) {
        initComponents();
        this.m_controllerCCP = new CriarCPController(m_empresa);
        this.m_cp = new CP();

        inicializa(strId);

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
        jtfIDRevisor = new javax.swing.JTextField();
        btnProcurar = new javax.swing.JButton();
        btnDefinirCP = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfNomeRevisor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlTopicosEvento = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        btnSetTopicosPericia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar CP (Comissão de Programa)");

        jLabel1.setText("Intriduza o Id do novo Revisor:");

        btnProcurar.setText("Procurar membro Revisor");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        btnDefinirCP.setText("Definir CP");
        btnDefinirCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefinirCPActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Revisor:");

        jScrollPane1.setViewportView(jlTopicosEvento);

        jLabel3.setText("Defina os tópicos de perícia do Revisor:");

        btnSetTopicosPericia.setText("Definir Tópicos Pericia");
        btnSetTopicosPericia.setToolTipText("Prima após selecionar os tópicos de perícia do revisor.");
        btnSetTopicosPericia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetTopicosPericiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(btnProcurar))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addComponent(jtfIDRevisor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jtfNomeRevisor)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnDefinirCP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(btnSetTopicosPericia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfIDRevisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnProcurar)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNomeRevisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSetTopicosPericia)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnDefinirCP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed

        r = this.m_controllerCCP.addMembroCP(jtfIDRevisor.getText());
        if (r == null) {
            JOptionPane.showMessageDialog(null, "Não existe o revisor!!!", "Adicionar Revisor a CP", ERROR_MESSAGE);
            jtfIDRevisor.setText("");
            jtfIDRevisor.removeAll();
        } else {
            int confirma = JOptionPane.showConfirmDialog(null,
                    r.getM_strNome() + "\n\nAdicionar Revisor CP?", "Confirmar Revisor", ConfirmationCallback.YES_NO_OPTION);
            if (confirma == 0) {
                if (this.m_controllerCCP.registaMembroCP(r));
                JOptionPane.showMessageDialog(null, "Revisor adicionado à CP.");
                jtfIDRevisor.setText("");
                jtfNomeRevisor.setText(r.getM_strNome());
                criaListaTopicosEvento();
                jtfIDRevisor.removeAll();
            } else {
                JOptionPane.showMessageDialog(null, "O Revisor não foi adicionado.\n "
                        + "Já consta da CP", "Adicionar Revisor", ERROR_MESSAGE);
                jtfIDRevisor.setText("");
                jtfIDRevisor.removeAll();
            }
        }
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnSetTopicosPericiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetTopicosPericiaActionPerformed

        int confirma = JOptionPane.showConfirmDialog(null,
                "Adicionar, os tópicos de perícia selecionados, a Revisor?" + r.getM_strNome(), "Confirmar Topicos Perícia", ConfirmationCallback.YES_NO_OPTION);

        if (confirma == 0) {
            List<Topico> lsTopicos = new ArrayList<>();
            int[] topicos = jlTopicosEvento.getSelectedIndices();
            for (int i = 0; i < topicos.length; i++) {
                topicos = jlTopicosEvento.getSelectedIndices();
            }
            for (int j = 0; j < topicos.length; j++) {
                lsTopicos.add(eventoSelected.getM_listaTopicos().get(j));
            }

            m_controllerCCP.setListaTopicosRevisor(r, lsTopicos);
            r.setM_listaTopicos(jlTopicosEvento.getSelectedValuesList());
            JOptionPane.showMessageDialog(null, "Tópicos de Perícia adicionados.");
            jlTopicosEvento.clearSelection();
            jtfNomeRevisor.setText("");
        }
    }//GEN-LAST:event_btnSetTopicosPericiaActionPerformed

    private void btnDefinirCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefinirCPActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null,
                "Deseja criar a CP?", "Confirmar Criar CP", ConfirmationCallback.YES_NO_OPTION);

        if (confirma == 0 && this.m_controllerCCP.termina()) {
            m_controllerCCP.setCP();
            JOptionPane.showMessageDialog(null, "CP criada com sucesso.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "A CP não foi criada.\n "
                    + "Falhou a validação", "Criar CP", ERROR_MESSAGE);
            dispose();
        }

    }//GEN-LAST:event_btnDefinirCPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int confirma = JOptionPane.showConfirmDialog(this,
                "Terminar Definição de Tópicos de Evento?", "Confirmar", ConfirmationCallback.YES_NO_OPTION);
        if (confirma == 0) {
            this.m_controllerCCP.termina();
            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Método main gerado pelo editor de Swing.
     *
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
            java.util.logging.Logger.getLogger(CriarCPUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarCPUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarCPUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarCPUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CriarCPUI dialog = new CriarCPUI(new javax.swing.JFrame(), true, m_empresa, strId);
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
    private javax.swing.JButton btnDefinirCP;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton btnSetTopicosPericia;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList jlTopicosEvento;
    private javax.swing.JTextField jtfIDRevisor;
    private javax.swing.JTextField jtfNomeRevisor;
    // End of variables declaration//GEN-END:variables

    /**
     * Classe que inicializa o processo de criação da comissão de programa.
     *
     * @param strId id do organizador
     */
    public void inicializa(String strId) {
        List<Evento> le = this.m_controllerCCP.getEventosOrganizador(strId);
        eventoSelected = apresentaEventosOrganizador(le);
        m_controllerCCP.selectEvento(eventoSelected);
    }

    /**
     * Apresenta a lista de eventos do é Organizador e permite selecionar o
     * Evento para o qual irá criar a CP.
     *
     * @param le lista de eventos do Organizador
     * @return Evento para o qual deve ser criada a cp
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
     * Cria lista de tópicos de evento a ser apresentada ao Organizador.
     */
    private void criaListaTopicosEvento() {
        jlTopicosEvento.setModel(m_controllerCCP.listaDeTopicos());
    }

}
