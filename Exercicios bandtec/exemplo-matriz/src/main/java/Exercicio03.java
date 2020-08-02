import java.util.Scanner;

public class Exercicio03 {

    public static void main(String[] args) {

//        int [][] matriz = new int[3][3];
//        int[] vetor = new int [3];
//
//        Scanner leitor = new Scanner(System.in);
//        // matriz
//        for (int linha =0; linha < matriz.length; linha++){
//            for(int coluna =0; coluna < matriz[linha].length; coluna++){
//                System.out.println("Digite o valor da matriz  ["+ linha + "] ["+ coluna + "]");
//                matriz [linha] [coluna] = leitor.nextInt();
//            }
//        }
//        int soma = 0;
//
//        for (int l =0; l < 3; l++){
//            for (int c =0; c <3; c++){
//             //   soma[c] + matriz[l][c];
//              //  soma = soma + matriz[0][c];
//
//            }
//        }
//
//        System.out.println("Resultado " + soma);
//    }
        int[][] matriz = new int[8][2];
        int soma = 0;
        int[][] cont = new int[1][matriz.length];

        Scanner entrada = new Scanner(System.in);
        System.out.println("Matriz M{8][2]\n");

        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 2; coluna++) {
                System.out.printf("Digite o elemento M[%d][%d]: ", linha + 1, coluna + 1);
                matriz[linha][coluna] = entrada.nextInt();
                //soma = soma + matriz[linha][coluna];
                cont[0][coluna] += matriz[linha][coluna];
            }
        }
        System.out.println("\nA Matriz ficou:\n");
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 2; coluna++) {
                System.out.printf("\t %d \t", matriz[linha][coluna]);
                //soma = soma + coluna;
                //soma += matriz[linha][coluna];
                //soma += coluna;
                soma = cont[0][coluna];
                //System.out.printf("\t %d \t", cont[0][coluna]);
            }
            System.out.println();
        }
        System.out.println("soma-> " + soma);
    }}

