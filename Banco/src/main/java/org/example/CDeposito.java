package org.example;

public class CDeposito extends Conta{
    public CDeposito(String agencia,String titular) {
        super( agencia, titular);
    }

    public void Depositar(double valor) {
        double saldo = getSaldo();
        setSaldo(saldo+=valor);
    }
}
