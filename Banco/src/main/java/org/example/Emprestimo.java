package org.example;

public class Emprestimo {
    private static int numEmprestimos;
    private int idEmprestimo;
    private double valor;
    private boolean situacao;

    public Emprestimo(double valor, boolean situacao) {
        numEmprestimos ++;
        this.idEmprestimo = numEmprestimos;
        this.valor = valor;
        this.situacao = situacao;

    }






}
