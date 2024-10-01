package org.example;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Gerente extends Pessoa {

    public Gerente(CPF cpf, String senha) {
        super(cpf, senha);
    }

    public boolean editarConta(String cpf, String arquivoCSV, Cliente novosDados) {
        try {
            // Carregar todas as contas do arquivo CSV
            List<Conta> contas = ContaManager.carregarContas(arquivoCSV);

            // Procurar a conta que possui o CPF correspondente
            for (Conta conta : contas) {
                if (conta.getTitular().getCpf().toString().equals(cpf)) {
                    // Atualizar os dados do cliente (titular da conta)
                    Cliente cliente = conta.getTitular();
                    cliente.setNome(novosDados.getNome());
                    cliente.setTelefone(novosDados.getTelefone());
                    cliente.setSenha(novosDados.getSenha());
                    cliente.setDataNascimento(novosDados.getDataNascimento());

                    // Sobrescrever o arquivo CSV com os dados atualizados
                    salvarContasNoArquivo(contas, arquivoCSV);
                    return true; // Sucesso na edição
                }
            }

            System.out.println("Conta não encontrada.");
            return false; // Não encontrou a conta com o CPF informado
        } catch (IOException e) {
            System.err.println("Erro ao editar a conta: " + e.getMessage());
            return false;
        }
    }

    private void salvarContasNoArquivo(List<Conta> contas, String arquivoCSV) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoCSV))) {
            for (Conta conta : contas) {
                // Escrever os dados da conta e do cliente no arquivo CSV
                Cliente cliente = conta.getTitular();
                writer.write(cliente.toString() + "," + conta.getSaldo() + "," + conta.getClass().getSimpleName());
                writer.newLine();
            }
        }
    }
}