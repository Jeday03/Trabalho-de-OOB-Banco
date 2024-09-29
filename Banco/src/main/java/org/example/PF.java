package org.example;

import org.example.Pacote.Cliente;

public class PF extends Cliente {
    private String cpf;

    public PF(String nome, String telefone, String email, String senha, String endereco, String cpf) {
        super(nome, telefone, email, senha, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }


    @Override
    public void fecharConta() {
        System.out.println("Conta de Pessoa Física encerrada.");
    }

    public void setCpf(String documento) {
        this.cpf = documento;
    }
}

