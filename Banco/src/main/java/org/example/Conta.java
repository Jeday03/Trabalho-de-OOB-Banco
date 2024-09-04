package org.example;

public class Conta {
    private String tipo;
    private static int numero;
    private String agencia;
    private String titular;
    private double saldo;

    public Conta(String tipo,String agencia, String titular, double saldo) {
        this.tipo = tipo;
        numero++;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = saldo;
    }



}
