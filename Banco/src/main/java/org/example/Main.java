package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.util.ArrayList;
import java.util.List;
import org.example.Pacote.PJ;

import javax.swing.JFrame;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Pessoa> listaPessoas = new ArrayList<>();
        
        CSalario cClaudio = new CSalario();
        CPoupanca cFelipe = new CPoupanca();
        CCorrente cMarcos = new CCorrente();


        PF pf1 = new PF("Felipe","32938034","felipe@gmail.com","1234","rio branco 4065","123.456.789-01");
        PF pf2 = new PF("Claudio","83230223","claudio@gmail.com","1234","RIo branco","123.456.789-01");
        listaPessoas.add(pf1);
        listaPessoas.add(pf2);

        PJ pj1 =  new PJ("Marcos","329994895","marcos@gmail.com","1234","bom pastor","889370001");
        listaPessoas.add(pj1);
        
        String caminhoArquivo = "pessoas.txt";
        ProcessarArquivos.salvarPessoas(caminhoArquivo, listaPessoas);
        
        
        List<Pessoa> pessoasCarregadas = ProcessarArquivos.carregarPessoas(caminhoArquivo);
        
        for (Pessoa pessoa : pessoasCarregadas) {
            if (pessoa instanceof PF) {
                PF pf = (PF) pessoa;
                System.out.println("Pessoa Fisica: " + pf.getNome() + " - CPF: " + pf.getCpf());
            } else if (pessoa instanceof PJ) {
                PJ pj = (PJ) pessoa;
                System.out.println("Pessoa Juridica: " + pj.getNome() + " - CNPJ: " + pj.getCnpj());
            }
        }
        
        
/*
        
        //vou implementar a inteface a partir daqui

        // Cria o frame
        JFrame LoginFrame = new JFrame("Login");

        Login loginPanel = new Login();

        // foi
        LoginFrame.setContentPane(loginPanel);

        // inicializa bonitinho
        LoginFrame.setSize(800, 500);
        LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginFrame.pack();
        LoginFrame.setVisible(true);
        LoginFrame.setLocationRelativeTo(null);
*/

    }
}