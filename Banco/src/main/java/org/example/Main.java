package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import javax.swing.JFrame;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CSalario cClaudio = new CSalario();
        CPoupanca cFelipe = new CPoupanca();
        CCorrente cMarcos = new CCorrente();

        PF pf1 = new PF("Felipe","felipe@gmail.com","1234","123.456.789-01",cFelipe);
        PF pf2 = new PF("Claudio","claudio@gmail.com","1234","123.456.789-01",cClaudio);

//        try{
//            PJ pj1 = new PJ("Marcos","marcos@gmail.com","1234","123.456.789-01",p1);
//        }
//        catch(IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }

        PJ pj1 =  new PJ("Marcos","marcos@gmail.com","1234","123.456.789-01", cMarcos);

        cFelipe.depositar(100);
        cFelipe.sacar(20);
        cFelipe.transferir(cMarcos,50);

        cFelipe.transferir(cClaudio,10);

        cMarcos.transferir(cClaudio,20);

        cClaudio.imprimeinfo();
        cFelipe.imprimeinfo();
        cMarcos.imprimeinfo();

        cFelipe.imprimeTransacoes();
        cMarcos.imprimeTransacoes();
        cClaudio.imprimeTransacoes();

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