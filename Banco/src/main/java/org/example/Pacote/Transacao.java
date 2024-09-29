package org.example.Pacote;
import java.io.FileWriter;
import java.io.IOException;
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

    public void salvarEmCSV() {
        String arquivo = "transacoes.csv";
        try (FileWriter writer = new FileWriter(arquivo, true)) {  // true para adicionar ao arquivo existente
            writer.append(String.format("%d,%.2f,%s,%s,%s,%s\n",
                    idtransacao,valor,this.getData(),tipo,autor,remetente));  // Salvando o id da conta associada
            System.out.println("Dados da transação salvos no CSV.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo CSV: " + e.getMessage());
        }
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
