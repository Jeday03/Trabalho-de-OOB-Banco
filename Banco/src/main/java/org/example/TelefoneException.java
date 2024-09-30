package org.example;

public class TelefoneException extends Exception{
    public TelefoneException() {
        super("O telefone deve estar no formato (xx)9xxxx-xxxx");
    }
}
