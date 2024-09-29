package org.example;


import org.example.Pacote.Cliente;
import org.example.Pacote.Conta;
import org.example.Pacote.PJ;
import org.example.Pacote.Transacao;

import java.io.*;
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
    public static List<Emprestimo> visualizarEmprestimos(int idConta) {
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
                    Emprestimo emprestimo = new Emprestimo(valor, new Date(), idContaArquivo, prazo);
                    emprestimos.add(emprestimo);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }

<<<<<<< HEAD
    return emprestimos;
}
    public void editarConta(){
=======
        return emprestimos;
    }
>>>>>>> 779d0a653cc0747e5ed4671f3004286c7b31bbb1

    //Altera dados da conta. Recebe caminho do arquivo o id da conta e todos dados da conta para serem alterados.

    public static void editarConta(String caminhoArquivo, int idConta, String nome, String telefone, String email, String senha, String documento, String endereco) {
        // Carregar todas as pessoas
        List<Pessoa> pessoas = ProcessarArquivos.carregarPessoas(caminhoArquivo);
        boolean contaEncontrada = false;

        // Percorrer a lista de pessoas e buscar pelo id da conta a ser editada
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Cliente) {
                Cliente cliente = (Cliente) pessoa;
                if (cliente.getId()==(idConta)) {
                    contaEncontrada = true;

                    // Atualiza os dados da pessoa com os novos valores
                    cliente.setNome(nome);
                    cliente.setTelefone(telefone);
                    cliente.setEmail(email);
                    cliente.setSenha(senha);

                    if (cliente instanceof PF) {
                        ((PF) cliente).setCpf(documento);
                        cliente.setEndereco(endereco);
                    } else if (cliente instanceof PJ) {
                        ((PJ) cliente).setCnpj(documento);
                        cliente.setEndereco(endereco);
                    }

                    break; // Sai do loop após encontrar e modificar a conta
                }
            }
        }

        if (!contaEncontrada) {
            System.out.println("Conta com ID " + idConta + " não encontrada.");
            return;
        }

        // Salvar a lista de pessoas com os dados atualizados
        ProcessarArquivos.salvarPessoas(caminhoArquivo, pessoas);
        System.out.println("Conta editada com sucesso!");
    }



    public void excluirConta(){

    }


}
