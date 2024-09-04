package org.example;

public class Conta {
    private String tipo;
    private static int numero;
    private String agencia;
    private String titular;
    private double saldo;

    public Conta(String agencia, String titular, double saldo, String tipo) {
        this.tipo = tipo;
        numero++;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = saldo;
    }



}
