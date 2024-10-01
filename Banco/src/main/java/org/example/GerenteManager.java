package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GerenteManager {
    private Gerente gerente; // Apenas um único gerente

    public void carregarGerente(String arquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha = reader.readLine(); // Lê apenas a primeira linha
            if (linha != null) {
                String[] campos = linha.split(","); // Supondo que o formato é "cpf,senha"

                if (campos.length >= 2) { // Verifica se os campos estão presentes
                    CPF cpf = CPF.parser(campos[0].trim()); // Ajuste conforme a implementação da classe CPF
                    String senha = campos[1].trim();

                    // Cria o gerente
                    gerente = new Gerente(cpf, senha);
                }
            }
        } catch (Exception e) {
            throw new IOException("Erro ao carregar gerente: " + e.getMessage());
        }
    }

    public Gerente getGerente() {
        return gerente;
    }
}
