package org.example;
import java.util.ArrayList;
import java.util.List;

public class SistemaBancarioCSV {
    private static final String CAMINHO_PESSOAS = "pessoas.csv";
    private List<Pessoa> listaPessoas = new ArrayList<>();

    //Funcao retorna lista de pessoas carregada do arquivo. Chamar passando nome do arquivo.
    public void processarPessoas(){
        ProcessarArquivos.carregarPessoas(CAMINHO_PESSOAS);
    }
    //funcao salva pessoas em um arquivo, sem retorno.
    public void salvarPessoas(){
        ProcessarArquivos.salvarPessoas(CAMINHO_PESSOAS,listaPessoas);
    }
}
