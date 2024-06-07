package pim1;
import java.util.Scanner;
public class PIMDosCria {
        public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    String cpf;
    boolean comprar = false, opcaoInvalida = false, sair = false, estatistica = false, imprimir = false, platAOcupado[][][] = new boolean [9][5][5], platBOcupado[][][] = new boolean[9][10][10], camarotesOcupado[][][] = new boolean[9][5][10], frisasOcupado[][][] = new boolean[9][6][5], balcaoNobreOcupado[][][] = new boolean[9][10][5];
    int secao, horario, contador = 1, opcao, dia [] = new int [3];
    int platA [][][] = new int [9][5][5], platB [][][] = new int[9][10][10], frisas [][][] = new int [9][6][5], camarotes [][][] = new int[9][5][10], balcaoNobre [][][] = new int[9][10][5];
    /* 
     * Realizar leitura do CPF e validação dele aqui posteriormente
     */

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
    System.out.println();
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
   System.out.println();
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

   System.out.printf("Selecione uma opção:\n1. Comprar ingresso. \n2. Imprimir ingresso. \n3. Estatística de Vendas.\n4. Sair do programa\n");
                opcao = ler.nextInt();
                do{
                    switch(opcao)
                {
                 case 1:
                    comprar = true;
                    break;
                case 2:
                    System.out.println("Imprimir ingresso");
                    imprimir = true;
                    break;
                case 3:
                    System.out.println("Estatísticas de Venda");
                    estatistica = true;
                    break;
                case 4:
                    System.out.println("Sair do programa.");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida, favor selecione outra.");
                    opcaoInvalida = true;
                    break;
                }
             } while(opcaoInvalida);

