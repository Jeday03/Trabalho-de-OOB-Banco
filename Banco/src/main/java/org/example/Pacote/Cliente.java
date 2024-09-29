package org.example.Pacote;

import org.example.Pessoa;

public abstract class Cliente extends Pessoa {
    private static int numClientes;
    private int id;
    private String endereco;

    public Cliente(String nome, String telefone, String email, String senha, String endereco) {
        super(nome, telefone, email, senha);
        numClientes++;
        id = numClientes;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEndereco() {
        return endereco;
    }


    public boolean abrirConta(Conta conta){
        conta.setTitular(this);
        return true;
    }

    public abstract void fecharConta();
}