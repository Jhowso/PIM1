package pim.dos.cria;
import java.util.Scanner;
import 
public class PIMDosCria {
        public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    String cpf;
    int contador = 1;
    int platA [][] = new int [5][5];
    int platB [][] = new int[10][10];
    int frisas [][] = new int [6][5];
    int camarotes [][] = new int[5][10];
    int balcaoNobre [][] = new int[10][5];

    System.out.println("Informe seu CPF: ");
    cpf = ler.next();
    
            String cpf = "123.456.789-09"; // Exemplo de CPF
            if (ValidadorCPF.validarCPF(cpf)) {
                System.out.println("CPF válido!");
            } else {
                System.out.println("CPF inválido!");
            }
    






    
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
