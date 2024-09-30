package org.example;

public class CPF {
    private String cpf;
    private CPF(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public static CPF parser(String cpf) throws CPFException {
        if(cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
            cpf = cpf.replaceAll("[^0-9]", "");

            int digito1=0, posicao=0;
            for(int i=10;i>1;i--){
                digito1 += Character.getNumericValue(cpf.charAt(posicao))*i;
                posicao++;
            }
            digito1 = 11 - digito1%11;
            if(digito1>9)
                digito1=0;
            if(Character.getNumericValue(cpf.charAt(9))!=digito1)
                throw new CPFException();

            int digito2=0;
            posicao=0;
            for(int i=11;i>1;i--){
                digito2 += Character.getNumericValue(cpf.charAt(posicao))*i;
                posicao++;
            }
            digito2 = 11 - digito2%11;
            if(digito2>9)
                digito2=0;
            if(Character.getNumericValue(cpf.charAt(10))!=digito2)
                throw new CPFException();

            return new CPF(cpf);
        }
        throw new CPFException();
    }
}
