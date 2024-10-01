package org.example;

import java.io.IOException;

public class CPoupanca extends Conta {
    public CPoupanca() {
        super();
    }

    @Override
    public boolean transferir(Conta remetente, double valor) throws IOException {
        double valortransfere = valor-valor*0.01;
        return verificaTransferencia(remetente, valor, valortransfere);
    }


}
