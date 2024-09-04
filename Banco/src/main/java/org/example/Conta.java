package org.example;

public class Conta {
    private static int numero;
    private String agencia;
    private String titular;
    private double saldo;

    public Conta(String agencia, String titular) {
        numero++;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
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

    public boolean transferir(Conta a,double valor) {
        if(sacar(valor)) {
            double saldo = a.getSaldo();
            a.setSaldo(saldo+=valor);
            return true;
        }
        return false;
    }




}
