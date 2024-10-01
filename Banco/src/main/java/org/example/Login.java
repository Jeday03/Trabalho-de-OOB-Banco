package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login extends javax.swing.JPanel {

    private ContaManager contaManager;
    private Gerente gerente;// Gerenciador de contas
    private List<Conta> contas; // Lista de contas

    public Login(ContaManager contaManager, List<Conta> contas, Gerente gerente) {
        this.contaManager = contaManager;
        this.contas = contas;
        this.gerente = gerente;
        initComponents();
        configurarBotoes();
    }


    private void configurarBotoes() {
        jButtonCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = jTextField1.getText();
                String senha = new String(jPasswordField1.getPassword());
                if (validarLogin(cpf, senha, true)) { // true indica que estamos validando um cliente
                    UserInterface painelDoUsuario = new UserInterface(); 

                    painelDoUsuario.setSize(800, 500); 
                    painelDoUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                    painelDoUsuario.setLocationRelativeTo(null);
                    painelDoUsuario.setVisible(true); 
                    ((JFrame) SwingUtilities.getWindowAncestor(Login.this)).dispose(); // Fechar a tela de Login

                    JOptionPane.showMessageDialog(Login.this, "Login de cliente bem-sucedido!");
                } else {
                    JOptionPane.showMessageDialog(Login.this, "CPF ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jButtonGerente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = jTextField1.getText();
                String senha = new String(jPasswordField1.getPassword());
                if (validarLogin(cpf, senha, false)) { // false indica que estamos validando um gerente
                    JFrame frame = new JFrame("Interface do Gerente");
            frame.setSize(800, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Adiciona o painel de login
            InterfaceGerente loginPanel = new InterfaceGerente();
            frame.setContentPane(loginPanel);

            // Centraliza a janela na tela
            frame.setLocationRelativeTo(null);

            // Torna a janela visível
            frame.setVisible(true);
           ((JFrame) SwingUtilities.getWindowAncestor(Login.this)).dispose(); // Fechar a tela de Login

                    JOptionPane.showMessageDialog(Login.this, "Login de gerente bem-sucedido!");
                } else {
                    JOptionPane.showMessageDialog(Login.this, "CPF ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    private boolean validarLogin(String cpf, String senha, boolean isCliente) {
        if (isCliente) {
            // Validação para clientes
            for (Conta conta : contas) {
                if (conta.getTitular().getCpf().toString().equals(cpf) && conta.getTitular().getSenha().equals(senha)) {
                    return true; // CPF e senha válidos
                }
            }
        } else {
            if (gerente != null && gerente.getCpf().toString().equals(cpf) && gerente.getSenha().equals(senha)) {
                return true; // CPF e senha válidos para o gerente
            }
        }
        return false; // CPF ou senha inválidos
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        Esquerda = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Direita = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButtonCliente = new javax.swing.JButton();
        jButtonGerente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Esquerda.setBackground(new java.awt.Color(0, 102, 102));
        Esquerda.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel5.setFont(new java.awt.Font("SimSun-ExtB", 0, 80)); // NOI18N
        jLabel5.setText("Bank");

        jLabel6.setFont(new java.awt.Font("SimSun-ExtB", 0, 60)); // NOI18N
        jLabel6.setText("FRYP");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/maior.png"))); // NOI18N
        jLabel7.setText(" ");

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
                EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EsquerdaLayout.createSequentialGroup()
                                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(EsquerdaLayout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addComponent(jLabel7))
                                        .addGroup(EsquerdaLayout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(jLabel6))
                                        .addGroup(EsquerdaLayout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addComponent(jLabel5)))
                                .addContainerGap(98, Short.MAX_VALUE))
        );
        EsquerdaLayout.setVerticalGroup(
                EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(180, 180, 180))
        );

        jPanel1.add(Esquerda);
        Esquerda.setBounds(0, 0, 400, 500);

        Direita.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("CPF");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Senha");

        jButtonCliente.setBackground(new java.awt.Color(0, 102, 102));
        jButtonCliente.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCliente.setText("Entrar como Cliente");

        jButtonGerente.setBackground(new java.awt.Color(0, 102, 102));
        jButtonGerente.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerente.setText("Entrar como Gerente");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel4.setText("Não tenho uma conta");

        jButton3.setForeground(new java.awt.Color(51, 153, 255));
        jButton3.setText("Criar uma conta");

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir a tela de Cadastro

                JFrame CriarConta = new JFrame("Criar Conta");

                SingUp singUpPanel = new SingUp();

                CriarConta.setContentPane(singUpPanel);

                // inicializa
                CriarConta.setSize(800, 500);
                CriarConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                CriarConta.pack();
                CriarConta.setVisible(true);
                CriarConta.setLocationRelativeTo(null);
                ((JFrame) SwingUtilities.getWindowAncestor(Login.this)).dispose(); // Fechar a tela de Login

                /*
                Cadastro cadastro = new Cadastro();
                cadastro.setVisible(true); // Exibir a nova janela de cadastro
                ((JFrame) SwingUtilities.getWindowAncestor(Login.this)).dispose(); // Fechar a tela de Login
           */
            }
        });

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
                DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(142, 142, 142))
                        .addGroup(DireitaLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel2)
                                                .addComponent(jTextField1)
                                                .addComponent(jLabel3)
                                                .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                                .addGroup(DireitaLayout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton3)))
                                        .addGroup(DireitaLayout.createSequentialGroup()
                                                .addComponent(jButtonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(39, Short.MAX_VALUE))
        );
        DireitaLayout.setVerticalGroup(
                DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DireitaLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel1)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonCliente)
                                        .addComponent(jButtonGerente))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addContainerGap(151, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(Esquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Direita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 500);
    }

    // Variáveis de classe
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JButton jButtonCliente;
    private javax.swing.JButton jButtonGerente;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
}
