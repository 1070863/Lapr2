/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import controller.NotificarAutoresController;
import javax.swing.JOptionPane;
import java.awt.*;
import eventoscientificos.Empresa;
import eventoscientificos.Artigo;
import eventoscientificos.Evento;
import eventoscientificos.NotificarAutores;
import eventoscientificos.Utilizador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Pereira
 * interface gráfica UC8
 */
public class NotificarAutoresUI extends javax.swing.JDialog {
     
    private static Empresa m_empresa;
    private   Artigo m_artigo;
    private Utilizador utilizadorID;
    private  NotificarAutoresController m_NotificarAutoresController;
    private List<Evento> listaEventos;
    private String utilizador;
    private int iEvento=-1;
    /**
     * Creates new form NotificarAutoresUI
     * o construtor faz a inicialização da comboBox
     */
    public NotificarAutoresUI(java.awt.Frame parent, boolean modal, Empresa empresa ) {
        super(parent, modal);
        initComponents();
        this.m_empresa=empresa;
        m_NotificarAutoresController= new NotificarAutoresController(m_empresa);
        
    }
/**
 * Torna visivel a janela e  faz também a autenticação do utilizador
 */
     public void run()
     {
              utilizador = JOptionPane.showInputDialog(this,
                "Insira o Organizador", "Login", JOptionPane.INFORMATION_MESSAGE);
        if (utilizador != null) {

            utilizadorID = m_empresa.getM_registaUtilizador().getUtilizador(utilizador);
            listaEventos = m_NotificarAutoresController.getListaEventosProntosNotificar(utilizador);

            if (listaEventos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Utilizador não associado a nenhum evento pronto pra Notificação", "Notificar Autores",
                        JOptionPane.ERROR_MESSAGE);
                dispose();
            } else 
                for (Evento evento : listaEventos) {
                    jcboxEventos.addItem(evento.getM_strTitulo());
                    }

            }
        else {
                JOptionPane.showInputDialog(this,
                    "O ID introduzido não é válido", "Login", JOptionPane.ERROR_MESSAGE);
            
                pack();
                setResizable(false);
                setLocationRelativeTo(NotificarAutoresUI.this);
                
                setVisible(true);
            }
        
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        p1Evento = new javax.swing.JPanel();
        lblSelecionaEvento = new javax.swing.JLabel();
        jcboxEventos = new javax.swing.JComboBox();
        btnOK = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblSelecionaEvento.setText("Selecione um evento:");

        jcboxEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboxEventosActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p1EventoLayout = new javax.swing.GroupLayout(p1Evento);
        p1Evento.setLayout(p1EventoLayout);
        p1EventoLayout.setHorizontalGroup(
            p1EventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1EventoLayout.createSequentialGroup()
                .addGroup(p1EventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1EventoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSelecionaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jcboxEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p1EventoLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnOK)
                        .addGap(117, 117, 117)
                        .addComponent(btnCancelar)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        p1EventoLayout.setVerticalGroup(
            p1EventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1EventoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p1EventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelecionaEvento)
                    .addComponent(jcboxEventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(p1EventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p1Evento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p1Evento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed
/**
 * Após selecionar o evento inicia a autenticação usando o controller para iniciar o processo de notificação
 * @param evt 
 */
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
    iEvento = jcboxEventos.getSelectedIndex();
        if (iEvento != -1) {
//            Evento e = new Evento();
//            e = m_empresa.getM_registoEventos().getEvento((String) jcboxEventos.getSelectedItem());
        try {
            if(m_NotificarAutoresController.NotificarAutores(m_empresa.getM_registoEventos().getEvento((String) jcboxEventos.getSelectedItem())))
                JOptionPane.showMessageDialog(NotificarAutoresUI.this,"Foi criado o ficheiro para notificação","Notificar Autores",
                        JOptionPane.OK_OPTION);
        } catch (TransformerException ex) {
            JOptionPane.showMessageDialog(NotificarAutoresUI.this,"erro na Notificaçao","Notificar Autores",
                        JOptionPane.ERROR_MESSAGE);
        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(NotificarAutoresUI.this,"erro na Notificaçao","Notificar Autores",
                        JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(NotificarAutoresUI.this,"erro na Notificaçao","Notificar Autores",
                        JOptionPane.ERROR_MESSAGE);
        }
                        }
                       
                        else JOptionPane.showMessageDialog(NotificarAutoresUI.this,"erro na Notificaçao","Notificar Autores",
                        JOptionPane.ERROR_MESSAGE);
           
       if( m_NotificarAutoresController.termina())
           JOptionPane.showMessageDialog(NotificarAutoresUI.this,"Foi criado o ficheiro para notificação","Notificar Autores",
                        JOptionPane.OK_OPTION);
       else
         JOptionPane.showMessageDialog(NotificarAutoresUI.this,"erro na Notificaçao","Notificar Autores",
                        JOptionPane.ERROR_MESSAGE);
             
    }//GEN-LAST:event_btnOKActionPerformed

    private void jcboxEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboxEventosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcboxEventosActionPerformed

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
            java.util.logging.Logger.getLogger(NotificarAutoresUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotificarAutoresUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotificarAutoresUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotificarAutoresUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NotificarAutoresUI dialog = new NotificarAutoresUI(new javax.swing.JFrame(),true, m_empresa);
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
    private javax.swing.JButton btnOK;
    private javax.swing.JButton jButton1;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcboxEventos;
    private javax.swing.JLabel lblSelecionaEvento;
    private javax.swing.JPanel p1Evento;
    // End of variables declaration//GEN-END:variables
}
