package org.example;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ContaManager contaManager = new ContaManager();
        List<Conta> contas;

        try {
            contas = contaManager.carregarContas("contas.txt");


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

        //TESTE SACAR E DEPOSITAR
//        Conta conta=contas.getFirst();
//        try {
//            conta.depositar(1000000);
//            conta.sacar(2800);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("SALDO: "+conta.getSaldo());

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