package org.example;

public class Conta {
    private static int numero;
    private String agencia;
    private String titular;
    private double saldo;

    public Conta(String agencia, String titular, double saldo) {
        numero++;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = saldo;
    }



}
