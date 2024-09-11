package org.example;


import org.example.Pacote.Transacao;

import java.util.HashMap;
import java.util.List;
import java.util.*;

public class Gerente extends Pessoa {
    private static int numGerentes;
    private int idGerente;
    private static Map<Integer, List<Emprestimo>> emprestimos = new HashMap<>();

    public Gerente(){
        numGerentes++;
        idGerente = numGerentes;
    }

    public static void setEmprestimos(Map<Integer, List<Emprestimo>> emprestimos) {
        Gerente.emprestimos = emprestimos;
    }

    public void aprovarEmprestimo(){

    }
    public void editarConta(){

    }
    public void excluirConta(){

    }
}
