package pim1;
import java.util.Scanner;
public class PIMDosCria {
        public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    String cpf, opcao, horario, secao, frisaString, assentoA, assentoB, assentoCamarote, assentoFrisa, assentoBalcao, camaroteString;
    boolean cpfInvalido = true, menuPrincipal = true, comprar = false, opcaoInvalida = false, sair = false, estatistica = false, imprimir = false, platAOcupado[][][] = new boolean [9][5][5], platBOcupado[][][] = new boolean[9][10][10], camarotesOcupado[][][] = new boolean[9][5][10], frisasOcupado[][][] = new boolean[9][6][5], balcaoNobreOcupado[][][] = new boolean[9][10][5];
    int num, maisVendida = 0, precoplatA = 40, precoplatB = 60, precoCamarote = 80, precoFrisa = 120, precoBalcaonobre = 250,totalVendido = 0, totalDisponivel = 0, secaoInt, assentoAint, assentoBint, assentoCamaroteint, assentoFrisaint, assentoBalcaoint, contador = 1, horarioInt, camaroteInt, frisaInt, colunaA, linhaA, linhaB, colunaB, camaroteEscolhido, posicaoEscolhida, posicaoFrisa, frisaEscolhida, linhaBalcao, colunaBalcao;
    int pesos1 [] = {10, 9, 8, 7, 6, 5, 4, 3, 2}, pesos2 [] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2}, vendasPorPeca [] = new int[3], receitaPorPeca [] = new int[3], platA [][][] = new int [9][5][5], platB [][][] = new int[9][10][10], frisas [][][] = new int [9][6][5], camarotes [][][] = new int[9][5][10], balcaoNobre [][][] = new int[9][10][5];
    

      // Preenche a matriz 5x5 platA com elementos de 1 à 25, em 5 fileiras e 5 colunas e as exibe no final
    for(int peca = 0; peca < 9; peca++)
    {
        contador = 1;
        for(int linha = 0; linha < 5; linha++)
        {
            for(int coluna = 0; coluna < 5; coluna++)
            {
            platA [peca][linha][coluna] = contador;
            contador++;
            }
        }
    }    
    // Preenche a matriz 10x10 platB com elementos de 1 à 100, em 10 fileiras e 10 colunas e as exibe no final.
    contador = 1;
    for(int peca = 0; peca < 9; peca++)
    {
        contador = 1;
        for(int linha = 0; linha < 10; linha++)
        {
        
            for(int coluna = 0; coluna < 10; coluna++)
            {
            platB [peca][linha][coluna] = contador;
            contador++;
            }
        }
    }
   // Preenche a matriz frisa com elementos de 1 à 5 para cada frisa, sendo 6 frisas no total e as exibe no final.
   for(int peca = 0; peca < 9; peca++)
        for(int frisa = 0; frisa < 6; frisa++)
        {
       contador = 1;
            for(int posicao = 0; posicao < 5; posicao++)
            {
            frisas [peca][frisa][posicao] = contador;
            contador++;
            }          
   }
   // Preenche a matriz camarote com elementos de 1 à 10 para cada camarote, sendo 5 camarotes no total e os exibe no final.
   for(int peca = 0; peca < 9; peca++)
    {
        for(int camarote = 0; camarote < 5; camarote++)
        {           
        contador = 1;
            for(int posicao = 0; posicao < 10; posicao++)
            {
            camarotes [peca][camarote][posicao] = contador;
            contador++;
            }
        }
    }
   contador = 1;
   // Preenche a matriz balcaoNobre com 50 elementos, ordenados em 10 linhas e 5 colunas.
    for(int peca = 0; peca < 9; peca++)
    {
        contador = 1;
        for(int linha = 0; linha < 10; linha++)
        {
            for(int coluna = 0; coluna < 5; coluna++)
            {
            balcaoNobre [peca][linha][coluna] = contador;
            contador++;
            }
        }
   }
  
                while (cpfInvalido) 
                {
    System.out.print("Digite seu CPF (somente números ou em formato xxx.xxx.xxx-xx): ");
    cpf = ler.nextLine();
    cpf = cpf.replace(".", "").replace("-", "");
    
    if (cpf.length() != 11 || !cpf.matches("\\d+")) {
        System.out.println("CPF inválido. Por favor, digite novamente.");
    } else {
        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) 
        {
            System.out.println("CPF inválido. Por favor, digite novamente.");
            continue;
        }

        try {
            int soma1 = 0;
            int soma2 = 0;

            // Cálculo do primeiro dígito verificador
            for (int i = 0; i < 9; i++) 
            {
                num = Integer.parseInt(cpf.substring(i, i + 1));
                soma1 += num * pesos1[i];
                soma2 += num * pesos2[i];
            }

            int digito1 = soma1 % 11 < 2 ? 0 : 11 - (soma1 % 11);
            soma2 += digito1 * pesos2[9];

            // Cálculo do segundo dígito verificador
            int digito2 = soma2 % 11 < 2 ? 0 : 11 - (soma2 % 11);

            // Verifica se os dígitos verificadores calculados são iguais aos fornecidos no CPF
            if (cpf.endsWith(String.valueOf(digito1) + String.valueOf(digito2))) 
            {
                System.out.println("CPF válido.");
                cpfInvalido = false;
            } else 
            {
                System.out.println("CPF inválido. Por favor, digite novamente.");
            }
                } catch (NumberFormatException e) 
                        {
                System.out.println("Erro ao calcular os dígitos verificadores. Por favor, tente novamente.");
                        }
                    }
                }
                
                while(menuPrincipal)
                {
                
                    System.out.printf("Selecione uma opção:\n1. Comprar ingresso. \n2. Imprimir ingresso. \n3. Estatística de Vendas.\n4. Sair do programa\n");
                    opcao = ler.nextLine();
                    switch(opcao.toLowerCase())
                    {
                 case "1":
                 case "1.":
                 case "comprar":
                    comprar = true;
                    opcaoInvalida = false;
                    menuPrincipal = false;
                    break;
                case "2":
                case "2.":
                case "imprimir ingresso":
                    System.out.println("Imprimir ingresso");
                    imprimir = true;
                    opcaoInvalida = false;
                    menuPrincipal = false;
                    break;
                case "3":
                case "3.":
                case "estatisticas de venda":
                    estatistica = true;
                    opcaoInvalida = false;
                    menuPrincipal = false;
                    break;
                case "4":
                case "4.":
                case "sair do programa":
                    System.out.println("Sair do programa.");
                    sair = true;
                    menuPrincipal = false;
                default:
                    System.out.println("Opção inválida, favor selecione outra.");
                    opcaoInvalida = true;
                    menuPrincipal = true;
                    }

                while (comprar) {
                    System.out.printf("Escolha o horário de sua preferência:\nManhã:\n1. Peça 1 - 08:00\n2. Peça 2 - 09:30\n3. Peça 3 - 11:00\nTarde:\n4. Peça 1 - 13:00\n5. Peça 2 - 15:30\n6. Peça 3 - 17:00\nNoite:\n7. Peça 1 - 18:30\n8. Peça 2 - 20:00\n9. Peça 3 - 21:30\n");
                    do {
                        horario = ler.nextLine();
                        horarioInt = Integer.parseInt(horario);
                        if (horarioInt >= 1 && horarioInt <= 9) {
                            opcaoInvalida = false;
                            System.out.printf("Escolha sua seção de preferência:\n1. Plateia A: R$ 40,00\n2. Plateia B: R$ 60,00\n3. Camarote: R$ 80,00\n4. Frisa: R$ 120,00\n5. Balcão Nobre: R$ 250,00\n");
                            do {
                                secao = ler.nextLine();
                                secaoInt = Integer.parseInt(secao);
                                switch (secaoInt) {
                                    case 1:
                                        System.out.println("Você escolheu Plateia A.");
                                        System.out.println("Assentos disponíveis:");
                                        for (int linha = 0; linha < 5; linha++) {
                                            for (int coluna = 0; coluna < 5; coluna++) {
                                                System.out.printf("%2d ", platA[horarioInt - 1][linha][coluna]);
                                            }
                                            System.out.println();
                                        }
                                        System.out.println("Escolha um assento (informe o número): ");
                                        do {
                                            assentoA = ler.nextLine();
                                            assentoAint = Integer.parseInt(assentoA);
                                            if (assentoAint > 0 && assentoAint < 26) {
                                                linhaA = (assentoAint - 1) / 5;
                                                colunaA = (assentoAint - 1) % 5;
                                                if (platAOcupado[horarioInt - 1][linhaA][colunaA]) {
                                                    System.out.println("Assento já ocupado. Tente novamente.");
                                                } else {
                                                    platAOcupado[horarioInt - 1][linhaA][colunaA] = true;
                                                    System.out.println("Assento reservado com sucesso!");
                                                    comprar = false;
                                                    menuPrincipal = true;
                                                }
                                                opcaoInvalida = false;
                                            } else {
                                                System.out.println("Opção inválida. Tente novamente.");
                                                opcaoInvalida = true;
                                            }
                                        } while (opcaoInvalida);
                                        break;
                                    case 2:
                                        System.out.println("Você escolheu Plateia B.");
                                        System.out.println("Assentos disponíveis:");
                                        for (int linha = 0; linha < 10; linha++) {
                                            for (int coluna = 0; coluna < 10; coluna++) {
                                                System.out.printf("%2d ", platB[horarioInt - 1][linha][coluna]);
                                            }
                                            System.out.println();
                                        }
                                        System.out.println("Escolha um assento (informe o número): ");
                                        do {
                                            assentoB = ler.nextLine();
                                            assentoBint = Integer.parseInt(assentoB);
                                            if (assentoBint > 0 && assentoBint < 101) {
                                                linhaB = (assentoBint - 1) / 10;
                                                colunaB = (assentoBint - 1) % 10;
                                                if (platBOcupado[horarioInt - 1][linhaB][colunaB]) {
                                                    System.out.println("Assento já ocupado. Tente novamente.");
                                                } else {
                                                    platBOcupado[horarioInt - 1][linhaB][colunaB] = true;
                                                    System.out.println("Assento reservado com sucesso!");
                                                    comprar = false;
                                                    menuPrincipal = true;
                                                }
                                                opcaoInvalida = false;
                                            } else {
                                                System.out.println("Opção inválida. Tente novamente.");
                                                opcaoInvalida = true;
                                            }
                                        } while (opcaoInvalida);
                                        break;
                                    case 3:
                                        System.out.println("Você escolheu Camarote.");
                                        System.out.println("Camarotes disponíveis:");
                                        for (int camarote = 0; camarote < 5; camarote++) {
                                            for (int posicao = 0; posicao < 10; posicao++) {
                                                System.out.printf("%2d ", camarotes[horarioInt - 1][camarote][posicao]);
                                            }
                                            System.out.println();
                                        }
                                        System.out.println("Escolha um camarote (1-5): ");
                                        camaroteString = ler.nextLine();
                                        camaroteInt = Integer.parseInt(camaroteString);
                                        camaroteEscolhido = camaroteInt - 1;
                                        if (camaroteInt >= 1 && camaroteInt <= 5) {
                                            System.out.println("Escolha um assento no camarote (1-10): ");
                                            do {
                                                assentoCamarote = ler.nextLine();
                                                assentoCamaroteint = Integer.parseInt(assentoCamarote);
                                                if (assentoCamaroteint >= 1 && assentoCamaroteint <= 10) {
                                                    posicaoEscolhida = assentoCamaroteint - 1;
                                                    if (camarotesOcupado[horarioInt - 1][camaroteEscolhido][posicaoEscolhida]) {
                                                        System.out.println("Assento já ocupado. Tente novamente.");
                                                    } else {
                                                        camarotesOcupado[horarioInt - 1][camaroteEscolhido][posicaoEscolhida] = true;
                                                        System.out.println("Assento reservado com sucesso!");
                                                        comprar = false;
                                                        menuPrincipal = true;
                                                    }
                                                    opcaoInvalida = false;
                                                } else {
                                                    System.out.println("Opção inválida. Tente novamente.");
                                                    opcaoInvalida = true;
                                                }
                                            } while (opcaoInvalida);
                                        } else {
                                            System.out.println("Camarote inválido. Tente novamente.");
                                            opcaoInvalida = true;
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Você escolheu Frisa.");
                                        System.out.println("Frisas disponíveis:");
                                        for (int frisa = 0; frisa < 6; frisa++) {
                                            for (int posicao = 0; posicao < 5; posicao++) {
                                                System.out.printf("%2d ", frisas[horarioInt - 1][frisa][posicao]);
                                            }
                                            System.out.println();
                                        }
                                        System.out.println("Escolha uma frisa (1-6): ");
                                        frisaString = ler.nextLine();
                                        frisaInt = Integer.parseInt(frisaString);
                                        frisaEscolhida = frisaInt - 1;
                                        if (frisaInt >= 1 && frisaInt <= 6) {
                                            System.out.println("Escolha um assento na frisa (1-5): ");
                                            do {
                                                assentoFrisa = ler.nextLine();
                                                assentoFrisaint = Integer.parseInt(assentoFrisa);
                                                if (assentoFrisaint >= 1 && assentoFrisaint <= 5) {
                                                    posicaoFrisa = assentoFrisaint - 1;
                                                    if (frisasOcupado[horarioInt - 1][frisaEscolhida][posicaoFrisa]) {
                                                        System.out.println("Assento já ocupado. Tente novamente.");
                                                    } else {
                                                        frisasOcupado[horarioInt - 1][frisaEscolhida][posicaoFrisa] = true;
                                                        System.out.println("Assento reservado com sucesso!");
                                                        menuPrincipal = true;
                                                        comprar = false;
                                                    }
                                                    opcaoInvalida = false;
                                                } else {
                                                    System.out.println("Opção inválida. Tente novamente.");
                                                    opcaoInvalida = true;
                                                }
                                            } while (opcaoInvalida);
                                        } else {
                                            System.out.println("Frisa inválida. Tente novamente.");
                                            opcaoInvalida = true;
                                        }
                                        break;
                                    case 5:
                                        System.out.println("Você escolheu Balcão Nobre.");
                                        System.out.println("Assentos disponíveis:");
                                        for (int linha = 0; linha < 10; linha++) {
                                            for (int coluna = 0; coluna < 5; coluna++) {
                                                System.out.printf("%2d ", balcaoNobre[horarioInt - 1][linha][coluna]);
                                            }
                                            System.out.println();
                                        }
                                        System.out.println("Escolha um assento (informe o número): ");
                                        do {
                                            assentoBalcao = ler.nextLine();
                                            assentoBalcaoint = Integer.parseInt(assentoBalcao);
                                            if (assentoBalcaoint > 0 && assentoBalcaoint < 51) {
                                                linhaBalcao = (assentoBalcaoint - 1) / 5;
                                                colunaBalcao = (assentoBalcaoint - 1) % 5;
                                                if (balcaoNobreOcupado[horarioInt - 1][linhaBalcao][colunaBalcao]) {
                                                    System.out.println("Assento já ocupado. Tente novamente.");
                                                } else {
                                                    balcaoNobreOcupado[horarioInt - 1][linhaBalcao][colunaBalcao] = true;
                                                    System.out.println("Assento reservado com sucesso!");
                                                    menuPrincipal = true;
                                                    comprar = false;
                                                }
                                                opcaoInvalida = false;
                                            } else {
                                                System.out.println("Opção inválida. Tente novamente.");
                                                opcaoInvalida = true;
                                            }
                                        } while (opcaoInvalida);
                                        break;
                                    default:
                                        System.out.println("Opção inválida, favor selecione outra.");
                                        opcaoInvalida = true;
                                        break;
                                }
                            } while (opcaoInvalida);
                        } else {
                            System.out.println("Opção inválida, favor selecione outra.");
                            opcaoInvalida = true;
                        }
                    } while (opcaoInvalida);
                }



                // Estatísticas de venda
                while (estatistica)
                 {
            
                // Somar vendas e receitas de cada peça
                for (int i = 0; i < 9; i++) 
                {
                    // Peça 1 (horários 1, 4, 7)
                    if (i == 0 || i == 3 || i == 6) 
                    {
                        for (int j = 0; j < 5; j++) 
                        {
                            for (int k = 0; k < 5; k++) 
                            {
                                if (platAOcupado[i][j][k])
                                {
                                    vendasPorPeca[0]++;
                                    receitaPorPeca[0] += precoplatA;
                                }
                            }
                        }
                        for (int j = 0; j < 10; j++) 
                        {
                            for (int k = 0; k < 10; k++) 
                            {
                                if (platBOcupado[i][j][k])
                                {
                                    vendasPorPeca[0]++;
                                    receitaPorPeca[0] += precoplatB;
                                }
                            }
                        }
                        for (int j = 0; j < 5; j++) 
                        {
                            for (int k = 0; k < 10; k++) 
                            {
                                if (camarotesOcupado[i][j][k])
                                {
                                    vendasPorPeca[0]++;
                                    receitaPorPeca[0] += precoCamarote;
                                }
                            }
                        }
                        for (int j = 0; j < 6; j++) 
                        {
                            for (int k = 0; k < 5; k++) 
                            {
                                if (frisasOcupado[i][j][k])
                                {
                                    vendasPorPeca[0]++;
                                    receitaPorPeca[0] += precoFrisa;
                                }
                            }
                        }
                        for (int j = 0; j < 10; j++) 
                        {
                            for (int k = 0; k < 5; k++) 
                            {
                                if (balcaoNobreOcupado[i][j][k])
                                {
                                    vendasPorPeca[0]++;
                                    receitaPorPeca[0] += precoBalcaonobre;
                                }
                            }
                        }
                    }
            
                    // Peça 2 (horários 2, 5, 8)
                    if (i == 1 || i == 4 || i == 7) 
                    {
                        for (int j = 0; j < 5; j++) 
                        {
                            for (int k = 0; k < 5; k++) 
                            {
                                if (platAOcupado[i][j][k])
                                {
                                    vendasPorPeca[1]++;
                                    receitaPorPeca[1] += precoplatA;
                                }
                            }
                        }
                        for (int j = 0; j < 10; j++) 
                        {
                            for (int k = 0; k < 10; k++) 
                            {
                                if (platBOcupado[i][j][k])
                                {
                                    vendasPorPeca[1]++;
                                    receitaPorPeca[1] += precoplatB;
                                }
                            }
                        }
                        for (int j = 0; j < 5; j++) 
                        {
                            for (int k = 0; k < 10; k++) 
                            {
                                if (camarotesOcupado[i][j][k])
                                {
                                    vendasPorPeca[1]++;
                                    receitaPorPeca[1] += precoCamarote;
                                }
                            }
                        }
                        for (int j = 0; j < 6; j++) 
                        {
                            for (int k = 0; k < 5; k++) 
                            {
                                if (frisasOcupado[i][j][k])
                                {
                                    vendasPorPeca[1]++;
                                    receitaPorPeca[1] += precoFrisa;
                                }
                            }
                        }
                        for (int j = 0; j < 10; j++) 
                        {
                            for (int k = 0; k < 5; k++) 
                            {
                                if (balcaoNobreOcupado[i][j][k])
                                {
                                    vendasPorPeca[1]++;
                                    receitaPorPeca[1] += precoBalcaonobre;
                                }
                            }
                        }
                    }
            
                    // Peça 3 (horários 3, 6, 9)
                    if(i == 2 || i == 5 || i == 8)
                    {
                        for (int j = 0; j < 5; j++)
                        {
                            for (int k = 0; k < 5; k++)
                            {
                                if (platAOcupado[i][j][k])
                                {
                                    vendasPorPeca[2]++;
                                    receitaPorPeca[2] += precoplatA;
                                }
                            }
                        }
                        for (int j = 0; j < 10; j++) 
                        {
                            for (int k = 0; k < 10; k++) 
                            {
                                if (platBOcupado[i][j][k])
                                {
                                    vendasPorPeca[2]++;
                                    receitaPorPeca[2] += precoplatB;
                                }
                            }
                        }
                        for (int j = 0; j < 5; j++) 
                        {
                            for (int k = 0; k < 10; k++) 
                            {
                                if (camarotesOcupado[i][j][k])
                                {
                                    vendasPorPeca[2]++;
                                    receitaPorPeca[2] += precoCamarote;
                                }
                            }
                        }
                        for (int j = 0; j < 6; j++) 
                        {
                            for (int k = 0; k < 5; k++) 
                            {
                                if (frisasOcupado[i][j][k])
                                {
                                    vendasPorPeca[2]++;
                                    receitaPorPeca[2] += precoFrisa;
                                }
                            }
                        }
                        for (int j = 0; j < 10; j++) 
                        {
                            for (int k = 0; k < 5; k++) 
                            {
                                if (balcaoNobreOcupado[i][j][k])
                                {
                                    vendasPorPeca[2]++;
                                    receitaPorPeca[2] += precoBalcaonobre;
                                }
                            }
                        }
                    }
                }
            
                // Determinar a peça mais vendida
                for (int i = 1; i < 3; i++) 
                {
                    if (vendasPorPeca[i] > vendasPorPeca[maisVendida]) 
                    {
                        maisVendida = i;
                    }
                }
            
                // Exibir estatísticas
                System.out.println("Estatísticas de Vendas:");
                for (int i = 0; i < 3; i++) 
                {
                    System.out.println("Peça " + (i + 1) + " - Vendas: " + vendasPorPeca[i] + " ingressos, Receita: R$" + receitaPorPeca[i]);
                }
                System.out.println("A peça mais vendida foi a Peça " + (maisVendida + 1) + " com " + vendasPorPeca[maisVendida] + " ingressos vendidos.");
            
                estatistica = false;
                menuPrincipal = true;
                // Encerrar a exibição de estatísticas
            }
            while(imprimir)
            {
                
            }
        }
    }    
}
