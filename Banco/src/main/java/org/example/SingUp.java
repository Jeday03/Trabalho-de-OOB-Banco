/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class SingUp extends javax.swing.JPanel {

    List<Pessoa> listaPessoas = new ArrayList<>();
    String nome;
    String telefone;
    String email;
    String senha;
    String dataDeNacimento;
    String cpf;

    public SingUp() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TipoDePessoa = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/maior.png"))); // NOI18N
        jLabel7.setText(" ");

        jLabel5.setFont(new java.awt.Font("SimSun-ExtB", 0, 80)); // NOI18N
        jLabel5.setText("Bank");

        jLabel6.setFont(new java.awt.Font("SimSun-ExtB", 0, 60)); // NOI18N
        jLabel6.setText("FRYP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel5)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 500);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Criar Conta");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Senha");

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Data De Nascimento");

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Telefone");

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("CPF");

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Criar Conta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(94, 94, 94)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addGap(38, 38, 38))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        //Codigo aqui
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        //Codigo aqui
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        //Codigo aqui
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        //Codigo aqui
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        //Codigo aqui
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void salvarClienteEmArquivo(Cliente cliente, Conta conta) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contas.txt", true))) {
            writer.write(cliente.toString() + "," + conta.toString() + "," + conta.getClass().getSimpleName());
            writer.newLine();  // Adiciona uma nova linha após cada cliente
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        // Coleta de dados dos campos de texto
        nome = jTextField1.getText();
        senha = new String(jPasswordField1.getPassword());
        dataDeNacimento = jTextField5.getText();
        telefone = jTextField7.getText();
        cpf = jTextField8.getText();

        // Validação dos campos
        if(nome.isEmpty() || senha.isEmpty() || dataDeNacimento.isEmpty() || telefone.isEmpty() || cpf.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // Validação do CPF
        if (!validarCPF(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF inválido", "Erro na Criação de Conta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Confirmação dos dados
        int opcao = JOptionPane.showConfirmDialog(null, "Confirme seus dados:\n Nome: "+ nome + 
                "\n Telefone:  " + telefone +
                "\n Data de Nascimento: " + dataDeNacimento + 
                "\n CPF: " + cpf,
                "Confirmação", JOptionPane.OK_CANCEL_OPTION);

        if (opcao != JOptionPane.OK_OPTION) {
            return; // Interrompe se o usuário não confirmar
        }

        try {
            // Verifica se o CPF já está cadastrado
            if (cpfJaCadastrado(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Criação dos objetos com base nos dados coletados
            Telefone telefoneObj = Telefone.parser(telefone);
            CPF cpfObj = CPF.parser(cpf);
            DataNascimento dataNascimentoObj = DataNascimento.parser(dataDeNacimento);

            Cliente cliente = new Cliente(nome, telefoneObj, senha, dataNascimentoObj, cpfObj);

            // Seleção do tipo de conta
            String[] options = {"Conta Corrente", "Conta Poupança"};
            int escolha = JOptionPane.showOptionDialog(this, "Escolha o tipo de conta:", "Tipo de Conta",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            Conta conta = null;
            if (escolha == 0) {
                conta = new CCorrente();
            } else if (escolha == 1) {
                conta = new CPoupanca();
            }

            if (conta != null) {
                cliente.abrirConta(conta);
            }

            // Salva o cliente e a conta em arquivo
            salvarClienteEmArquivo(cliente, conta);

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Cadastro Concluído", JOptionPane.INFORMATION_MESSAGE);

            // Abre a tela de login após o cadastro
            ContaManager contaManager = new ContaManager();
            List<Conta> contas;

            try {
                contas = contaManager.carregarContas("contas.txt");

                // Verificando se as contas foram criadas corretamente
                for (Conta conta1 : contas) {
                    System.out.println("Conta criada: " + conta1.getClass().getSimpleName());
                    System.out.println("Titular: " + conta1.getTitular().getNome());
                    System.out.println("Saldo: " + conta1.getSaldo());
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

            JFrame LoginFrame = new JFrame("Login");
            Login loginPanel = new Login(contaManager, contas,gerente); // Passa o gerenciador e as contas
            LoginFrame.setContentPane(loginPanel);
            LoginFrame.setContentPane(loginPanel);
            LoginFrame.setSize(800, 500);
            LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            LoginFrame.pack();
            LoginFrame.setVisible(true);
            LoginFrame.setLocationRelativeTo(null);
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            parentFrame.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean validarCPF(String cpf) {
           // Lógica de validação de CPF conforme o primeiro código
           String CPF_REGEX = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$|^\\d{11}$";
           if (!Pattern.matches(CPF_REGEX, cpf)) {
               return false;
           }

           // Remover caracteres especiais
           cpf = cpf.replaceAll("\\D", "");

           // Eliminar CPFs com todos os números iguais
           if (cpf.matches("(\\d)\\1{10}")) {
               return false;
           }

           // Cálculo dos dígitos verificadores
           int sum = 0;
           for (int i = 0; i < 9; i++) {
               sum += (cpf.charAt(i) - '0') * (10 - i);
           }
           int firstVerifier = 11 - (sum % 11);
           if (firstVerifier >= 10) {
               firstVerifier = 0;
           }
           if (firstVerifier != (cpf.charAt(9) - '0')) {
               return false;
           }

           sum = 0;
           for (int i = 0; i < 10; i++) {
               sum += (cpf.charAt(i) - '0') * (11 - i);
           }
           int secondVerifier = 11 - (sum % 11);
           if (secondVerifier >= 10) {
               secondVerifier = 0;
           }
           return secondVerifier == (cpf.charAt(10) - '0');
       }
    private void salvarClienteEmArquivo(Pessoa pessoa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contas.txt", true))) {
            writer.write(pessoa.toString());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean cpfJaCadastrado(String cpfStr) {
        // Lógica para verificar se o CPF já está cadastrado em "contas.txt"
        try (BufferedReader reader = new BufferedReader(new FileReader("contas.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(","); // Supondo que os dados estão separados por vírgula
                if (dados.length > 4 && dados[4].equals(cpfStr)) { // CPF é o quinto campo
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lógica para verificar se o CPF já está cadastrado em "gerente.txt"
        try (BufferedReader reader = new BufferedReader(new FileReader("gerente.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(","); // Supondo que os dados estão separados por vírgula
                if (dados.length > 0 && dados[0].equals(cpfStr)) { // CPF é o primeiro campo
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // CPF não encontrado em nenhum dos arquivos
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup TipoDePessoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
