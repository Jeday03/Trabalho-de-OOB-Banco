package org.example;

public class PF extends Pessoa{

    private String cpf;

    public PF(String nome, String email, String senha,String cpf) {
        super(nome, email, senha);
        this.cpf = cpf;
    }


    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
