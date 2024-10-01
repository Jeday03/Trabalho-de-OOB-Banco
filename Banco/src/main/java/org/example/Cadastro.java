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

        // Inicialização dos campos de entrada
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 80, 25);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(100, 10, 160, 25);
        add(nomeField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(10, 40, 80, 25);
        add(telefoneLabel);

        telefoneField = new JTextField();
        telefoneField.setBounds(100, 40, 160, 25);
        add(telefoneField);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setBounds(10, 70, 80, 25);
        add(cpfLabel);

        cpfField = new JTextField();
        cpfField.setBounds(100, 70, 160, 25);
        add(cpfField);

        JLabel dataNascimentoLabel = new JLabel("Data Nascimento:");
        dataNascimentoLabel.setBounds(10, 100, 120, 25);
        add(dataNascimentoLabel);

        dataNascimentoField = new JTextField();
        dataNascimentoField.setBounds(130, 100, 130, 25);
        add(dataNascimentoField);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(10, 130, 80, 25);
        add(senhaLabel);

        senhaField = new JPasswordField();
        senhaField.setBounds(100, 130, 160, 25);
        add(senhaField);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(100, 160, 120, 25);
        add(cadastrarButton);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });

        setVisible(true);
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

            // Cria um novo cliente
            Cliente cliente = new Cliente(nome, telefone, senha, dataNascimento, cpf) {};

            // Seleciona o tipo de conta
            String[] options = {"Conta Corrente", "Conta Poupança"};
            int escolha = JOptionPane.showOptionDialog(this, "Escolha o tipo de conta:", "Tipo de Conta",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            // Cria a conta com base na escolha do usuário
            Conta conta = null;
            if (escolha == 0) { // Conta Corrente
                conta = new CCorrente();
            } else if (escolha == 1) { // Conta Poupança
                conta = new CPoupanca();
            }

            // Define o titular da conta
            if (conta != null) {
                cliente.abrirConta(conta);
            }

            // Salva o cliente e a conta em arquivo
            salvarClienteEmArquivo(cliente, conta);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");

        } catch (TelefoneException | CPFException | DataNascimentoException | FormatoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean cpfJaCadastrado(String cpfStr) {
        // Lógica para verificar se o CPF já está cadastrado
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
        return false;
    }

    private void salvarClienteEmArquivo(Cliente cliente, Conta conta) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contas.txt", true))) {
            writer.write(cliente.toString() + "," + conta.toString() + "," + conta.getClass().getSimpleName());
            writer.newLine();  // Adiciona uma nova linha após cada cliente
        }
    }
}
