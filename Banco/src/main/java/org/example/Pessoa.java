    package org.example;

    public class Pessoa {
        private Email email;
        private String senha;

        public Pessoa(){
        }
        public Pessoa(Email email, String senha) {
            this.email = email;
            this.senha = senha;
        }
        public String getEmail() {
            return email.getEmail();
        }
        public String getSenha() {
            return senha;
        }


        public void setSenha(String senha) {
            this.senha = senha;
        }



    }