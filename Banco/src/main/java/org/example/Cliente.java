package org.example;

import org.example.Pacote.Pessoa;

public abstract class Cliente extends Pessoa {
    private static int id;
    private String endereco;

    public Cliente(String nome, String telefone, String email, String senha, String endereco) {
        super(nome, telefone, email, senha);
        id++;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public abstract void abrirConta();
    public abstract void fecharConta();
}