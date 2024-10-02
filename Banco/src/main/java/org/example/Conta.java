package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public abstract class Conta {
    private Cliente titular;
    private double saldo;

    // Map para armazenar o extrato por idConta
    private Map<CPF, List<Transacao>> extrato = new HashMap<>();

    public void setTitular(Cliente titular) {
        this.titular = titular;
        extrato.put(titular.getCpf(), new ArrayList<>());
    }

    protected Conta() {
        this.titular = null;
        this.saldo = 0;
    }

    private boolean existeTitular(){
        if(titular!=null)
            return true;
        return false;
    }


    // Getter para extrato
    public Map<CPF, List<Transacao>> getExtrato() {
        return this.extrato;
    }

    public void incrementaSaldo(Cliente autor, double valor) throws IOException {
        if (existeTitular()) {
            if (autor != null) {
                LocalDate data = LocalDate.now();
                List<Transacao> transacoes = extrato.get(titular.getCpf());
                if (transacoes != null) {
                    transacoes.add(new Transacao(valor, data, "Transferência", autor.getNome(), "Você"));
                }
            }
            this.saldo += valor;

            // Chama o método para atualizar o saldo no arquivo
            Gerente.mudarSaldo(this.getTitular().getCpfString(), this.saldo);
        }
    }


    public boolean sacar(double valor) throws IOException {
        if(existeTitular()) {
            if (retira(valor)) {
                LocalDate data = LocalDate.now();
                if (titular != null) {
                    List<Transacao> transacoes = extrato.get(titular.getCpf());
                    if (transacoes != null) {
                        transacoes.add(new Transacao(-valor, data, "Saque", null, null));
                    }
                    return true;
                }
            }
            System.out.println(saldo);
        }

        return false;
    }

    protected boolean retira(double valor) throws IOException {
        if (saldo >= valor) {
            saldo -= valor;
            Gerente.mudarSaldo(this.getTitular().getCpfString(), this.saldo);
            return true;
        }
        return false;
    }

    protected boolean verificaTransferencia(Conta remetente, double valor, double valorTransfere) throws IOException {
        if(existeTitular()) {
            if (retira(valor)) {
                remetente.incrementaSaldo(titular, valorTransfere);
                LocalDate data = LocalDate.now();
                List<Transacao> transacoes = extrato.get(titular.getCpf());
                if (transacoes != null) {
                    transacoes.add(new Transacao(-valor, data, "Transferência", "Você", remetente.titular.getNome()));
                }
                return true;
            }
        }
        return false;
    }

    public boolean transferir(Conta remetente, double valor) throws IOException {
        return verificaTransferencia(remetente, valor,valor);
    }

    public boolean depositar(double valor) throws IOException {
        if(existeTitular()) {
            if (valor > 0) {
                incrementaSaldo(null, valor); // Atualizar o saldo
                LocalDate data = LocalDate.now();
                // Adicionar transação ao extrato
                List<Transacao> transacoes = extrato.get(titular.getCpf());
                if (transacoes != null) {
                    transacoes.add(new Transacao(valor, data, "Depósito", null, null));
                }
                return true;
            }
        }
        return false;
    }
    public void salvarExtratoEmArquivo(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Map.Entry<CPF, List<Transacao>> entry : extrato.entrySet()) {
                CPF cpf = entry.getKey();
                List<Transacao> transacoes = entry.getValue();
                writer.write("Extrato para CPF: " + cpf + "\n");
                for (Transacao transacao : transacoes) {
                    writer.write(transacao.toString() + "\n");
                }
                writer.write("\n"); // Adiciona uma linha em branco entre os extratos de diferentes CPFs
            }
            System.out.println("Extrato salvo em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o extrato: " + e.getMessage());
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    @Override
    public String toString() {
        return  "" + saldo;
    }

    public void setSaldo(double novoSaldo) {
        saldo = novoSaldo;
    }
}