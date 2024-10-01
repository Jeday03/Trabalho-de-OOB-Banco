package org.example;
import javax.swing.*;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        ContaManager contaManager = new ContaManager();

        try {
            List<Conta> contas = contaManager.carregarContas("contas.txt");

            // Verificando se as contas foram criadas corretamente
            for (Conta conta : contas) {
                System.out.println("Conta criada: " + conta.getClass().getSimpleName());
                System.out.println("Titular: " + conta.getTitular().getNome());
                System.out.println("Saldo: " + conta.getSaldo());
                System.out.println("-----------------------");
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar contas: " + e.getMessage());
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
