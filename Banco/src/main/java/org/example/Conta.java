package org.example;

public class Conta {
    private int idConta;
    private static int numContas;
    private String titular;
    private double saldo;

    public Conta(String titular) {
        numContas++;
        idConta = numContas;
        this.titular = titular;
        this.saldo = 0;
    }
    public void imprimeinfo(){
        System.out.println("Conta: " + idConta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public String getTitular() {
        return titular;
    }


    public boolean sacar(double valor) {
        if(saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta remetente,double valor) {
        if(sacar(valor)) {
            double saldo = remetente.getSaldo();
            remetente.setSaldo(saldo+=valor);
            return true;
        }
        return false;
    }




}
