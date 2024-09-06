package org.example.Pacote;

import org.example.CSalario;

public class Pessoa {
    private String nome;
    private String email;
    private String senha;
    private Conta conta;

    protected Pessoa( String nome, String email, String senha, Conta conta) {
//        if(conta instanceof CSalario){
//            throw new IllegalArgumentException("Pessoas jurídicas não podem ter conta Salário");
//        }
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        conta.setTitular(this);
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
