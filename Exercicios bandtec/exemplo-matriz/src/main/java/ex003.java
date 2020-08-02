import javax.swing.*;
import java.util.Scanner;

public class ex003 {
    public static void main(String[] args) {
        int mat[][] = new int[4][3];
        String valor ="";
        Scanner leitor = new Scanner(System.in);
        System.out.println("Matriz");

        for (int i = 0; i < 4; i++) {
            System.out.println(" ");
            for (int j = 0; j < 3; j++) {
              //  String valor = JOptionPane.showInputDialog(null, "Informe o valor");
                System.out.println("digite um valor");
                mat[i][j] = leitor.nextInt();
               // int v = Integer.parseInt(valor);
               // mat[i][j] = ;
               // System.out.print(mat + " ");
            }
        }

        System.out.println(" ");
        System.out.println(" ");
        int soma;

        for (int x = 0; x < 3; x++) {
            soma = 0;

            for (int i = 0; i < 4; i++) {
                soma = soma + mat[i][x];
            }

            System.out.printf("Soma da coluna %d: %d\n",x, soma);
        }
    }
    }

