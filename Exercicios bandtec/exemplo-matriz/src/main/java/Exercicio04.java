import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        String[][] matriz = new String[5][2];

        Scanner leitor = new Scanner(System.in);

        for(int nome = 0; nome < matriz.length; nome++){
            for (int telefone =0; telefone < matriz[0].length; telefone++){
                System.out.println("Digite um nome" + nome + telefone );
                System.out.println("Digite um valor" + telefone);
            }
        }
        // Loop para exibir os valores da matriz
        exibeMatriz(matriz);
    }


    public static void exibeMatriz(String[][] m) {
        // Loop para exibir os valores da matriz
        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                System.out.print(m[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }
}
