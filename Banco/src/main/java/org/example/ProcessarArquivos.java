package org.example;
import java.io.*;
import java.util.*;

import org.example.Pacote.Conta;
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
                                pf.getId()+ ";" +
                                pf.getTelefone() + ";" +
                                pf.getEmail() + ";" +
                                pf.getSenha() + ";" +
                                pf.getCpf() + ";" +
                                pf.getEndereco());
                    } else if (pessoa instanceof PJ) {
                        PJ pj = (PJ) pessoa;
                        bw.write("PJ;" + pj.getNome() + ";" +
                                pj.getId()+";" +
                                pj.getTelefone() + ";" +
                                pj.getEmail() + ";" +
                                pj.getSenha() + ";" +
                                pj.getCnpj() +";" +
                                pj.getEndereco());

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
                    // Carrega diretamente como uma instância de PF, incluindo os dados de Cliente
                    PF pf = new PF(dados[1], dados[3], dados[4], dados[5], dados[6], dados[7]);
                    pf.setId(Integer.parseInt(dados[2]));
                    pessoas.add(pf);
                } else if (dados[0].equals("PJ")) {
                    // Carrega diretamente como uma instância de PJ, incluindo os dados de Cliente
                    PJ pj = new PJ(dados[1], dados[3], dados[4], dados[5], dados[6], dados[7]);
                    pj.setId(Integer.parseInt(dados[2]));
                    pessoas.add(pj);
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
    // Método para salvar contas em um arquivo CSV
    public static void salvarContas(String caminhoArquivo, List<Conta> contas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Conta conta : contas) {
                Pessoa titular = conta.getTitular();
                String tipoPessoa = titular instanceof PF ? "PF" : "PJ";

                bw.write(conta.getIdConta() + ";" + conta.getIdTitular() + ";" + tipoPessoa + ";" +
                        titular.getNome() + ";" + titular.getEmail() + ";" +
                        conta.getSaldo());  // Salva o saldo da conta
                bw.newLine();
            }
            System.out.println("Contas salvas com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar contas: " + e.getMessage());
        }
    }

    // Método para carregar contas de um arquivo CSV e associá-las ao titular


        // Método para carregar contas de um arquivo CSV e associá-las ao titular
        public static List<Conta> carregarContas(String caminhoArquivo, List<Pessoa> pessoas) {
            List<Conta> contas = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] dados = linha.split(";");
                    int idConta = Integer.parseInt(dados[0]);
                    int idTitular = Integer.parseInt(dados[1]);
                    String tipoConta = dados[2];  // Tipo de conta, por exemplo: "Corrente", "Poupança"
                    double saldo = Double.parseDouble(dados[3]);

                    // Encontrar a pessoa correspondente ao idTitular
                    Pessoa titular = null;
                    for (Pessoa pessoa : pessoas) {
                        if (pessoa instanceof PF && ((PF) pessoa).getId() == idTitular) {
                            titular = pessoa;
                            break;
                        } else if (pessoa instanceof PJ && ((PJ) pessoa).getId() == idTitular) {
                            titular = pessoa;
                            break;
                        }
                    }

                    // Verifica se encontrou o titular
                    if (titular != null) {
                        Conta conta = null;

                        // Instanciar o tipo correto de conta baseado no tipoConta
                        switch (tipoConta) {
                            case "Corrente":
                                conta = new CCorrente();  // Exemplo para ContaCorrente
                                break;
                            case "Poupança":
                                conta = new CPoupanca();  // Exemplo para ContaPoupança
                                break;
                            case "Salário":
                                conta = new CSalario();  // Exemplo para Conta Salário
                                break;
                            default:
                                System.err.println("Tipo de conta desconhecido: " + tipoConta);
                        }

                        if (conta != null) {
                            conta.setTitular(titular);
                            conta.incrementaSaldo(null, saldo);  // Ajusta o saldo da conta
                            contas.add(conta);
                        }
                    }
                }
                System.out.println("Contas carregadas com sucesso!");
            } catch (IOException e) {
                System.err.println("Erro ao carregar contas: " + e.getMessage());
            }
            return contas;
        }
    }




