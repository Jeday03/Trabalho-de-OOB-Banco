package org.example;

public class CPoupanca extends Conta {
    public CPoupanca() {
        super();
    }

    @Override
    public boolean transferir(Conta remetente, double valor) {
        double valortransfere = valor-valor*0.01;
        return verificaTransferencia(remetente, valor, valortransfere);
    }


}
