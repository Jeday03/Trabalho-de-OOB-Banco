package org.example;
import java.util.Date;

public class Transacao {
    private static int numTransacoes;
    private int idTransacao;
    private double valor;
    private Date data = new Date();
    private String tipo;
    private String autor;
    private String remetente;

    public Transacao(double valor, String tipo, String autor,String remetente) {
        numTransacoes++;
        idTransacao = numTransacoes;
        this.valor = valor;
        this.tipo = tipo;
        this.autor = autor;
        this.remetente = remetente;
    }


}
