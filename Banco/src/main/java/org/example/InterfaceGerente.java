/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example;

import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author rafae
 */
public class InterfaceGerente extends javax.swing.JPanel {

    /**
     * Creates new form InterfaceGerente
     */
    public InterfaceGerente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGerente().setVisible(true);
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Esquerda = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Direita = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Esquerda.setBackground(new java.awt.Color(0, 102, 102));
        Esquerda.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menor.png"))); // NOI18N
        jLabel2.setText(" ");

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PowerDown.png"))); // NOI18N
        jButton1.setText(" ");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 48)); // NOI18N
        jLabel1.setText("Gerente");

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1))
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButton1)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(74, 74, 74))
        );

        jPanel1.add(Esquerda);
        Esquerda.setBounds(0, 0, 350, 500);

        Direita.setBackground(new java.awt.Color(255, 255, 255));
        Direita.setPreferredSize(new java.awt.Dimension(400, 500));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("Editar Conta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton4.setText("Excluir Conta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        jLabel3.setText("Opções");

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DireitaLayout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(jLabel3))
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(141, 141, 141))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel3)
                .addGap(105, 105, 105)
                .addComponent(jButton3)
                .addGap(49, 49, 49)
                .addComponent(jButton4)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jPanel1.add(Direita);
        Direita.setBounds(350, 0, 460, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ContaManager contaManager = new ContaManager();
        List<Conta> contas;

        try {
            contas = contaManager.carregarContas("contas.txt");

            // Verificando se as contas foram criadas corretamente
            for (Conta conta : contas) {
                System.out.println("Conta criada: " + conta.getClass().getSimpleName());
                System.out.println("Titular: " + conta.getTitular().getNome());
                System.out.println("Saldo: " + conta.getSaldo());
                System.out.println("-----------------------");
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar contas: " + e.getMessage());
            return; // Sai do metodo caso ocorra um erro
        }

        GerenteManager gerenteManager = new GerenteManager();
        Gerente gerente=null;
        try {
            gerenteManager.carregarGerente("gerente.txt");
            gerente = gerenteManager.getGerente();
            if (gerente != null) {
                System.out.println("Gerente carregado:");
                System.out.println("CPF: " + gerente.getCpf());
                // Aqui você pode verificar a senha, etc.
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar gerente: " + e.getMessage());
        }

        JFrame frame = new JFrame("Login");
        Login loginPanel = new Login(contaManager, contas,gerente); // Passa o gerenciador e as contas
        frame.setContentPane(loginPanel);

        // Define tamanho da janela
        frame.setSize(800, 500);

        // Fecha a aplicação ao fechar a janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centraliza a janela na tela
        frame.setLocationRelativeTo(null);

        // Torna a janela visível
        frame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


}
