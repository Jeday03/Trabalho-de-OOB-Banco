package org.example.Pacote;
import java.util.Date;

public class Transacao {
    private static int numtransacoes;
    private int idtransacao;
    private double valor;
    private Date data = new Date();
    private String tipo;
    private String autor;
    private String remetente;

    Transacao(double valor,Date data, String tipo, String autor,String remetente) {
        numtransacoes++;
        idtransacao = numtransacoes;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
        this.autor = autor;
        this.remetente = remetente;
    }

    public int getIdtransacao() {
        return idtransacao;
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
