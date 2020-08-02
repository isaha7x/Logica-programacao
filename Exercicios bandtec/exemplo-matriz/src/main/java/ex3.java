import javax.swing.*;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        int matriz[][] = new int[4][3];
        int[][] cont = new int[1][matriz.length];

        Scanner entrada = new Scanner(System.in);
        System.out.println("Matriz");

//        for (int i = 0; i < 4; i++) {
//            System.out.println(" ");
//            for (int j = 0; j < 3; j++) {
//              //  String valor = JOptionPane.showInputDialog(null, "Informe o valor");
//                System.out.println("informe o valor");
//               // int v = Integer.parseInt(valor);
//
//                mat[i][j] = v;
//                System.out.print(v + " ");
//            }
//        }
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < 2; coluna++) {
                System.out.printf("Digite o elemento M[%d][%d]: ", linha + 1, coluna + 1);
                matriz[linha][coluna] = entrada.nextInt();
                //soma = soma + matriz[linha][coluna];
                matriz[0][coluna] += matriz[linha][coluna];
            }
        }

        System.out.println(" ");
        System.out.println(" ");
        int soma;

        for (int j = 0; j < 3; j++) {
            soma = 0;

            for (int i = 0; i < 4; i++) {
                soma = soma + matriz[i][j];
            }

            System.out.printf("Soma da coluna %d: %d\n", j, soma);
        }
    }
    }

