package org.example;

import org.example.Deposito.Conta;

public class Pessoa {
    private String nome;
    private String email;
    private String senha;
    private Conta conta;

    public Pessoa( String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.conta = null;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    public Conta getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }


}
