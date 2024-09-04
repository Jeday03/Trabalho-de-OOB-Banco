package org.example;

public class PJ extends Pessoa{

    private String cnpj;

    public PJ(String nome, String email, String senha,String cnpj) {
        super(nome, email, senha);
        this.cnpj = cnpj;
    }


    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
