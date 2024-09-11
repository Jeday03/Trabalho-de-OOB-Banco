package org.example.Pacote;

import java.util.Date;
import java.util.List;

public class CDeposito extends Conta {
    public CDeposito() {
        super();
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            incrementaSaldo(null, valor); // Atualizar o saldo
            Date data = new Date();
            // Adicionar transação ao extrato
            List<Transacao> transacoes = getExtrato().get(getIdConta());
            if (transacoes != null) {
                transacoes.add(new Transacao(valor, data, "Depósito", null, null));
            }
            return true;
        }
        return false;
    }
}

