package org.example.Pacote;

import org.example.*;

public class PJ extends Cliente {
    private CNPJ cnpj;

    public PJ(String nome, Telefone telefone, Email email, String senha, DataNascimento dataNascimento, CNPJ cnpj) {
        super(nome, telefone, email, senha, dataNascimento);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj.getCnpj();
    }

    @Override
    public boolean abrirConta(Conta conta) {
        if(conta instanceof CSalario){
            return false;
        }
        conta.setTitular(this);
        return true;
    }
}