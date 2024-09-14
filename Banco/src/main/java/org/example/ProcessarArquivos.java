package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Pacote.PJ;
public class ProcessarArquivos {
    public static void salvarPessoas(String caminhoArquivo, List<Pessoa> pessoas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Pessoa pessoa : pessoas) {
                if(pessoa instanceof PF){
                    PF pf = (PF) pessoa;
                    bw.write("PF;" + pf.getNome() + ";" +
                        pf.getTelefone() + ";" +
                        pf.getEmail() + ";" +
                        pf.getSenha() + ";" +
                        pf.getCpf());
                }else if (pessoa instanceof PJ) {
                    PJ pj = (PJ) pessoa;
                    bw.write("PJ;" + pj.getNome() + ";" +
                            pj.getTelefone() + ";" +
                            pj.getEmail() + ";" +
                            pj.getSenha() + ";" +
                            pj.getCnpj());
                }
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
                 if (dados[0].equals("PF")) {
                     Pessoa pessoa = new PF(dados[1], dados[2], dados[3], dados[4], null, dados[5]);
                     pessoas.add(pessoa);
                 } else if (dados[0].equals("PJ")) {
                     Pessoa pessoa = new PJ(dados[1], dados[2], dados[3], dados[4], null, dados[5]);
                     pessoas.add(pessoa);
                 }
             }
            System.out.println("Dados de pessoas carregados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao carregar pessoas: " + e.getMessage());
        }
        return pessoas;
    }
}

