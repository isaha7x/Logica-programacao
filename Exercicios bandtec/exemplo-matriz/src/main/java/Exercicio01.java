import java.util.Scanner;

public class Exercicio01 {

    // Primeiro cria o método main pra ser executável
    public static void main(String[] args) {
        // depois fala o tipo da matriz e a matriz precisa receber dois valores
        // qtd linha e coluna
        int valor;
        boolean[][] matriz = new boolean[2][3];

        // Para o usuário poder digitar os valores
        Scanner leitor = new Scanner(System.in);

        // Loop para preencher os valores da matriz
        // linha inicia de zero // enquanto linha for menor que o tamanho da matriz, acrescenta mais uma linha
        for (int linha= 0; linha < matriz.length; linha++ ) {
            // coluna inicia de zero // enquanto coluna for menor que a matriz com parametro de linha; add mais um valor
            for (int coluna=0; coluna < matriz[linha].length; coluna++){
                // pedir para o usuário os valores da matriz
                System.out.println("Digite o valor de matriz[" + linha +
                        "][" + coluna + "]");
                //pede pro user digitar // colocando o scanner
                //matriz[linha][coluna] = leitor.nextInt();
            }
        }

        // Loop para exibir os valores da matriz
        exibeMatriz(matriz);

    }
    // Loop para poder printar os valores da matriz
    public static void exibeMatriz(boolean[][] m) {
        // Loop para exibir os valores da matriz
        for (int linha= 0; linha < m.length; linha++ ) {
            for (int coluna=0; coluna < m[linha].length; coluna++){
                System.out.print(m[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }


}
