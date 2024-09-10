package org.example;

import org.example.Pacote.Conta;
import org.example.Pacote.Pessoa;

public class PJ extends Cliente {
    private String cnpj;

    public PJ(String nome, String telefone, String email, String senha, String endereco, String cnpj) {
        super(nome, telefone, email, senha, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public void abrirConta() {
        System.out.println("Pessoa Jurídica abrindo conta...");
        // Criando uma Conta Poupança para Pessoa Jurídica
        CPoupanca contaPoupanca = new CPoupanca();
        System.out.println("Conta Poupança aberta com saldo: " + contaPoupanca.getSaldo());
    }

    @Override
    public void fecharConta() {
        System.out.println("Conta de Pessoa Jurídica encerrada.");
    }
}