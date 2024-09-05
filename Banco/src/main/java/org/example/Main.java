package org.example;

import org.example.Deposito.CDeposito;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PF pessoaA = new PF("Felipe","felipe@gmail.com","1234","123.456.789-07");
        CPoupanca a = new CPoupanca(pessoaA.getNome());
        pessoaA.setConta(a);


        CSalario b = new CSalario("Claudio");
        CDeposito c = new CDeposito("Feli");
        CDeposito d = new CDeposito("Fe");
        CPoupanca e = new CPoupanca("lipe");


        a.depositar(100);
        a.transferir(b,50);
        a.sacar(10);

        b.sacar(10);

        a.transferir(c,51);
        c.depositar(500);
        c.sacar(500.01);

        c.transferir(e,20.53);

        pessoaA.getConta().imprimeinfo();
        b.imprimeinfo();
        c.imprimeinfo();
        d.imprimeinfo();
        e.imprimeinfo();

        pessoaA.getConta().imprimeTransacoes();
        b.imprimeTransacoes();

    }
}