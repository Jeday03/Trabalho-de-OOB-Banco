package org.example.Deposito;
import java.util.Date;

public class Transacao {
    private double valor;
    private Date data = new Date();
    private String tipo;
    private String autor;
    private String remetente;

    Transacao(double valor,Date data, String tipo, String autor,String remetente) {
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
        this.autor = autor;
        this.remetente = remetente;
    }

    double getValor() {
        return valor;
    }

    Date getData() {
        return data;
    }

    String getTipo() {
        return tipo;
    }

    String getAutor() {
        return autor;
    }

    String getRemetente() {
        return remetente;
    }


}
