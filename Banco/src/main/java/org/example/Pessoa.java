    package org.example;

    public abstract class Pessoa {
        private CPF cpf;
        private String senha;


        public Pessoa(CPF cpf, String senha) {
            this.cpf = cpf;
            this.senha = senha;
        }

        public CPF getCpf() {
            return cpf;
        }

        public String getSenha() {
            return senha;
        }
    }