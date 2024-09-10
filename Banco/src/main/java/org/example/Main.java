package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import org.example.Pacote.CPoupanca;
import org.example.Pacote.PJ;

import javax.swing.JFrame;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CSalario cClaudio = new CSalario();
        CPoupanca cFelipe = new CPoupanca();
        CCorrente cMarcos = new CCorrente();


        PF pf1 = new PF("Felipe","32938034","felipe@gmail.com","1234","rio branco 4065","123.456.789-01");
        PF pf2 = new PF("Claudio","83230223","claudio@gmail.com","1234","RIo branco","123.456.789-01");

//        try{
//            PJ pj1 = new PJ("Marcos","marcos@gmail.com","1234","123.456.789-01",p1);
//        }
//        catch(IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }

        PJ pj1 =  new PJ("Marcos","329994895","marcos@gmail.com","1234","bom pastor","889370001");

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


    }
}