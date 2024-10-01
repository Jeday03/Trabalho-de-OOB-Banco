    package org.example;

    public abstract class Pessoa {
        CPF cpf;
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

        public void setCpf(CPF cpf) {
            this.cpf = cpf;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }
    }