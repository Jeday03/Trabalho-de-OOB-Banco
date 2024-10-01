package org.example;

import java.io.Serializable;

public class Cliente extends Pessoa{
    private DataNascimento dataNascimento;
    private String nome;
    private Telefone telefone;

    public Cliente(String nome, Telefone telefone, String senha, DataNascimento dataNascimento,CPF cpf) {
        super(cpf, senha);
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return
                nome + "," +
                telefone.toString() + "," +
                getSenha() + "," +
                dataNascimento.toString() + "," +
                getCpf().toString();
    }

    public boolean abrirConta(Conta conta){
        conta.setTitular(this);
        return true;
    }
}