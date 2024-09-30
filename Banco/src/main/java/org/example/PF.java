package org.example;

import org.example.Pacote.Cliente;

public class PF extends Cliente {
    private CPF cpf;

    public PF(String nome, Telefone telefone, Email email, String senha, DataNascimento dataNascimento, CPF cpf) {
        super(nome, telefone, email, senha, dataNascimento);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf.getCpf();
    }


}

