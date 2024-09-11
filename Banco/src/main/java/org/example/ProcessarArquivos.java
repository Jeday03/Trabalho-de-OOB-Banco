package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ProcessarArquivos {
    public static void salvarPessoas(String caminhoArquivo, List<Pessoa> pessoas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Pessoa pessoa : pessoas) {
                bw.write(pessoa.getNome() + ";" +
                        pessoa.getTelefone() + ";" +
                        pessoa.getEmail() + ";" +
                        pessoa.getSenha());
                bw.newLine();
            }
            System.out.println("Dados de pessoas salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar pessoas: " + e.getMessage());
        }
    }
    public static List<Pessoa> carregarPessoas(String caminhoArquivo) {
        List<Pessoa> pessoas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Pessoa pessoa = new Pessoa(dados[0], dados[1], dados[2], dados[3]); // Presume que você tenha um construtor adequado
                pessoas.add(pessoa);
            }
            System.out.println("Dados de pessoas carregados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao carregar pessoas: " + e.getMessage());
        }
        return pessoas;
    }
}

