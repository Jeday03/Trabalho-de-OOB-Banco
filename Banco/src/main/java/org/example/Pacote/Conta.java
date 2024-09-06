package org.example.Pacote;

import org.example.CSalario;
import org.example.PJ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta {
    private int idConta;
    private static int numContas;
    private Pessoa titular;
    private double saldo;
    List<Transacao> transacoes = new ArrayList<>();

    protected Conta() {
        numContas++;
        idConta = numContas;
        this.titular = null;
        this.saldo = 0;
    }

    void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public void imprimeinfo(){
        System.out.println("Conta: " + idConta);
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Saldo: " + saldo);
        System.out.println();
    }

    public void imprimeTransacoes(){
        for (Transacao transacao : transacoes){
            System.out.println("Seu nome: " + titular.getNome());
            System.out.println("Tipo: " + transacao.getTipo());
            System.out.println("Valor: " + transacao.getValor());
            System.out.println("Data: " + transacao.getData());

            if(transacao.getTipo().equals("Transferência")) {
                System.out.println("Autor: " + transacao.getAutor());
                System.out.println("Remetente: " + transacao.getRemetente());
            }
            System.out.println();

        }
    }

    public double getSaldo() {
        return saldo;
    }

    void setSaldo(Pessoa autor,double saldo) {
        if(autor!=null) {
            Date data = new Date();
            transacoes.add(new Transacao(saldo,data,"Transferência",autor.getNome(),"Você"));
        }
        this.saldo = saldo;
    }


    public Pessoa getTitular() {
        return titular;
    }


    public boolean sacar(double valor) {
        if(retira(valor)) {
            Date data = new Date();
            transacoes.add(new Transacao(-valor,data,"Saque",null,null));
            return true;
        }
        return false;
    }

    private boolean retira(double valor) {
        if(saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta remetente, double valor) {
        if(remetente instanceof CSalario) {
            if (this.getTitular() instanceof PJ) {
                if (retira(valor)) {
                    double saldo = remetente.getSaldo();
                    remetente.setSaldo(titular, saldo += valor);
                    Date data = new Date();
                    transacoes.add(new Transacao(-valor, data, "Transferência", "Você", remetente.getTitular().getNome()));
                    return true;
                }
                return false;
            }
            return false;
        }
        if(retira(valor)) {
            double saldo = remetente.getSaldo();
            remetente.setSaldo(titular,saldo+=valor);
            Date data = new Date();
            transacoes.add(new Transacao(-valor,data,"Transferência","Você",remetente.getTitular().getNome()));
            return true;
        }
        return false;
    }




}
