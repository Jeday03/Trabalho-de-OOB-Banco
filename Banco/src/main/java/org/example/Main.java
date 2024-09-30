package org.example;
import javax.swing.*;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
            ClienteManager clienteManager = new ClienteManager();

            try {
                List<Cliente> clientes = clienteManager.carregarClientes("clientes.txt");
                for (Cliente cliente : clientes) {
                    System.out.println(cliente); // Imprime ou manipula o cliente como desejar
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar clientes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        JFrame frame = new JFrame("Login");

        // Define o conteúdo do JFrame como o painel de login
        Login loginPanel = new Login();
        frame.setContentPane(loginPanel);

        // Define tamanho da janela
        frame.setSize(800, 500);

        // Fecha a aplicação ao fechar a janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centraliza a janela na tela
        frame.setLocationRelativeTo(null);

        // Torna a janela visível
        frame.setVisible(true);
    }
}
