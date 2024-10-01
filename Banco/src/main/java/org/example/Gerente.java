package org.example;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Gerente extends Pessoa {
    public Gerente(CPF cpf, String senha) throws IOException {
        super(cpf, senha);
        List<Conta> contas = ContaManager.carregarContas("contas.txt");

    }
    //Recebe os dados de um cliente e sobreescreve no arquivo com o mesmo cpf.
    public static boolean editarConta(String cpf, Cliente novosDados) {
        String arquivoCSV = "contas.txt";

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
                    salvarContasNoArquivo(contas);
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
    //recebe um cpf e excui a conta associada se o saldo for igual a 0.
    public boolean excluirConta(String cpf) throws IOException {
        String arquivoCSV = "contas.txt";
        try {
            // Carregar todas as contas do arquivo CSV
            List<Conta> contas = ContaManager.carregarContas(arquivoCSV);

            // Procurar a conta que possui o CPF correspondente
            for (Conta conta : contas) {
                if (conta.getTitular().getCpf().toString().equals(cpf)) {
                    // Verificar se o saldo da conta é igual a 0
                    if (conta.getSaldo() == 0) {
                        // Remover a conta da lista
                        contas.remove(conta);
                        // Sobrescrever o arquivo CSV com as contas atualizadas
                        salvarContasNoArquivo(contas);

                        return true; // Conta removida com sucesso
                    } else {
                        System.out.println("Não é possível remover a conta. O saldo deve ser igual a 0.");
                        return false; // Conta não pode ser removida se o saldo não for 0
                    }
                }
            }

            System.out.println("Conta não encontrada.");
            return false; // Não encontrou a conta com o CPF informado
        } catch (IOException e) {
            System.err.println("Erro ao excluir a conta: " + e.getMessage());
            return false;
        }
    }
    // Método para alterar o saldo de uma conta com base no CPF
    public static void mudarSaldo(String cpf, double novoSaldo) throws IOException {
        String arquivoCSV = "contas.txt";
        List<Conta> contas = ContaManager.carregarContas(arquivoCSV);
        if (contas == null) {
            contas = ContaManager.carregarContas("contas.txt");  // Certifique-se de que o arquivo correto seja carregado
        }

        // Variável para verificar se o CPF foi encontrado
        boolean cpfEncontrado = false;

        // Itera sobre as contas para encontrar a conta com o CPF correspondente
        for (Conta conta : contas) {
            Cliente titular = conta.getTitular();
            if (titular != null && titular.getCpfString().equals(cpf)) {
                conta.setSaldo(novoSaldo);
                cpfEncontrado = true;

                // Salva todas as contas de volta no arquivo CSV
                ContaManager.salvarContasNoArquivo(contas);
                break;
            }
        }

        if (!cpfEncontrado) {
            throw new IOException("CPF não encontrado no arquivo.");
        }



        // Atualiza a lista `contas` após salvar
        contas = ContaManager.carregarContas("contas.txt");
    }

    private static void salvarContasNoArquivo(List<Conta> contas) throws IOException {
        String arquivoCSV = "contas.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoCSV, false))) {
            for (Conta conta : contas) {
                // Escrever os dados da conta e do cliente no arquivo CSV
                Cliente cliente = conta.getTitular();
                writer.write(cliente.toString() + "," + conta.getSaldo() + "," + conta.getClass().getSimpleName());
                writer.newLine();
            }

        }
    }
}