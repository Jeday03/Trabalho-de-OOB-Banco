package org.example;
import java.io.*;
import java.util.*;

import org.example.Pacote.PJ;
public class ProcessarArquivos {
    public static void salvarPessoas(String caminhoArquivo, List<Pessoa> pessoas) {
        Set<String> emailsUnicos = new HashSet<>();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Pessoa pessoa : pessoas) {
                String email = pessoa.getEmail();

                // Verifica se o e-mail já foi adicionado
                if (emailsUnicos.add(email)) {
                    if (pessoa instanceof PF) {
                        PF pf = (PF) pessoa;
                        bw.write("PF;" + pf.getNome() + ";" +
                                pf.getTelefone() + ";" +
                                pf.getEmail() + ";" +
                                pf.getSenha() + ";" +
                                pf.getCpf());
                    } else if (pessoa instanceof PJ) {
                        PJ pj = (PJ) pessoa;
                        bw.write("PJ;" + pj.getNome() + ";" +
                                pj.getTelefone() + ";" +
                                pj.getEmail() + ";" +
                                pj.getSenha() + ";" +
                                pj.getCnpj());
                    }
                    bw.newLine();
                }
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


    public static void salvarLoggin(String caminhoArquivoOriginal, String caminhoArquivoNovo) {
        Set<String> emailsUnicos = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoOriginal));
             BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivoNovo))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 5) { // Verifica se há pelo menos 5 campos (PF ou PJ)
                    String email = dados[3];
                    String senha = dados[4];

                    // Adiciona o e-mail e senha ao Set se o e-mail não estiver presente
                    if (emailsUnicos.add(email)) {
                        bw.write(email + ";" + senha);
                        bw.newLine();
                    }
                }
            }
            System.out.println("Dados de e-mail e senha únicos salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao processar arquivos: " + e.getMessage());
        }
    }

    // Metodo para carregar e-mails e senhas do arquivo de login em um Map
    private static Map<String, String> carregarLogin(String caminhoArquivo) {
        Map<String, String> loginMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 2) { // Verifica se há exatamente 2 campos (email e senha)
                    String email = dados[0];
                    String senha = dados[1];
                    loginMap.put(email, senha);
                }
            }
            System.out.println("Dados de login carregados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados de login: " + e.getMessage());
        }
        return loginMap;
    }

    // Metodo para verificar se o e-mail e a senha conferem
    public static boolean verificarLogin(String caminhoArquivoLogin, String email, String senha) {
        Map<String, String> loginMap = carregarLogin(caminhoArquivoLogin);
        String senhaArmazenada = loginMap.get(email);
        return senhaArmazenada != null && senhaArmazenada.equals(senha);
    }
}

