package org.example.Pacote;

import org.example.DataNascimento;
import org.example.Email;
import org.example.Pessoa;
import org.example.Telefone;

public abstract class Cliente extends Pessoa {
    private static int numClientes;
    private int id;
    private DataNascimento dataNascimento;
    private String nome;
    private Telefone telefone;

    public Cliente(String nome, Telefone telefone, Email email, String senha, DataNascimento dataNascimento) {
        super(email, senha);
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        numClientes++;
        id = numClientes;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento.getData();
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone.getTelefone();
    }

    public int getId() {
        return id;
    }

    public boolean abrirConta(Conta conta){
        conta.setTitular(this);
        return true;
    }
}