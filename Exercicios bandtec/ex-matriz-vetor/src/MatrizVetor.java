import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class MatrizVetor {

    // static para poder acessar
    static String[] aluno;
    static double notas[][];
    static double media[];
    public static void main(String[] args) {

        // Guarda o valor maximo de aluno que o usuário digitar
        int maxAluno = 0;


        Scanner leitor = new Scanner(System.in);

        // Estrutura de repetição
        // Repetir essa estrutura até o usuário digitar um valor válido entre 5 e 15
        // Dentro do while mandamos uma exceção para o usuário caso digite o valor errado
        while (maxAluno < 5 || maxAluno > 15){
        try {
            System.out.println("Digite o valor maximo de aluno: ");

            maxAluno = leitor.nextInt();
            if ((maxAluno < 5 || maxAluno > 15))
                throw new Exception("Digite um número entre 5" +
                        " e 15");
        }
        catch (Exception erro) {
            System.out.println(erro);
        }
        }

        // Instanciando os vetores e matriz que declaramos em cima
        aluno = new String[maxAluno];
        notas = new double[maxAluno][2];
        media =  new double[2];

        // Estrutura de repetição
        // Enquanto a quantidade de alunos que o usuário digitou for < que o contador, continua adicionando ++
       for (int i =0; i < aluno.length; i ++ ) {
           // solicitando que o usuário digite a nome do aluno
           System.out.println("Digite o nome " +(i+1) + "° aluno");
           aluno[i] = leitor.next();
       }

       // Estrutura de repetição
       // Enquanto a quantidade de notas for < que o contador, continua adicionando ++
        for (int linha =0; linha < notas.length; linha++){
            // enquanto "coluna" for menor que a posição do vetor, continua adicionando
            for(int coluna =0; coluna < notas[0].length; coluna++){
                // solicitando que o usuário digite os valores da notas
                System.out.println("Digite o valor da " + (linha + 1) + "° nota");
                notas [linha] [coluna] = leitor.nextInt();
                System.out.println(" --------------------------");

            }
        }

        //calculo media
        // Variavel "linha" iniciando com zero. Enquanto "linha" for < que o número de notas, continua se repetindo
        for (int linha=0; linha < notas.length; linha++){

            // Enquanto "coluna" for menor que a posição do vetor, continua adicionando
            for(int coluna=0; coluna <notas[0].length; coluna++){

                // vetor media vai receber o valor "coluna", obter o valor de cada linha de cada coluna,
                // Junto do += para ele pegar todos os valores e não só o último
                //depois de obter todos esses valores divide pela quantidade de alunos que existe para fazer o calculo de média
                media[coluna] += (notas[linha][coluna]) /aluno.length ;
            }
        }
        // Printando os o nome das colunas com formatação
        System.out.printf("%-30s%20s%20s\n", "NOME DO ALUNO", "NOTAS DA C1", "NOTAS DA C2");

        // Estrutura de repetição para mostrar todos os valores no formato de colunas
        // Enquanto "i" for menor que o numero de alunos, continua adicionando os valores digitados
        for(int i =0; i < aluno.length; i++){
                                                                    // mesma linha de nota do aluno [0]
                                                                     // [1] para percorrer a segunda coluna
            System.out.printf("%-30s%20.2f%20.2f\n", aluno[i], notas[i][0], notas[i][1]);

        }
        // printar uma linha dizendo qual é a medias das colunas
        //media[0], media[1] para pegar os valores da posição zero e 1 das colunas
        System.out.printf("%-30s%20.2f%20.2f\n", "MEDIA", media[0], media[1]);



    }

        }

