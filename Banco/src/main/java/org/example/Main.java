package org.example;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ContaManager contaManager = new ContaManager();
        List<Conta> contas;

        try {
            contas = contaManager.carregarContas("contas.txt");

            //Testa Extrato
            for (Conta conta : contas) {
                conta.salvarExtratoEmArquivo("extrato.txt");

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
        //teste editar conta

        try{
            Telefone telefone=Telefone.parser("(32)99141-9141");
            DataNascimento dataNascimento= DataNascimento.parser("20/05/2000");
            CPF cpf= CPF.parser("110.147.936-10");
            Cliente cliente2=new Cliente("felipe",telefone,"1010",dataNascimento,cpf);
            gerente.editarConta("123.456.789-09","contas.txt",cliente2);
        }catch (TelefoneException | DataNascimentoException | CPFException e ){
            e.getMessage();
        } catch (FormatoException e) {
            throw new RuntimeException(e);
        }


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
