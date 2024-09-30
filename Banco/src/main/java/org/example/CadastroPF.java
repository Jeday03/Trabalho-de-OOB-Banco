package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CadastroPF extends JPanel {
    private JTextField nomeField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JTextField cpfField;
    private JPasswordField senhaField;
    private JTextField dataNascimentoField;

    public CadastroPF() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(50, 30, 100, 30);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(150, 30, 200, 30);
        add(nomeField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 70, 100, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 70, 200, 30);
        add(emailField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(50, 110, 100, 30);
        add(telefoneLabel);

        telefoneField = new JTextField();
        telefoneField.setBounds(150, 110, 200, 30);
        add(telefoneField);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setBounds(50, 150, 100, 30);
        add(cpfLabel);

        cpfField = new JTextField();
        cpfField.setBounds(150, 150, 200, 30);
        add(cpfField);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(50, 190, 100, 30);
        add(senhaLabel);

        senhaField = new JPasswordField();
        senhaField.setBounds(150, 190, 200, 30);
        add(senhaField);

        JLabel dataNascimentoLabel = new JLabel("Data Nascimento:");
        dataNascimentoLabel.setBounds(50, 230, 150, 30);
        add(dataNascimentoLabel);

        dataNascimentoField = new JTextField(); // Inicializa o campo de data de nascimento
        dataNascimentoField.setBounds(150, 230, 200, 30);
        add(dataNascimentoField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(150, 270, 200, 30);
        add(cadastrarButton);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });
    }

    private void cadastrar() {
        String nome = nomeField.getText();
        String email = emailField.getText();
        String telefone = telefoneField.getText();
        String cpf = cpfField.getText();
        String senha = new String(senhaField.getPassword());
        String dataNascimento = dataNascimentoField.getText(); // Obtém a data de nascimento

        // Valida se todos os campos obrigatórios estão preenchidos
        if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || cpf.isEmpty() || senha.isEmpty() || dataNascimento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
            return;
        }

        try {
            Email emailObj = Email.parser(email);
            Telefone telefoneObj = Telefone.parser(telefone);
            CPF cpfObj = CPF.parser(cpf);
            DataNascimento dataNascimentoObj = DataNascimento.parser(dataNascimento);

            PF novaConta = new PF(nome, telefoneObj, emailObj, senha, dataNascimentoObj, cpfObj);
            salvarConta(novaConta);

        } catch (EmailException | TelefoneException | CPFException | DataNascimentoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void salvarConta(PF conta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contas_pf.txt", true))) {
            writer.write("Nome: " + conta.getNome() + ", Telefone: " + conta.getTelefone() +
                    ", Email: " + conta.getEmail() + ", CPF: " + conta.getCpf() +
                    ", Data de Nascimento: " + conta.getDataNascimento());
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Conta criada com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar a conta: " + e.getMessage());
        }
    }
}
