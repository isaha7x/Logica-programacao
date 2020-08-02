import java.util.Scanner;

public class ExerciciosMatriz {
    /* Exercício 1 */
    public static void exibeMatriz(int[][] m) {
        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                System.out.print(m[linha][coluna]+"\t");
            }
            System.out.println();
        }
    }

    /* Exercício 6*/
    public static void mediaPares(int[][] m) {
        int[] numerosPares = new int[m.length * m[0].length];
        int indexListaPares = 0;
        int somaPares = 0;

        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                if (m[linha][coluna] % 2 == 0) {
                    numerosPares[indexListaPares] = m[linha][coluna];
                    somaPares += m[linha][coluna];
                    indexListaPares++;
                }
            }
        }

        int quantidadePares = indexListaPares;

        if (somaPares != 0) {
            double media = somaPares / quantidadePares;
            System.out.println("Os número pares na string são: ");
            for (int i = 0; i < quantidadePares; i++){
                System.out.print(numerosPares[i] + "\t");
                System.out.print("\n");
            }
            System.out.println(String.format("A média dos pares é %.2f", media));
        } else {
            System.out.println("Não há números pares nesta matriz.");
        }

    }

    /* Ex em Classe */
    public static void exibeMatrizString(String[][] m) {
        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                System.out.print(m[linha][coluna]+"\t");
            }
            System.out.println();
        }
    }

    /* Exercício 2 */
    public static void somaDuasMatrizesEExibe(int[][] m, int[][] n) {
        int[][] z = new int[m.length][m[0].length];
        if (m.length != n.length) {
            System.out.println("Informe duas matrizes de tamanhos (linhas e colunas) iguais");
        } else {
            for (int linha = 0; linha < m.length; linha++) {
                for (int coluna = 0; coluna < m[linha].length; coluna++) {
                    z[linha][coluna] = m[linha][coluna] + n[linha][coluna];
                }
            }
        }
        exibeMatriz(z);
    }

    /* Ex em Classe */
    public static void exibeMatrizInvertida(int[][] m) {
        for (int coluna = 0; coluna < m[0].length; coluna++) {
            for (int linha = 0; linha < m.length; linha++) {
                System.out.print(m[linha][coluna]+"\t");
            }
            System.out.println();
        }
    }

    /* Ex em Classe */
    public static void exibeMatrizInvertidaSeForIrreg(int[][] m) {
        int linhaMaisLonga = 1;
        for (int k = 0; k < m.length; k++){
            if (m[k].length > linhaMaisLonga){
                linhaMaisLonga = m[k].length;
            }
        }

        for (int coluna = 0; coluna < linhaMaisLonga; coluna++) {
            for (int linha = 0; linha < m.length; linha++) {
                try {
                    System.out.print(m[linha][coluna]+"\t");
                }
                catch(ArrayIndexOutOfBoundsException exception) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    /* Exercício 3 */
    public static void somaColunas(int[][] m){
        int[] soma = new int[m[0].length];
        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {

                soma[coluna] += m[linha][coluna];
            }
        }

        for (int a = 0; a < soma.length; a++){
            System.out.print(soma[a]+"\t");
        }
    }

    /* Exercício 1 */
    public static void populaMatriz(int[][] matriz) {
        Scanner leitor = new Scanner(System.in);
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.println("Digite o valor que quer na posição ["+linha+"]["+coluna+"] da" +
                        " " +
                        "matriz");
                matriz[linha][coluna] = leitor.nextInt();
            }
        }
    }

    /* Ex em Classe */
    public static void listaTelefonica(String[][] matriz) {
        if (matriz[0].length != 2){
            System.out.println("Informe uma matriz com 2 exatamente colunas");
        } else {
            Scanner leitor = new Scanner(System.in);
            for (int linha = 0; linha < matriz.length; linha++) {
                for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                    if (coluna == 0) {
                        System.out.println("Digite o nome do contato");
                        matriz[linha][coluna] = leitor.nextLine();
                    } else if (coluna == 1) {
                        System.out.println("Digite o telefone do contato");
                        matriz[linha][coluna] = leitor.nextLine();
                    }
                }
            }
            exibeMatrizString(matriz);
        }
    }

    /* Exercício 4 */
    public static void buscaNaMatrizDeString(String[][] matriz, String queroAchar){
        boolean encontrou = false;
        String telEncontrou = "";

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][0].equals(queroAchar)) {
                encontrou = true;
                telEncontrou = matriz[linha][1];
            }
        }

        if (encontrou) {
            System.out.println("O contato "+queroAchar+" foi encontrado. Seu telefone é "+telEncontrou);
        } else {
            System.out.println("O contato "+queroAchar+" não foi encontrado.");
        }
    }

    /* Exercício 5 */
    public static void criaMatrizCom2Vetores(int[] m, int[] n) {
        int[][] matrizResult = new int[m.length][2];
        for (int i = 0; i < m.length; i++) {
            matrizResult[i][0] = m[i];
            matrizResult[i][1] = n[i];
        }
        exibeMatriz(matrizResult);
    }

    /* Exercício 7 */
    public static void maiorEmenor(int[][] m) {
        int maiorNumero = 0;
        int linhaMaiorN = 0;
        int colunaMaiorN = 0;
        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                if (m[linha][coluna] > maiorNumero) {
                    maiorNumero = m[linha][coluna];
                    linhaMaiorN = linha;
                    colunaMaiorN = coluna;
                }
            }
        }

        int menorNumero = maiorNumero;
        int linhaMenorN = 0;
        int colunaMenorN = 0;
        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                if (m[linha][coluna] < menorNumero) {
                    menorNumero = m[linha][coluna];
                    linhaMenorN = linha;
                    colunaMenorN = coluna;
                }
            }
        }
        System.out.println();
        System.out.println("O maior número é "+maiorNumero+
                " na posição: ["+linhaMaiorN+"]["+colunaMaiorN+"]");
        System.out.println("O maior número é "+menorNumero+
                " na posição: ["+linhaMenorN+"]["+colunaMenorN+"]");
    }

    /* Exercício 8 */
    public static void somaDiagonais(int[][] m) {
        int somaDiagonalDireita = 0;
        int somaDiagonalEsquerda = 0;
        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                if (linha == coluna) {
                    somaDiagonalDireita += m[linha][coluna];
                }
                if (linha + coluna == m.length -1) {
                    somaDiagonalEsquerda += m[linha][coluna];
                }
            }
        }

        System.out.println("A soma da diagonal da direita é "+somaDiagonalDireita);
        System.out.println("A soma da diagonal da esquerda é "+somaDiagonalEsquerda);
    }

    /* Exercício 9 */
    public static void multiplicaMatriz(int[][] m, int[][] n) {
        int[][] matriz3 = new int[m.length][n[0].length];

        for (int linhaFixa = 0; linhaFixa < matriz3.length; linhaFixa++) {
            for (int colunaFixa = 0; colunaFixa < matriz3[linhaFixa].length; colunaFixa++) {
                for (int numeroVaria = 0; numeroVaria < m[0].length; numeroVaria++) {
                    matriz3[linhaFixa][colunaFixa] += m[linhaFixa][numeroVaria] * n[numeroVaria][colunaFixa];
                }
            }
        }

        exibeMatriz(matriz3);
    }

    /* Exercício 11 */
    public static boolean isQuadradoMagico(int[][] m){
        if (m.length != m[0].length) {
            return false;
        } else {
            int somaDiagonalDireita = 0;
            int somaDiagonalEsquerda = 0;
            int somaLinha0 = 0;
            int somaLinha1 = 0;
            int somaLinha2 = 0;
            int somaCol0 = 0;
            int somaCol1 = 0;
            int somaCol2 = 0;
            for (int linha = 0; linha < m.length; linha++) {
                for (int coluna = 0; coluna < m[linha].length; coluna++) {
                    if (linha == coluna) {
                        somaDiagonalDireita += m[linha][coluna];
                    }
                    if (linha + coluna == m.length - 1) {
                        somaDiagonalEsquerda += m[linha][coluna];
                    }

                    if (linha == 0) {
                        somaLinha0 += m[linha][coluna];
                    } else if (linha == 1) {
                        somaLinha1 += m[linha][coluna];
                    } else if (linha == 2) {
                        somaLinha2 += m[linha][coluna];
                    }

                    if (coluna == 0) {
                        somaCol0 += m[linha][coluna];
                    } else if (coluna == 1) {
                        somaCol1 += m[linha][coluna];
                    } else if (coluna == 2) {
                        somaCol2 += m[linha][coluna];
                    }
                }
            }

            if (somaDiagonalDireita == somaDiagonalEsquerda &&
                    somaLinha0 == somaLinha1 &&
                    somaLinha0 == somaLinha2 &&
                    somaCol0 == somaCol1 &&
                    somaCol0 == somaCol2 &&
                    somaDiagonalDireita == somaLinha0 &&
                    somaDiagonalDireita == somaCol0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------");
        System.out.println("------------Primeiro exercício:------------------");
        System.out.println("-------------------------------------------------");
        int[][] ex1 = new int[2][3];
        /*populaMatriz(ex1);
        exibeMatriz(ex1);*/

        System.out.println("-------------------------------------------------");
        System.out.println("------------Segundo exercício:-------------------");
        System.out.println("-------------------------------------------------");
        int[][] ex2M1 = { {1,2}, {3,4}, {5,6} };
        int[][] ex2M2 = { {2,3}, {4,5}, {6,7} };
        somaDuasMatrizesEExibe(ex2M1, ex2M2);

        System.out.println("-------------------------------------------------");
        System.out.println("------------Terceiro exercício:------------------");
        System.out.println("-------------------------------------------------");
        int[][] ex3M1 ={ {1, 2, 3}, {4 , 5, 6}, {7, 8, 9} };
        somaColunas(ex3M1);
        System.out.println();

        System.out.println("-------------------------------------------------");
        System.out.println("------------Quarto exercício:--------------------");
        System.out.println("-------------------------------------------------");
        /*String[][] ex4M1 = new String[5][2];
        listaTelefonica(ex4M1);
        System.out.println("Quem você quer achar?");
        Scanner leitor = new Scanner(System.in);
        buscaNaMatrizDeString(ex4M1, leitor.nextLine());*/

        System.out.println("-------------------------------------------------");
        System.out.println("------------Quinto exercício:--------------------");
        System.out.println("-------------------------------------------------");
        int[] vetor1 = {10, 20, 30, 40};
        int[] vetor2 = {50, 60, 70, 80};
        criaMatrizCom2Vetores(vetor1, vetor2);
        System.out.println();

        System.out.println("-------------------------------------------------");
        System.out.println("------------Sexto exercício:---------------------");
        System.out.println("-------------------------------------------------");
        /*
        Scanner leitorEx6 = new Scanner(System.in);
        System.out.println("Quantas linhas?");
        int numLinhas = leitorEx6.nextInt();
        System.out.println("Quantas colunas?");
        int numColunas = leitorEx6.nextInt();
        int[][] vetorEx6 = new int[numLinhas][numColunas];
        populaMatriz(vetorEx6);
        System.out.println("Esta é a sua matriz:");
        exibeMatriz(vetorEx6);
        mediaPares(vetorEx6);
        */

        System.out.println("-------------------------------------------------");
        System.out.println("------------Sétimo exercício:--------------------");
        System.out.println("-------------------------------------------------");
        System.out.println();
        int[][] vetorEx7 = { {5,2,3,4}, {10, 1, 30, 40}, {90, 60, 70, 55} };
        System.out.println("Esta é a sua matriz:");
        exibeMatriz(vetorEx7);
        maiorEmenor(vetorEx7);

        System.out.println("-------------------------------------------------");
        System.out.println("------------Oitavo exercício:--------------------");
        System.out.println("-------------------------------------------------");
        /*
        Scanner leitorEx8 = new Scanner(System.in);
        System.out.println("Sua matriz quadrada tem quais tamanho (NxN)?");
        int numQuadrado = leitorEx8.nextInt();
        int[][] matrizEx8;
        if (numQuadrado < 1 || numQuadrado > 6) {
            System.out.println("O tamanho deve ser de 1 a 6");
        } else {
            matrizEx8 = new int[numQuadrado][numQuadrado];
            populaMatriz(matrizEx8);
            somaDiagonais(matrizEx8);
        }
        */
        System.out.println("-------------------------------------------------");
        System.out.println("------------Nono exercício:----------------------");
        System.out.println("-------------------------------------------------");
        int[][] matriz1 ={ {1,2,3,4}, {5, 6, 7, 8}, {9, 10, 11, 12} };
        int[][] matriz2 ={ {10, 20}, {30, 40},{50, 60},{70, 80}, };
        if (matriz1[0].length != matriz2.length) {
            System.out.println("Essas matrizes não são multiplicáveis");
        } else {
            multiplicaMatriz(matriz1,matriz2);
        }

        System.out.println("-------------------------------------------------");
        System.out.println("------------Décimo exercício:--------------------");
        System.out.println("-------------------------------------------------");
        int[][] matriz10 = { {1, 2, 3}, {4 , 5, 6} };
        System.out.println("Matriz normal:");
        exibeMatriz(matriz10);
        System.out.println("Matriz invertida:");
        exibeMatrizInvertida(matriz10);

        System.out.println("-------------------------------------------------");
        System.out.println("------------Décimo-primeiro exercício:-----------");
        System.out.println("-------------------------------------------------");
        int [][] matriz11 = { {2, 7, 6}, {9, 5, 1}, {4, 3, 8} };
        System.out.println("Seu quadrado é o abaixo:");
        exibeMatriz(matriz11);
        if (isQuadradoMagico(matriz11)){
            System.out.println("É um quadrado mágico!");
        } else {
            System.out.println("Não é um quadrado mágico");
        }

    }
}
