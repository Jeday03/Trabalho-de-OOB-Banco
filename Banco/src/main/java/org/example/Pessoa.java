    package org.example;

    public class Pessoa {
        private String nome;
        private String telefone;
        private String email;
        private String senha;

        public Pessoa(){
        }
        public Pessoa( String nome,String telefone, String email, String senha) {
            this.nome = nome;
            this.email = email;
            this.telefone = telefone;
            this.senha = senha;
        }
        //GETTERS
        public String getNome() {
            return nome;
        }
        public String getTelefone() {
            return telefone;
        }
        public String getEmail() {
            return email;
        }
        public String getSenha() {
            return senha;
        }

        //SETTERS
        public void setEmail(String email) {
            this.email = email;
        }
        public void setSenha(String senha) {
            this.senha = senha;
        }
        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }


        public void setNome(String nome) {
            this.nome = nome;
        }


    }