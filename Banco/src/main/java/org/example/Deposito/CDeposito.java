package org.example.Deposito;

import java.util.Date;

public class CDeposito extends Conta {
    public CDeposito(String titular) {
        super(titular);
    }

    public boolean depositar(double valor) {
        if(valor>0) {
            double saldo = getSaldo();
            setSaldo(null,saldo += valor);
            Date data = new Date();
            transacoes.add(new Transacao(valor,data,"Depósito",null,null));
            return true;
        }
        return false;
    }
}
