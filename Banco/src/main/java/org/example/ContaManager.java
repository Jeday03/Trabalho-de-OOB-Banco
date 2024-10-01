package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContaManager {

    public List<Conta> carregarContas(String arquivo) throws IOException {
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

                    conta.setTitular(cliente);
                    contas.add(conta);

                }
            }
        } catch (Exception e) {
            throw new IOException("Erro ao carregar contas: " + e.getMessage());
        }

        return contas;
    }
}
