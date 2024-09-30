package org.example;

public class Telefone {
    private String telefone;

    private Telefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public static Telefone parser(String telefone) throws TelefoneException {
        if (telefone.matches("^\\(\\d{2}\\)9\\d{4}-\\d{4}$")) {

            return new Telefone(telefone);
        }
        throw new TelefoneException();
    }
}
