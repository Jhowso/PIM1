<<<<<<< HEAD
package pim.dos.cria;
import java.util.Scanner;
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
    
            cpf = "123.456.789-09"; // Exemplo de CPF
            if (ValidadorCPF.validarCPF(cpf)) {
                System.out.println("CPF válido!");
            } else {
                System.out.println("CPF inválido!");
            }
    






    
    // Preenche a matriz 5x5 platA com elementos de 1 à 25, em 5 fileiras e 5 colunas e as exibe no final
    System.out.println("Platéia A: ");
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pim.dos.cria;
import java.util.Scanner;
/**
 *
 * @author Aluno
 */
public class PIMDosCria {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    int cpf, contador = 1;
    int platA [][] = new int [5][5];
    int platB [][] = new int[10][10];
    int frisas [][] = new int [6][5];
    int camarote [][] = new int[5][10];
    int balcaoNobre [][] = new int[10][5];
    
    
/* 
    Preencher a matriz 5x5 platA com elementos de 1 à 25, em 5 fileiras e 5 colunas e as exibe no final*/
>>>>>>> a90de2495dde10b6efc02e6ff7fdea381d2bffa2
    for(int linha = 0; linha < 5; linha++)
    {
        for(int coluna = 0; coluna < 5; coluna++)
        {
        platA [linha][coluna] = contador;
        contador++;
<<<<<<< HEAD
        
=======
>>>>>>> a90de2495dde10b6efc02e6ff7fdea381d2bffa2
        System.out.print(platA[linha][coluna] + " ");
        }
        System.out.println();
    }
    System.out.println();
<<<<<<< HEAD
    
    // Preenche a matriz 10x10 platB com elementos de 1 à 100, em 10 fileiras e 10 colunas e as exibe no final.
    System.out.println("Platéia B: ");
=======
    /* 
    Preencher a matriz 10x10 platB com elementos de 1 à 100, em 10 fileiras e 10 colunas e as exibe no final.
    */
>>>>>>> a90de2495dde10b6efc02e6ff7fdea381d2bffa2
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
    
<<<<<<< HEAD
   // Preenche a matriz frisa com elementos de 1 à 5 para cada frisa, sendo 6 frisas no total e as exibe no final.
=======
   /*
   Preencher a matriz frisa com elementos de 1 à 5 para cada frisa, sendo 6 frisas no total e as exibe no final.
   */
   
>>>>>>> a90de2495dde10b6efc02e6ff7fdea381d2bffa2
   
   for(int frisa = 0; frisa < 6; frisa++)
   {
       contador = 1;
<<<<<<< HEAD
       System.out.print("Frisa " + (frisa+1) + ": ");
       for(int posicao = 0; posicao < 5; posicao++)
       {
        
=======
       for(int posicao = 0; posicao < 5; posicao++)
       {
>>>>>>> a90de2495dde10b6efc02e6ff7fdea381d2bffa2
       frisas [frisa][posicao] = contador;
       contador++; 
       System.out.print(frisas[frisa][posicao] + " ");
       }          
       System.out.println();
   }
   System.out.println();
<<<<<<< HEAD
    
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
=======
   /* 
   Preencher a matriz camarote com elementos de 1 à 10 para cada camarote, sendo 5 camarotes no total e os exibe no final.
   
   */
    
   for(int i = 0; i < 5; i++)
   {
       contador = 1;
       for(int j = 0; j < 10; j++)
       {
       camarote [i][j] = contador;
       contador++;
       System.out.print(camarote[i][j] + " ");
       }
       System.out.println();
   }
   
   for(int i = 0; i < 5; i++)
   {
       contador = 1;
       for(int j = 0; j < 10; j++)
       {
       camarote [i][j] = contador;
       contador++;
       System.out.print(camarote[i][j] + " ");
       }
       System.out.println();
   }
   System.err.println();
   contador = 1;
>>>>>>> a90de2495dde10b6efc02e6ff7fdea381d2bffa2
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
   
<<<<<<< HEAD
    }    
=======
    }
    
>>>>>>> a90de2495dde10b6efc02e6ff7fdea381d2bffa2
}