                do {
                    System.out.printf("Escolha o horário de sua preferência: \n1. 08:00\n2. 09:30\n3. 11:00\n4. 13:00\n5. 15:30\n6. 17:00\n7. 18:30\n8. 20:00\n9. 21:30\n");
                    horario = ler.nextInt();
                    comprar = false;
                    switch (horario) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            System.out.printf("Escolha sua seção de preferência: \n1. Plateia A: R$ 40,00\n2. Plateia B: R$ 60,00\n3. Camarote: R$ 80,00\n4. Frisa: R$ 120,00\n5. Balcão Nobre: R$ 250,00\n");
                            secao = ler.nextInt();
                            switch (secao) {
                            
                            case 1:
                            System.out.println("Você escolheu Plateia A.");
                            System.out.println("Assentos disponíveis:");
                            for (int linha = 0; linha < 5; linha++) {
                                for (int coluna = 0; coluna < 5; coluna++) {
                                    System.out.printf("%2d ", platA[horario - 1][linha][coluna]);
                                }
                                System.out.println();
                            }
                            System.out.println("Escolha um assento (informe o número): ");
                            int assentoA = ler.nextInt();
                            int linhaA = (assentoA - 1) / 5; // Calcula a linha com base no número do assento
                            int colunaA = (assentoA - 1) % 5; // Calcula a coluna com base no número do assento
                            if (platAOcupado[horario - 1][linhaA][colunaA]) {
                                System.out.println("Assento já ocupado. Tente novamente.");
                            } else {
                                platAOcupado[horario - 1][linhaA][colunaA] = true;
                                System.out.println("Assento reservado com sucesso!");
                            }
                            break;
                        case 2:
                            System.out.println("Você escolheu Plateia B.");
                            System.out.println("Assentos disponíveis:");
                            for (int linha = 0; linha < 10; linha++) {
                                for (int coluna = 0; coluna < 10; coluna++) {
                                    System.out.printf("%2d ", platB[horario - 1][linha][coluna]);
                                }
                                System.out.println();
                            }
                            System.out.println("Escolha um assento (informe o número): ");
                            int assentoB = ler.nextInt();
                            int linhaB = (assentoB - 1) / 10; // Calcula a linha com base no número do assento
                            int colunaB = (assentoB - 1) % 10; // Calcula a coluna com base no número do assento
                            if (platBOcupado[horario - 1][linhaB][colunaB]) {
                                System.out.println("Assento já ocupado. Tente novamente.");
                            } else {
                                platBOcupado[horario - 1][linhaB][colunaB] = true;
                                System.out.println("Assento reservado com sucesso!");
                            }
                            break;
                        case 3:
                            System.out.println("Você escolheu Camarote.");
                            System.out.println("Assentos disponíveis:");
                            for (int camarote = 0; camarote < 5; camarote++) {
                                for (int posicao = 0; posicao < 10; posicao++) {
                                    System.out.printf("%2d ", camarotes[horario - 1][camarote][posicao]);
                                }
                                System.out.println();
                            }
                            System.out.println("Escolha um assento (informe o número): ");
                            int assentoCamarote = ler.nextInt();
                            int camaroteEscolhido = (assentoCamarote - 1) / 10; // Calcula o camarote com base no número do assento
                            int posicaoEscolhida = (assentoCamarote - 1) % 10; // Calcula a posição com base no número do assento
                            if (camarotesOcupado[horario - 1][camaroteEscolhido][posicaoEscolhida]) {
                                System.out.println("Assento já ocupado. Tente novamente.");
                            } else {
                                camarotesOcupado[horario - 1][camaroteEscolhido][posicaoEscolhida] = true;
                                System.out.println("Assento reservado com sucesso!");
                            }
                            break;
                        case 4:
                            System.out.println("Você escolheu Frisa.");
                            System.out.println("Assentos disponíveis:");
                            for (int frisa = 0; frisa < 6; frisa++) {
                                System.out.print("Frisa " + (frisa + 1) + ": ");
                                for (int posicao = 0; posicao < 5; posicao++) {
                                    
                                    System.out.printf("%2d ", frisas[horario - 1][frisa][posicao]);
                                }
                                System.out.println();
                            }
                            System.out.println("Escolha um assento (informe o número): ");
                            int assentoFrisa = ler.nextInt();
                            int frisaEscolhida = (assentoFrisa - 1) / 5; // Calcula a frisa com base no número do assento
                            int posicaoFrisa = (assentoFrisa - 1) % 5; // Calcula a posição com base no número do assento
                            if (frisasOcupado[horario - 1][frisaEscolhida][posicaoFrisa]) {
                                System.out.println("Assento já ocupado. Tente novamente.");
                            } else {
                                frisasOcupado[horario - 1][frisaEscolhida][posicaoFrisa] = true;
                                System.out.println("Assento reservado com sucesso!");
                            }
                            break;
                        case 5:
                            System.out.println("Você escolheu Balcão Nobre.");
                            System.out.println("Assentos disponíveis:");
                            for (int linha = 0; linha < 10; linha++) {
                                for (int coluna = 0; coluna < 5; coluna++) {
                                    System.out.printf("%2d ", balcaoNobre[horario - 1][linha][coluna]);
                                }
                                System.out.println();
                            }
                            System.out.println("Escolha um assento (informe o número): ");
                            int assentoBalcão = ler.nextInt();
                            int linhaBalcão = (assentoBalcão - 1) / 5; // Calcula a linha com base no número do assento
                            int colunaBalcão = (assentoBalcão - 1) % 5; // Calcula a coluna com base no número do assento
                            if (balcaoNobreOcupado[horario - 1][linhaBalcão][colunaBalcão]) {
                                System.out.println("Assento já ocupado. Tente novamente.");
                            } else {
                                balcaoNobreOcupado[horario - 1][linhaBalcão][colunaBalcão] = true;
                                System.out.println("Assento reservado com sucesso!");
                            }
                            break;
                        default:
                            System.out.println("Seção inválida. Tente novamente.");
                            comprar = true;
                            break;
                             }
                            break;
                            default:
                            System.out.println("Horário inválido. Tente novamente.");
                            comprar = true;
                            break;
                    }
                } while (comprar);
        
                ler.close();
            }
        }
