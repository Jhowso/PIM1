package pim1;
import java.util.Scanner;
public class PIMDosCria {
        public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    String cpf, opcao, horario, secao, frisaString, assentoA, assentoB, assentoCamarote, assentoFrisa, assentoBalcao;
    boolean comprar = false, opcaoInvalida = false, sair = false, estatistica = false, imprimir = false, platAOcupado[][][] = new boolean [9][5][5], platBOcupado[][][] = new boolean[9][10][10], camarotesOcupado[][][] = new boolean[9][5][10], frisasOcupado[][][] = new boolean[9][6][5], balcaoNobreOcupado[][][] = new boolean[9][10][5];
    int opcaoInt, secaoInt, assentoAint, assentoBint, assentoCamaroteint, assentoFrisaint, assentoBalcaoint, contador = 1, dia [] = new int [3], horarioInt, camaroteInt, frisaInt, colunaA, linhaA, linhaB, colunaB, camaroteEscolhido, posicaoEscolhida, posicaoFrisa, frisaEscolhida, linhaBalcao, colunaBalcao;
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

   System.out.printf("Selecione uma opção:\n1. Comprar ingresso. \n2. Imprimir ingresso. \n3. Estatística de Vendas.\n4. Sair do programa\n");
                
                do{
                    opcao = ler.nextLine();
                    opcaoInt = Integer.parseInt(opcao);
                    switch(opcao.toLowerCase()){
                 case "1":
                 case "1.":
                 case "comprar ingresso":
                    comprar = true;
                    opcaoInvalida = false;
                    break;
                case "2":
                case "2.":
                case "imprimir ingresso":
                    System.out.println("Imprimir ingresso");
                    imprimir = true;
                    opcaoInvalida = false;
                    break;
                case "3":
                case "3.":
                case "estatisticas de venda":
                    System.out.println("Estatísticas de Venda");
                    estatistica = true;
                    opcaoInvalida = false;
                    break;
                case "4":
                case "4.":
                case "sair do programa":
                    System.out.println("Sair do programa.");
                    sair = true;
                    opcaoInvalida = false;
                    break;
                default:
                    System.out.println("Opção inválida, favor selecione outra.");
                    opcaoInvalida = true;
                    break;
                }
                } while(opcaoInvalida);

