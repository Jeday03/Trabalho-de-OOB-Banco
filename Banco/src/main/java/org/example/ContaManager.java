package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContaManager {

    public static List<Conta> carregarContas(String arquivo) throws IOException {
        List<Conta> contas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Supondo que os campos do cliente e da conta estão separados por vírgula
                String[] campos = linha.split(",");

                if (campos.length >= 7) { // Verifica se todos os campos do cliente e da conta estão presentes
                    String nome = campos[0].trim();
                    Telefone telefone = Telefone.parser(campos[1].trim());
                    String senha = campos[2].trim();
                    DataNascimento dataNascimento = DataNascimento.parser(campos[3].trim());
                    CPF cpf = CPF.parser(campos[4].trim());
                    double saldo = Double.parseDouble(campos[5].trim());
                    String subclasse = campos[6].trim();

                    // Cria o cliente
                    Cliente cliente = new Cliente(nome, telefone, senha, dataNascimento, cpf) {};


                    Conta conta=null;
                    if(subclasse.equals("CCorrente"))
                        conta = new CCorrente();

                    if(subclasse.equals("CPoupanca"))
                        conta = new CPoupanca();

                    conta.setSaldo(saldo);
                    conta.setTitular(cliente);
                    contas.add(conta);

                }
            }
        } catch (Exception e) {
            throw new IOException("Erro ao carregar contas: " + e.getMessage());
        }

        return contas;
    }
    public static void salvarContasNoArquivo(List<Conta> contas) throws IOException {
        String arquivoCSV="contas.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoCSV))) {
            // Percorrer todas as contas e salvar no formato correto
            for (Conta conta : contas) {
                Cliente cliente = conta.getTitular();
                if (cliente != null) {
                    // Gravação no arquivo CSV, separando por vírgulas
                    writer.write(cliente.toString() + "," + conta.getSaldo() + "," + conta.getClass().getSimpleName());
                    writer.newLine(); // Avançar para a próxima linha
                }
            }
        } catch (IOException e) {
            throw new IOException("Erro ao salvar as contas no arquivo: " + e.getMessage());
        }
    }
}
