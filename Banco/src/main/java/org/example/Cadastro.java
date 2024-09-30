package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cadastro extends JFrame {

    private JTextField nomeField, telefoneField, cpfField, dataNascimentoField;
    private JPasswordField senhaField;
    private JButton cadastrarButton;

    public Cadastro() {
        setTitle("Cadastro de Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(30, 30, 100, 25);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(150, 30, 200, 25);
        add(nomeField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(30, 110, 100, 25);
        add(telefoneLabel);

        telefoneField = new JTextField();
        telefoneField.setBounds(150, 110, 200, 25);
        add(telefoneField);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setBounds(30, 150, 100, 25);
        add(cpfLabel);

        cpfField = new JTextField();
        cpfField.setBounds(150, 150, 200, 25);
        add(cpfField);

        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento:");
        dataNascimentoLabel.setBounds(30, 190, 150, 25);
        add(dataNascimentoLabel);

        dataNascimentoField = new JTextField();
        dataNascimentoField.setBounds(150, 190, 200, 25);
        add(dataNascimentoField);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(30, 230, 100, 25);
        add(senhaLabel);

        senhaField = new JPasswordField();
        senhaField.setBounds(150, 230, 200, 25);
        add(senhaField);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(150, 270, 100, 25);
        add(cadastrarButton);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });
    }

    private void cadastrarCliente() {
        try {
            // Validação dos campos obrigatórios
            if (nomeField.getText().trim().isEmpty() ||
                    telefoneField.getText().trim().isEmpty() ||
                    cpfField.getText().trim().isEmpty() ||
                    dataNascimentoField.getText().trim().isEmpty() ||
                    new String(senhaField.getPassword()).trim().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
                return; // Interrompe o cadastro se houver campos vazios
            }

            // Coleta de dados dos campos
            String nome = nomeField.getText();
            String telefoneStr = telefoneField.getText();
            String cpfStr = cpfField.getText();
            String dataNascimentoStr = dataNascimentoField.getText();
            String senha = new String(senhaField.getPassword());

            // Verifica se o CPF já está cadastrado
            if (cpfJaCadastrado(cpfStr)) {
                JOptionPane.showMessageDialog(this, "CPF já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return; // Interrompe o cadastro se o CPF já existir
            }

            Telefone telefone = Telefone.parser(telefoneStr);
            CPF cpf = CPF.parser(cpfStr);
            DataNascimento dataNascimento = DataNascimento.parser(dataNascimentoStr);

            Cliente cliente = new Cliente(nome, telefone, senha, dataNascimento, cpf) {};

            // Salva o cliente em arquivo
            salvarClienteEmArquivo(cliente);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");

        } catch (TelefoneException | CPFException | DataNascimentoException | FormatoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean cpfJaCadastrado(String cpfStr) {
        try (BufferedReader reader = new BufferedReader(new FileReader("clientes.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Supondo que os campos estão separados por vírgula
                String[] campos = linha.split(",");
                if (campos.length >= 5 && campos[4].trim().equals(cpfStr)) {
                    return true; // CPF encontrado
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao verificar CPF: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false; // CPF não encontrado
    }

    private void salvarClienteEmArquivo(Cliente cliente) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.txt", true))) {
            writer.write(cliente.toString());
            writer.newLine();  // Adiciona uma nova linha após cada cliente
        }
    }
}
