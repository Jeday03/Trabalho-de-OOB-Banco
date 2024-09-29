package org.example;

import org.example.Pacote.Conta;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Emprestimo {
    private static int numEmprestimos;
    private int idEmprestimo;
    private double valor;
    private boolean situacao;
    private Date data;
    private int prazo; //prazo em meses para pagamento
    private double taxaDeJuros;
    private int idConta;


    public Emprestimo(double valor, Date data,int idConta, int prazo) {
        numEmprestimos ++;
        this.idEmprestimo = numEmprestimos;
        this.valor = valor;
        this.situacao = false;
        this.data = data;
        this.taxaDeJuros = 10.5;
        this.idConta = idConta;
        this.prazo = prazo;
    }
    public double calcularParcelas(){
        double taxaMensal=taxaDeJuros/12;
        return (valor*taxaMensal)/(1 - Math.pow(1 + taxaMensal, -prazo));
    }
    public double calcularValorTotal() {
        double taxaMensal = taxaDeJuros / 12;
        return valor * Math.pow(1 + taxaMensal, prazo);
    }
    public void salvarEmCSV() {
        String arquivo = "emprestimos.csv";
        try (FileWriter writer = new FileWriter(arquivo, true)) {  // true para adicionar ao arquivo existente
            writer.append(String.format("%d,%.2f,%d,%b,%s\n",
                    idEmprestimo, valor, prazo, situacao, idConta));  // Salvando o id da conta associada
            System.out.println("Dados do empréstimo salvos no CSV.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo CSV: " + e.getMessage());
        }
    }


    public void aprovar() {
        situacao=true;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public double getValor() {
        return valor;
    }

    public int getPrazo() {
        return prazo;
    }

    public Boolean getSituacao() {
        return situacao;
    }

}
