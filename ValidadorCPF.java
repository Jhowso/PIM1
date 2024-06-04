public class ValidadorCPF {
    
    public static boolean validarCPF(String cpf) {
        // Remover caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");
        
        // Verificar se tem 11 dígitos
        if (cpf.length() != 11)
            return false;
        
        // Verificar se todos os dígitos são iguais
        boolean todosDigitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosDigitosIguais = false;
                break;
            }
        }
        if (todosDigitosIguais)
            return false;
        
        // Calculo do primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);
        
        // Verificação do primeiro dígito verificador
        if ((cpf.charAt(9) - '0') != digitoVerificador1)
            return false;
        
        // Cálculo do segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);
        
        // Verificação do segundo dígito verificador
        return (cpf.charAt(10) - '0') == digitoVerificador2;
    }
    
    public static void main(String[] args) {
        String cpf = "123.456.789-09"; // Exemplo de CPF
        if (validarCPF(cpf)) {
            System.out.println("CPF válido!");
        } else {
            System.out.println("CPF inválido!");
        }
    }
}
