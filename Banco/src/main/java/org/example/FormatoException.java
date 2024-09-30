package org.example;

public class FormatoException extends Exception{
    public FormatoException(){
        super("O CPF deve estar no formarto xxx.xxx.xxx-xx");
    }
}
