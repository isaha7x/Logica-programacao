import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        int[][] matrizA = new int[2][3];
        int[][] matrizB = new int[2][3];

        int[][] matrizSoma = new int[2][3];

        Scanner leitor = new Scanner(System.in);

        // Matriz A
        for (int linha =0; linha < matrizA.length; linha++){
            for(int coluna =0; coluna < matrizA[linha].length; coluna++){
                System.out.println("Digite o valor da matriz A["+ linha + "] ["+ coluna + "]");
                matrizA [linha] [coluna] = leitor.nextInt();
            }
        }

        // matriz B
        for (int linha =0; linha < matrizB.length; linha++){
            for(int coluna =0; coluna < matrizB[linha].length; coluna++){
                System.out.println("Digite o valor da matriz B ["+ linha + "] ["+ coluna + "]");
                matrizB [linha] [coluna] = leitor.nextInt();
            }
        }

        //Soma das matrizes
        for (int a=0; a < matrizA.length; a ++){
            for (int b=0; b < matrizB.length; b++){
                matrizSoma [a][b] = matrizA[a][b]+ matrizB[a][b];
            }
        }
        // Loop para exibir os valores da matriz
        exibeMatriz(matrizSoma);

    }
    // Printar a soma
    public static void exibeMatriz(int[][] m) {
        // Loop para exibir os valores da matriz
        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                System.out.print(m[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }
}