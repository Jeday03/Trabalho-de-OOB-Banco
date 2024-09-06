package org.example;

import org.example.Pacote.Conta;
import org.example.Pacote.Pessoa;

public class PF extends Pessoa {

    private String cpf;

    public PF(String nome, String email, String senha, String cpf, Conta conta) {
        super(nome, email, senha,conta);
        this.cpf = cpf;
    }


    public String getCpf() {
        return cpf;
    }

}
