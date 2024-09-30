package org.example;

import java.time.LocalDate;
import java.util.*;

public abstract class Conta {
    private int idConta;
    private static int numContas;
    private Cliente titular;
    private double saldo;

    // Map para armazenar o extrato por idConta
    private static Map<Integer, List<Transacao>> extrato = new HashMap<>();

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    protected Conta() {
        numContas++;
        idConta = numContas;
        this.titular = null;
        this.saldo = 0;

        // Inicializar a lista de transações no extrato
        extrato.put(idConta, new ArrayList<>());
    }

    // Getter para idConta
    public int getIdConta() {
        return idConta;
    }

    // Getter para extrato
    public static Map<Integer, List<Transacao>> getExtrato() {
        return extrato;
    }

    public void incrementaSaldo(Cliente autor, double valor) {
        if (autor != null) {
            LocalDate data = LocalDate.now();
            List<Transacao> transacoes = extrato.get(idConta);
            if (transacoes != null) {
                transacoes.add(new Transacao(valor, data, "Transferência", autor.getNome(), "Você"));
            }
        }
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (retira(valor)) {
            LocalDate data = LocalDate.now();
            List<Transacao> transacoes = extrato.get(idConta);
            if (transacoes != null) {
                transacoes.add(new Transacao(-valor, data, "Saque", null, null));
            }
            return true;
        }
        return false;
    }

    protected boolean retira(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    protected boolean verificaTransferencia(Conta remetente, double valor, double valorTransfere){
        if (retira(valor)) {
            remetente.incrementaSaldo(titular, valorTransfere);
            LocalDate data = LocalDate.now();
            List<Transacao> transacoes = extrato.get(idConta);
            if (transacoes != null) {
                transacoes.add(new Transacao(-valor, data, "Transferência", "Você", remetente.titular.getNome()));
            }
            return true;
        }
        return false;
    }

    public boolean transferir(Conta remetente, double valor) {
        return verificaTransferencia(remetente, valor,valor);
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            incrementaSaldo(null, valor); // Atualizar o saldo
            LocalDate data = LocalDate.now();
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
