package org.example.Pacote;

import org.example.CSalario;
import org.example.PJ;

import java.util.Date;

public class CDeposito extends Conta {
    public CDeposito() {
        super();
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
