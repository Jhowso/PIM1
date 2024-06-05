package pim1;
import java.util.Scanner;
public class PIMDosCria {
        public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    String cpf;
    int comprar = 0, imprimir = 0, estatistica = 0, sair = 0, pecas[][] = new int[3][3], contador = 1, opcao = 0, opcaoValida = 0, platA [][] = new int [5][5], platB [][] = new int[10][10], frisas [][] = new int [6][5], camarotes [][] = new int[5][10], balcaoNobre [][] = new int[10][5];
    
    /* 
     * Realizar leitura do CPF e validação dele aqui posteriormente
     */
    
            System.out.printf("Selecione uma opção:\n1. Comprar ingresso. \n2. Imprimir ingresso. \n3. Estatística de Vendas.\n4. Sair do programa\n\n");
            opcao = ler.nextInt();
            while(opcaoValida == 0)
            {
                switch(opcao)
                {
                case 1:
                    System.out.println("Em qual período você deseja comprar o ingresso? \n1. Manhã \n2. Tarde \n3.Noite \n");
                    opcaoValida = 1;
                    comprar++;
                    break;
                case 2:
                    System.out.println("Imprimir ingresso");
                    opcaoValida = 2;
                    imprimir++;
                    break;
                case 3:
                    System.out.println("Estatísticas de Venda");
                    opcaoValida = 3;
                    estatistica++;
                    break;
                case 4:
                    System.out.println("Sair do programa.");
                    opcaoValida = 4;
                    sair++;
                default:
                    System.out.println("Opção inválida, favor selecione outra.");
                    opcaoValida = 0;
                    break;
            }   
        }
            for(int peca = 0; peca < 3; peca++)
            {
                for(int horario = 0; horario < 3; horario++)
                {
                    // pecas[peca][horario] = ;1
                    
                }

            }

            opcaoValida = 0;
            if(comprar > 0){
                do{
            opcao = ler.nextInt();
            switch(opcao)
            {
                case 1: 
                    System.out.printf("Teremos 3 peças pela parte da manhã neste dia! Escolha o horário de preferência \n1. 07:00 \n2. 09:00 \n3. 11:00\n");
                    opcao = ler.nextInt();
                    opcaoValida = 1;
                    break;
                case 2: 
                    System.out.println("Teremos 3 peças pela parte da tarde neste dia! Escolha o horário de preferência para o início da peça. ");
                    System.out.printf("1. 13:00 \n2. 15:00\n3. 17:00\n");
                    opcaoValida = 2;
                    break;
                case 3:
                    System.out.println("Teremos 3 peças pela parte da noite neste dia! Escolha o horário que mais lhe agrada: ");
                    System.out.printf("1. 18:00\n2.20:00\n22:00\n");
                    opcaoValida = 3;
                    break;
                default:
                    System.out.println("Opção inválida! Favor, selecione outra opção. ");
                    opcaoValida = 0;
                    break;
            }
            }while(opcaoValida == 0);
        }

        opcaoValida = 0;


            
    
    // Preenche a matriz 5x5 platA com elementos de 1 à 25, em 5 fileiras e 5 colunas e as exibe no final
    System.out.println("Platéia A: ");
    for(int linha = 0; linha < 5; linha++)
    {
        for(int coluna = 0; coluna < 5; coluna++)
        {
        platA [linha][coluna] = contador;
        contador++;
        
        System.out.print(platA[linha][coluna] + " ");
        }
        System.out.println();
    }
    System.out.println();
    
    // Preenche a matriz 10x10 platB com elementos de 1 à 100, em 10 fileiras e 10 colunas e as exibe no final.
    System.out.println("Platéia B: ");
    contador = 1;
    for(int linha = 0; linha < 10; linha++)
    {
        
        for(int coluna = 0; coluna < 10; coluna++)
        {
        platB [linha][coluna] = contador;
        contador++;
        System.out.print(platB[linha][coluna] + " ");
        }
        System.out.println();
    }
    System.out.println();
    
   // Preenche a matriz frisa com elementos de 1 à 5 para cada frisa, sendo 6 frisas no total e as exibe no final.
   
   for(int frisa = 0; frisa < 6; frisa++)
   {
       contador = 1;
       System.out.print("Frisa " + (frisa+1) + ": ");
       for(int posicao = 0; posicao < 5; posicao++)
       {
        
       frisas [frisa][posicao] = contador;
       contador++; 
       System.out.print(frisas[frisa][posicao] + " ");
       }          
       System.out.println();
   }
   System.out.println();
    
   // Preenche a matriz camarote com elementos de 1 à 10 para cada camarote, sendo 5 camarotes no total e os exibe no final.
   
   for(int camarote = 0; camarote < 5; camarote++)
   {
       contador = 1;
       System.out.print("Camarote " + (camarote+1) + ": ");
       for(int posicao = 0; posicao < 10; posicao++)
       {
       camarotes [camarote][posicao] = contador;
       contador++;
       System.out.print(camarotes[camarote][posicao] + " ");
       }
       System.out.println();
   }
   System.out.println();
   contador = 1;
   
   // Preenche a matriz balcaoNobre com 50 elementos, ordenados em 10 linhas e 5 colunas.
    System.out.println("Balcão Nobre: ");
    for(int linha = 0; linha < 10; linha++)
    {
        
        for(int coluna = 0; coluna < 5; coluna++)
        {
        balcaoNobre [linha][coluna] = contador;
        contador++;
        System.out.print(balcaoNobre[linha][coluna] +  " ");
        }
        System.out.println();
    }
    System.out.println();
   
    }    
}
