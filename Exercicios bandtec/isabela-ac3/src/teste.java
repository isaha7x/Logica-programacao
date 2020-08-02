import java.util.Scanner;

public class teste {


    public static void main(String[] args) {
        int[] v =  new int[10];

        FilaPilha filaPositivo = new FilaPilha(v.length);
        Scanner leitor = new Scanner(System.in);


        for (int i=0; i < v.length; i++) {
            System.out.println("Digite um número");
            v[i] = leitor.nextInt();
            if (v[i] >= 0) {
                filaPositivo.insert(v[i]);
            }
            else {

            }
        }

        while (!filaPositivo.isFilaEmpty()) {
            System.out.print(filaPositivo.poll() + "\t");
        }

        while (!filaPositivo.isPilhaEmpty()) {
            System.out.print(filaPositivo.poll() + "\t");
        }

    }
}
