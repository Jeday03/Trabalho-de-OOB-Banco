package org.example;
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {
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
