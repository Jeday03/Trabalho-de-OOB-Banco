package org.example;

import org.example.Pacote.Conta;
import org.example.Pacote.Pessoa;

public class PJ extends Pessoa {

    private String cnpj;

    public PJ(String nome, String email, String senha, String cnpj, Conta conta) {
        super(nome, email, senha,conta);
        this.cnpj = cnpj;
    }




    public String getCnpj() {
        return cnpj;
    }

}
