package org.example.Pacote;

import org.example.CSalario;

import java.util.Date;
import java.util.List;

public class CPoupanca extends CDeposito {
    public CPoupanca() {
        super();
    }

    @Override
    public boolean transferir(Conta remetente, double valor) {
        double valortransfere = valor-valor*0.01;
        if (remetente instanceof CSalario) {
            if (this.getTitular() instanceof PJ) {
                return verificaTransferencia(remetente, valor, valortransfere);
            }
            return false;
        }
        return verificaTransferencia(remetente, valor, valortransfere);
    }

}
