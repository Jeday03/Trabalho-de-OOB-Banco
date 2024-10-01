package org.example;
import java.time.LocalDate;

public class Transacao {
    private static int numtransacoes;
    private int idtransacao;
    private double valor;
    private LocalDate data;
    private String tipo;
    private String autor;
    private String remetente;

    Transacao(double valor, LocalDate data, String tipo, String autor, String remetente) {
        numtransacoes++;
        idtransacao = numtransacoes;
        this.valor = valor;
        this.tipo = tipo;
        this.autor = autor;
        this.remetente = remetente;
    }

    public int getIdtransacao() {
        return idtransacao;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        int dia = data.getDayOfMonth(),mes= data.getMonthValue(),ano = data.getYear();
        String data = dia + "/" + mes + "/" + ano;
        return data;
    }

    public String getTipo() {
        return tipo;
    }

    public String getAutor() {
        return autor;
    }

    public String getRemetente() {
        return remetente;
    }


}
