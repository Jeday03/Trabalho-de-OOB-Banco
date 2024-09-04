package org.example;

public class CDeposito extends Conta{
    public CDeposito(String titular) {
        super(titular);
    }

    public void depositar(double valor) {
        double saldo = getSaldo();
        setSaldo(saldo+=valor);
    }
}
