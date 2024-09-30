package org.example;

public class CNPJ {
    private String cnpj;

    private CNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public static CNPJ parser(String cnpj) throws CNPJException {
        if (cnpj.matches("^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$")) {

            cnpj = cnpj.replaceAll("[^0-9]", "");

            if (cnpj.length() != 14) {
                throw new CNPJException();
            }

            int soma = 0;
            int[] multiplicadores1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            for (int i = 0; i < 12; i++) {
                soma += Character.getNumericValue(cnpj.charAt(i)) * multiplicadores1[i];
            }
            int digito1 = (soma % 11 < 2) ? 0 : 11 - (soma % 11);
            if (digito1 != Character.getNumericValue(cnpj.charAt(12))) {
                throw new CNPJException();
            }

            soma = 0;
            int[] multiplicadores2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            for (int i = 0; i < 13; i++) {
                soma += Character.getNumericValue(cnpj.charAt(i)) * multiplicadores2[i];
            }
            int digito2 = (soma % 11 < 2) ? 0 : 11 - (soma % 11);
            if (digito2 != Character.getNumericValue(cnpj.charAt(13))) {
                throw new CNPJException();
            }

            return new CNPJ(cnpj);
        }
        throw new CNPJException();
    }
}