                while(comprar){
                    System.out.printf("Escolha o horário de sua preferência:\nManhã: \n1. Peça 1 - 08:00 \n2. Peça 2 - 09:30 \n3. Peça 3 - 11:00 \nTarde:\n4. Peça 1 - 13:00\n5. Peça 2 - 15:30\n6. Peça 3 - 17:00\nNoite: \n7. Peça 1 - 18:30\n8. Peça 2 - 20:00\n9. Peça 3 - 21:30\n");
                    do{
                    horario = ler.nextLine();
                    horarioInt = Integer.parseInt(horario);
                    switch (horario) 
                    {
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        case "7":
                        case "8":
                        case "9":
                            opcaoInvalida = false;
                            System.out.printf("Escolha sua seção de preferência:\n1. Plateia A: R$ 40,00\n2. Plateia B: R$ 60,00\n3. Camarote: R$ 80,00\n4. Frisa: R$ 120,00\n5. Balcão Nobre: R$ 250,00\n");
                            do
                            {
                            secao = ler.nextLine();
                            secaoInt = Integer.parseInt(secao);
                            switch (secao) 
                            {
                                case "1":
                            System.out.println("Você escolheu Plateia A.");
                            System.out.println("Assentos disponíveis:");
                            for (int linha = 0; linha < 5; linha++) 
                            {
                                for (int coluna = 0; coluna < 5; coluna++) 
                                {
                                    System.out.printf("%2d ", platA[horarioInt - 1][linha][coluna]);
                                }
                                System.out.println();
                            }
                            
                            System.out.println("Escolha um assento (informe o número): ");
                            do
                            {
                            assentoA = ler.nextLine();
                            assentoAint = Integer.parseInt(assentoA);
                            if(assentoAint > 0 && assentoAint < 26)
                            {
                            linhaA = (assentoAint - 1) / 5; // Calcula a linha com base no número do assento
                            colunaA = (assentoAint - 1) % 5; // Calcula a coluna com base no número do assento
                            if (platAOcupado[horarioInt - 1][linhaA][colunaA]) 
                                {
                                System.out.println("Assento já ocupado. Tente novamente.");
                                } else 
                                {
                                platAOcupado[horarioInt - 1][linhaA][colunaA] = true;
                                System.out.println("Assento reservado com sucesso!");
                                }
                                comprar = false;
                            opcaoInvalida = false;
                            }else
                            {
                                System.out.println("Opção inválida. Tente novmente.");
                                opcaoInvalida = true;
                            }
                            
                            break;
                            }while(opcaoInvalida);

                                case "2":
                            System.out.println("Você escolheu Plateia B.");
                            System.out.println("Assentos disponíveis:");
                            for (int linha = 0; linha < 10; linha++) 
                            {
                                for (int coluna = 0; coluna < 10; coluna++) 
                                {
                                    System.out.printf("%2d ", platB[horarioInt - 1][linha][coluna]);
                                }
                                System.out.println();
                            }
                            System.out.println("Escolha um assento (informe o número): ");
                            do
                            {
                            assentoB = ler.nextLine();
                            assentoBint = Integer.parseInt(assentoB);
                            if(assentoBint > 0 && assentoBint < 101)
                            {
                            linhaB = (assentoBint - 1) / 10; // Calcula a linha com base no número do assento
                            colunaB = (assentoBint - 1) % 10; // Calcula a coluna com base no número do assento
                            if (platBOcupado[horarioInt - 1][linhaB][colunaB]) 
                            {
                                System.out.println("Assento já ocupado. Tente novamente.");
                            } else 
                            {
                                platBOcupado[horarioInt - 1][linhaB][colunaB] = true;
                                System.out.println("Assento reservado com sucesso!");
                                opcaoInvalida = false;
                                comprar = false;
                            }
                            }
                            else
                            {
                                System.out.println("Opção inválida. Tente novmente.");
                                opcaoInvalida = true;
                            }   
                            break;
                        }while (opcaoInvalida);   

                                case "3": //Oferece um submenu para escolher o camarote de 1 à 5 para depois selecionar o assento.
                                   System.out.println("Escolha um camarote:\n1. Camarote 1\n2. Camarote 2\n3. Camarote 3\n4. Camarote 4\n5. Camarote 5");
                                   do
                                    {
                                    String camarote = ler.nextLine();
                                        switch(camarote)
                                        {
                                            case "1:":
                                            case "1":
                                            case "2":
                                            case "2.":
                                            case "3":
                                            case "4":
                                            case "4.":
                                            case "5":
                                            case "5:":
                                                camaroteInt = Integer.parseInt(camarote);
                                                System.out.println("Camarote " + camaroteInt + ": ");
                                                for(int posicao = 0; posicao < 10; posicao++)
                                                {
                                                    System.out.print (camarotes[horarioInt - 1][camaroteInt - 1][posicao] + " ");
                                                }
                                                System.out.println();
                                                opcaoInvalida = false;
                                                
                                                break;
                                            default:
                                                opcaoInvalida = true;
                                                System.out.println("Opção inválida, tente novamente.");
                                                break;
                                            }
                                        }while(opcaoInvalida);
                            
                            System.out.println("Escolha um assento (informe o número): ");
                            do
                            {
                                assentoCamarote = ler.nextLine();
                                assentoCamaroteint = Integer.parseInt(assentoCamarote);
                             if(assentoCamaroteint > 0 && assentoCamaroteint < 11)
                                {
                                    camaroteEscolhido = (assentoCamaroteint - 1) / 10; // Calcula o camarote com base no número do assento
                                    posicaoEscolhida = (assentoCamaroteint - 1) % 10; // Calcula a posição com base no número do assento
                                if (camarotesOcupado[horarioInt - 1][camaroteEscolhido][posicaoEscolhida]) 
                                {
                                 System.out.println("Assento já ocupado. Tente novamente.");
                                } else 
                                {
                                    camarotesOcupado[horarioInt - 1][camaroteEscolhido][posicaoEscolhida] = true;
                                    System.out.println("Assento reservado com sucesso!");
                                    comprar = false;
                                    
                                }
                                opcaoInvalida = false;
                            }else
                            {
                                System.out.println("Opção inválida. Tente novamente.");
                                opcaoInvalida = true;
                            }

                            break;
                        }while(opcaoInvalida);
                                case "4":
                                System.out.println("Escolha uma frisa:\n1. Frisa 1\n2. Frisa 2\n3. Frisa 3\n4. Frisa 4\n5. Frisa 5\n6. Frisa 6");
                                do
                                {
                                frisaString = ler.nextLine();
                                            switch(frisaString)
                                         {
                                        case "1:":
                                        case "1":
                                        case "2":
                                        case "2.":
                                        case "3":
                                        case "4":
                                        case "4.":
                                        case "5":
                                        case "5.":
                                        case "6":
                                        case "6.":
                                            frisaInt = Integer.parseInt(frisaString);
                                            System.out.println("Camarote " + frisaInt + ": ");
                                            for(int posicao = 0; posicao < 5; posicao++)
                                            {
                                                System.out.print (frisas[horarioInt - 1][frisaInt - 1][posicao] + " ");
                                            }
                                            System.out.println();
                                            opcaoInvalida = false;
                                            break;
                                        default:
                                            opcaoInvalida = true;
                                            System.out.println("Opção inválida, tente novamente.");
                                        }
                                }while(opcaoInvalida);
                                
                                System.out.println("Escolha um assento (informe o número): ");
                                do
                                {
                                     assentoFrisa = ler.nextLine();
                                     assentoFrisaint = Integer.parseInt(assentoFrisa);
                                    if(assentoFrisaint > 0 && assentoFrisaint < 6)
                                    {
                                    frisaEscolhida = (assentoFrisaint - 1) / 5; // Calcula a frisa com base no número do assento
                                    posicaoFrisa = (assentoFrisaint - 1) % 5; // Calcula a posição com base no número do assento
                                    if (frisasOcupado[horarioInt - 1][frisaEscolhida][posicaoFrisa]) 
                                    {
                                    System.out.println("Assento já ocupado. Tente novamente.");
                                    } else 
                                    {
                                    frisasOcupado[horarioInt - 1][frisaEscolhida][posicaoFrisa] = true;
                                    System.out.println("Assento reservado com sucesso!");
                                    opcaoInvalida = false;
                                    comprar = false;
                                    }
                                    }else
                                     {
                                        System.out.println("Opção inválida. Tente novamente.");
                                        opcaoInvalida = true;
                                     }
                                break;
                            }while(opcaoInvalida);

                                case "5":
                                    System.out.println("Você escolheu Balcão Nobre.");
                                     System.out.println("Assentos disponíveis:");
                                    for (int linha = 0; linha < 10; linha++) 
                                     {
                                    for (int coluna = 0; coluna < 5; coluna++)
                                    {
                                    System.out.printf("%2d ", balcaoNobre[horarioInt - 1][linha][coluna]);
                                    }
                                     System.out.println();
                                    }

                                    System.out.println("Escolha um assento (informe o número): ");
                                        do
                                        {
                                    assentoBalcao = ler.nextLine();
                                    assentoBalcaoint = Integer.parseInt(assentoBalcao);
                                     if(assentoBalcaoint > 0 && assentoBalcaoint < 51){
                                    linhaBalcao = (assentoBalcaoint - 1) / 5; // Calcula a linha com base no número do assento
                                    colunaBalcao = (assentoBalcaoint - 1) % 5; // Calcula a coluna com base no número do assento
                                    if (balcaoNobreOcupado[horarioInt - 1][linhaBalcao][colunaBalcao]) 
                                    {
                                    System.out.println("Assento já ocupado. Tente novamente.");
                                    } else 
                                    {
                                    balcaoNobreOcupado[horarioInt - 1][linhaBalcao][colunaBalcao] = true;
                                    System.out.println("Assento reservado com sucesso!");
                                     }
                                    opcaoInvalida = false;
                                    comprar = false;
                                    }else
                                    {
                                    opcaoInvalida = true;
                                    System.out.println("Opção inválida. Tente novmente.");
                                    }
                                     
                                    break;
                                }while(opcaoInvalida);
                                default:
                                    System.out.println("Seção inválida. Tente novamente.");
                                    comprar = true;
                                    opcaoInvalida = true;
                                    break;
                                    }
                            }
                            while(opcaoInvalida);
                            default:
                                System.out.println("Horário inválido. Tente novamente.");
                                comprar = true;
                                opcaoInvalida = true;
                                break;
                            
                        }
            
            ler.close();
        }while(opcaoInvalida);
    }
}
}
