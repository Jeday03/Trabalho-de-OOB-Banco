package org.example;

public class DataNascimentoException extends Exception{
    public DataNascimentoException() {
        super("A data deve estar no formato DD/MM/AAAA");
    }
}
