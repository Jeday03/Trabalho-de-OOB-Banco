package org.example;


import org.example.Pacote.Conta;
import org.example.Pacote.Transacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class Gerente extends Pessoa {
    private static int numGerentes;
    private int idGerente;
    private static Map<Integer, List<Emprestimo>> emprestimos = new HashMap<>();
    private static final String ARQUIVO_EMPRESTIMOS = "emprestimos.csv";

    public Gerente(){
        numGerentes++;
        idGerente = numGerentes;
    }

    public static void setEmprestimos(Map<Integer, List<Emprestimo>> emprestimos) {
        Gerente.emprestimos = emprestimos;
    }

    // Recebe um IdEmprestimo e aprova o emprestimo mudando no arquivo.
    public void aprovarEmprestimo(int idEmprestimo) {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_EMPRESTIMOS))) {
            String linha;
            boolean emprestimoEncontrado = false;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);

                // Verifica se é o empréstimo correto
                if (id == idEmprestimo) {
                    emprestimoEncontrado = true;
                    boolean situacao = Boolean.parseBoolean(dados[3]);

                    if (situacao) {
                        System.out.println("Empréstimo já foi aprovado.");
                    } else {
                        // Marca o empréstimo como aprovado
                        dados[3] = "true";
                        System.out.println("Empréstimo ID " + idEmprestimo + " aprovado com sucesso.");
                    }
                }

                // Reconstrói a linha e adiciona à lista de linhas
                linhas.add(String.join(",", dados));
            }

            if (!emprestimoEncontrado) {
                System.out.println("Empréstimo com ID " + idEmprestimo + " não encontrado.");
                return;
            }

            // Reescreve o arquivo com os dados atualizados
            try (FileWriter writer = new FileWriter(ARQUIVO_EMPRESTIMOS, false)) {
                for (String novaLinha : linhas) {
                    writer.write(novaLinha + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo CSV: " + e.getMessage());
        }
    }

    // A partir de um IdConta retorna lista com todos emprestimos associados a esta conta.
    public List<Emprestimo> visualizarEmprestimos(int idConta) {
        List<Emprestimo> emprestimos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_EMPRESTIMOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                int idEmprestimo = Integer.parseInt(dados[0]);
                double valor = Double.parseDouble(dados[1]);
                int prazo = Integer.parseInt(dados[2]);
                boolean situacao = Boolean.parseBoolean(dados[3]);
                int idContaArquivo = Integer.parseInt(dados[4]);  // Id da conta associado

                // Verifica se o empréstimo é da conta fornecida
                if (idContaArquivo == idConta) {
                    // Substitua 'null' pelo objeto 'Pessoa' apropriado (pode ser um cliente) ou obtenha a pessoa associada de outra forma
                    Emprestimo emprestimo = new Emprestimo(valor, new Date(), null, idContaArquivo, prazo);
                    emprestimos.add(emprestimo);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }

        return emprestimos;
    }
    public void editarConta(){

    }
    public void excluirConta(){

    }


}
