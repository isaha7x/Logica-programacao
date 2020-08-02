import java.util.Scanner;

public class Continuada2 {
    static String[] aluno; //= new String[maxAluno];
    static int falta[][];  //= new int[maxAluno][2];
    static int total[];// = new int[];


    public static void main(String[] args) {
           int maxAlun = 0;


        Scanner leitor = new Scanner(System.in);

        while (maxAlun < 6 || maxAlun > 40){
            try {
                System.out.println("Digite o valor maximo de aluno que tem na disciplina de Estrutura de dados: ");

                maxAlun = leitor.nextInt();
                if ((maxAlun < 6 || maxAlun > 40))
                    throw new Exception("Valor de alunos inválido ! Por favor digite um número entre 6" +
                            " e 40");
            }
            catch (Exception erro) {
                System.out.println(erro);
            }
        }

        aluno = new String[maxAlun];
        falta = new int[maxAlun][2];
        total = new int[maxAlun];

        // for para percorrer a lista com o numero de alunos que eu quero

        for (int i =0; i < aluno.length; i ++ ) {
            System.out.println("Digite o nome " +(i+1) + "° aluno");
            aluno[i] = leitor.next();
        }

        for (int linha =0; linha < falta.length; linha++){
            for(int coluna =0; coluna < falta[0].length; coluna++) {
                System.out.println("Digite a  quantidade de faltas do " + (linha + 1) + "° aluno");
                System.out.println("1° e 2° bimestre de cada aluno");
                falta[linha][coluna] = leitor.nextInt();
                total[linha] += falta[linha][coluna] ;
            }


        }

        System.out.printf("%-30s%20s%20s%20s\n", "Nome", "1° Bimestre", "2° Bimestre","Total");
        System.out.println("---------------------------------------------------------------------------------------------");
        for(int i =0; i < aluno.length; i++){

         //   System.out.println("---------------------------------            System.out.printf("%-20s%25d%20d%22d\n", aluno[i], falta[i][0], falta[i][1], total[i]);---------------------------------------------------------");

        }




    }
}
