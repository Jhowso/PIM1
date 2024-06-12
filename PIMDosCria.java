package pim1;
import java.util.Scanner;
public class ProjetoIntegrador {
        public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    double lucroMedioPorPeca [] = new double[3], receitaPorPeca [] = new double[3], receitaPorSessao [] = new double[9];
    String cpfParaImprimir, cpf = "0" , cpfs[] = new String [10], compras[] = new String[10], opcao, horario, secao, frisaString, assentoA, assentoB, assentoCamarote, assentoFrisa, assentoBalcao, camaroteString;
    boolean encontrouIngresso, cpfInvalido = true, menuPrincipal = true, comprar = false, opcaoInvalida = false, sair = false, estatistica = false, imprimir = false, platAOcupado[][][] = new boolean [9][5][5], platBOcupado[][][] = new boolean[9][10][10], camarotesOcupado[][][] = new boolean[9][5][10], frisasOcupado[][][] = new boolean[9][6][5], balcaoNobreOcupado[][][] = new boolean[9][10][5];
    int vendasPorSessao [] = new int[9], menosVendida = 0, contadorCompra = 0, horarios = 0, num, maisVendida = 0, precoplatA = 40, precoplatB = 60, precoCamarote = 80, precoFrisa = 120, precoBalcaonobre = 250,totalVendido = 0, totalDisponivel = 0, secaoInt, assentoAint, assentoBint, assentoCamaroteint, assentoFrisaint, assentoBalcaoint, contador = 1, horarioInt, camaroteInt, frisaInt, colunaA, linhaA, linhaB, colunaB, camaroteEscolhido, posicaoEscolhida, posicaoFrisa, frisaEscolhida, linhaBalcao, colunaBalcao;
    int pesos1 [] = {10, 9, 8, 7, 6, 5, 4, 3, 2}, pesos2 [] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2}, vendasPorPeca [] = new int[3], platA [][][] = new int [9][5][5], platB [][][] = new int[9][10][10], frisas [][][] = new int [9][6][5], camarotes [][][] = new int[9][5][10], balcaoNobre [][][] = new int[9][10][5];
    

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
                    // Exibe menu principal
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
                    // Exibe o menu para selecionar as peças por horários, sendo 3 de manhã, 3 à tarde e 3 à noite
                    System.out.printf("Escolha o horário de sua preferência:\nManhã:\n1. Peça 1 - 08:00\n2. Peça 2 - 09:30\n3. Peça 3 - 11:00\nTarde:\n4. Peça 1 - 13:00\n5. Peça 2 - 15:30\n6. Peça 3 - 17:00\nNoite:\n7. Peça 1 - 18:30\n8. Peça 2 - 20:00\n9. Peça 3 - 21:30\n");
                    do {
                        horario = ler.nextLine();
                        horarioInt = Integer.parseInt(horario);
                        if (horarioInt >= 1 && horarioInt <= 9) {
                            opcaoInvalida = false;
                            // Exibe menu de seções/áreas do teatro, e submenus caso a escolha seja os camarotes ou as frisas.
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
                                                    cpfs[contadorCompra] = cpf;
                                                    compras[contadorCompra] = "Plateia A - Assento " + assentoA + " - Horário " + horarioInt;
                                                    contadorCompra++;
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
                                                    cpfs[contadorCompra] = cpf;
                                                    compras[contadorCompra] = "Plateia B - Assento " + assentoB + " - Horário " + horarioInt;
                                                    contadorCompra++;
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
                                            System.out.print("Camarote " + (camarote+1) + ": ");
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
                                                        cpfs[contadorCompra] = cpf;
                                                        compras[contadorCompra] = "Camarote " + (camaroteEscolhido+1) + " - Assento " + assentoCamarote + " - Horário " + horarioInt;
                                                        contadorCompra++;
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
                                            System.out.println("Frisa " + (frisa+1) + ": ");
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
                                                        cpfs[contadorCompra] = cpf;
                                                        compras[contadorCompra] = "Frisa " + (frisaEscolhida + 1) + " - Assento " + assentoFrisa + " - Horário " + horarioInt;
                                                        contadorCompra++;
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
                                                    cpfs[contadorCompra] = cpf;
                                                    compras[contadorCompra] = "Balcão Nobre - Assento " + assentoBalcao + " - Horário " + horarioInt;
                                                    contadorCompra++;
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


                while (estatistica) {
                
                    // Somar vendas e receitas de cada peça
                    for (horarios = 0; horarios < 9; horarios++) {
                        for (int secoes = 0; secoes < 5; secoes++) {
                            for (int assentos = 0; assentos < 5; assentos++) {
                                if (platAOcupado[horarios][secoes][assentos]) {
                                    vendasPorPeca[horarios % 3]++;
                                    receitaPorPeca[horarios % 3] += precoplatA;
                                    vendasPorSessao[horarios]++;
                                    receitaPorSessao[horarios] += precoplatA;
                                }
                            }
                        }
                        for (int secoes = 0; secoes < 10; secoes++) {
                            for (int assentos = 0; assentos < 10; assentos++) {
                                if (platBOcupado[horarios][secoes][assentos]) {
                                    vendasPorPeca[horarios % 3]++;
                                    receitaPorPeca[horarios % 3] += precoplatB;
                                    vendasPorSessao[horarios]++;
                                    receitaPorSessao[horarios] += precoplatB;
                                }
                            }
                        }
                        for (int secoes = 0; secoes < 5; secoes++) {
                            for (int assentos = 0; assentos < 10; assentos++) {
                                if (camarotesOcupado[horarios][secoes][assentos]) {
                                    vendasPorPeca[horarios % 3]++;
                                    receitaPorPeca[horarios % 3] += precoCamarote;
                                    vendasPorSessao[horarios]++;
                                    receitaPorSessao[horarios] += precoCamarote;
                                }
                            }
                        }
                        for (int secoes = 0; secoes < 6; secoes++) {
                            for (int assentos = 0; assentos < 5; assentos++) {
                                if (frisasOcupado[horarios][secoes][assentos]) {
                                    vendasPorPeca[horarios % 3]++;
                                    receitaPorPeca[horarios % 3] += precoFrisa;
                                    vendasPorSessao[horarios]++;
                                    receitaPorSessao[horarios] += precoFrisa;
                                }
                            }
                        }
                        for (int secoes = 0; secoes < 10; secoes++) {
                            for (int assentos = 0; assentos < 5; assentos++) {
                                if (balcaoNobreOcupado[horarios][secoes][assentos]) {
                                    vendasPorPeca[horarios % 3]++;
                                    receitaPorPeca[horarios % 3] += precoBalcaonobre;
                                    vendasPorSessao[horarios]++;
                                    receitaPorSessao[horarios] += precoBalcaonobre;
                                }
                            }
                        }
                    }
                
                    // Determinar a peça mais e menos vendida
                    maisVendida = 0;
                    menosVendida = 0;
                    for (int peca = 1; peca < 3; peca++) {
                        if (vendasPorPeca[peca] > vendasPorPeca[maisVendida]) {
                            maisVendida = peca;
                        }
                        if (vendasPorPeca[peca] < vendasPorPeca[menosVendida]) {
                            menosVendida = peca;
                        }
                    }
                
                    // Determinar a peça mais e menos lucrativa
                    int maisLucrativa = 0;
                    int menosLucrativa = 0;
                    for (int peca = 1; peca < 3; peca++) {
                        if (receitaPorPeca[peca] > receitaPorPeca[maisLucrativa]) {
                            maisLucrativa = peca;
                        }
                        if (receitaPorPeca[peca] < receitaPorPeca[menosLucrativa]) {
                            menosLucrativa = peca;
                        }
                    }
                
                    // Determinar a sessão com maior e menor ocupação de poltronas
                    int sessaoMaisOcupada = 0;
                    int sessaoMenosOcupada = 0;
                    for (int sessao = 1; sessao < 9; sessao++) {
                        if (vendasPorSessao[sessao] > vendasPorSessao[sessaoMaisOcupada]) {
                            sessaoMaisOcupada = sessao;
                        }
                        if (vendasPorSessao[sessao] < vendasPorSessao[sessaoMenosOcupada]) {
                            sessaoMenosOcupada = sessao;
                        }
                    }
                
                    // Determinar a sessão mais e menos lucrativa
                    int sessaoMaisLucrativa = 0;
                    int sessaoMenosLucrativa = 0;
                    for (int sessao = 1; sessao < 9; sessao++) {
                        if (receitaPorSessao[sessao] > receitaPorSessao[sessaoMaisLucrativa]) {
                            sessaoMaisLucrativa = sessao;
                        }
                        if (receitaPorSessao[sessao] < receitaPorSessao[sessaoMenosLucrativa]) {
                            sessaoMenosLucrativa = sessao;
                        }
                    }
                
                    // Calcular lucro médio por peça
                    for (int peca = 0; peca < 3; peca++) {
                        lucroMedioPorPeca[peca] = receitaPorPeca[peca] / 3.0;
                    }
                
                    // Exibir estatísticas
                    System.out.println("Estatísticas de Vendas:");
                
                    System.out.println("Peça mais vendida: Peça " + (maisVendida + 1) + " com " + vendasPorPeca[maisVendida] + " ingressos");
                    System.out.println("Peça mais lucrativa: Peça " + (maisLucrativa + 1) + " com receita de R$" + receitaPorPeca[maisLucrativa]);
                    System.out.println("Sessão mais ocupada: Sessão " + (sessaoMaisOcupada + 1) + " com " + vendasPorSessao[sessaoMaisOcupada] + " ingressos");
                    System.out.println("Sessão mais lucrativa: Sessão " + (sessaoMaisLucrativa + 1) + " com receita de R$" + receitaPorSessao[sessaoMaisLucrativa]);
                    System.out.println();
                    System.out.println("Peça menos vendida: Peça " + (menosVendida + 1) + " com " + vendasPorPeca[menosVendida] + " ingressos");
                    System.out.println("Peça menos lucrativa: Peça " + (menosLucrativa + 1) + " com receita de R$" + receitaPorPeca[menosLucrativa]);
                    System.out.println("Sessão menos ocupada: Sessão " + (sessaoMenosOcupada + 1) + " com " + vendasPorSessao[sessaoMenosOcupada] + " ingressos");
                    System.out.println("Sessão menos lucrativa: Sessão " + (sessaoMenosLucrativa + 1) + " com receita de R$" + receitaPorSessao[sessaoMenosLucrativa]);
                    System.out.println();
                
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Lucro médio da Peça " + (i + 1) + ": R$" + lucroMedioPorPeca[i]);
                    }
                    System.out.println();
                    estatistica = false;
                    menuPrincipal = true;
                }
                
            
            while(imprimir)
            {
                cpfParaImprimir = cpf;
                encontrouIngresso = false;
                //Exibe os ingressos comprados no CPF atual
                for (int i = 0; i < contadorCompra; i++) 
                {
                    if (cpfs[i].equals(cpfParaImprimir)) 
                    {
                        System.out.println("Ingresso: " + compras[i]);
                        encontrouIngresso = true;
                    }
                }
                //Se não encontrar nenhum ingresso
                if (!encontrouIngresso) 
                {
                    System.out.println("Nenhum ingresso encontrado para este CPF.");
                }
                    imprimir = false;
                    menuPrincipal = true;
                }
                
            }
        }
    }    
