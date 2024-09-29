package org.example.Pacote;

import org.example.CSalario;

public class PJ extends Cliente {
    private String cnpj;

    public PJ(String nome, String telefone, String email, String senha, String endereco, String cnpj) {
        super(nome, telefone, email, senha, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public boolean abrirConta(Conta conta) {
        if(conta instanceof CSalario){
            return false;
        }
        conta.setTitular(this);
        return true;
    }

    @Override
    public void fecharConta() {
        System.out.println("Conta de Pessoa Jurídica encerrada.");
    }

    public void setCnpj(String documento) {
        this.cnpj = documento;
    }
}