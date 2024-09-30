package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteManager {

    public List<Cliente> carregarClientes(String arquivo) throws IOException {
        List<Cliente> clientes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Supondo que os campos estão separados por vírgula
                String[] campos = linha.split(",");

                if (campos.length == 5) { // Verifica se todos os campos estão presentes
                    String nome = campos[0].trim();
                    Telefone telefone = Telefone.parser(campos[1].trim());
                    String senha = campos[2].trim();
                    DataNascimento dataNascimento = DataNascimento.parser(campos[3].trim());
                    CPF cpf = CPF.parser(campos[4].trim());

                    Cliente cliente = new Cliente(nome, telefone, senha, dataNascimento, cpf) {};
                    clientes.add(cliente);
                }
            }
        } catch (Exception e) {
            throw new IOException("Erro ao carregar clientes: " + e.getMessage());
        }

        return clientes;
    }
}
