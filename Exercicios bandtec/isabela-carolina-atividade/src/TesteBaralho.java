import java.util.Scanner;

public class TesteBaralho {

    public static void main(String[] args) {
      //  PilhaObj pilhaObj = new PilhaObj(52);
        Baralho baralho = new Baralho();

        // 02
    // baralho.exibe

        // 03
        baralho.embaralhar();
       // public Baralho baralho1 {}

        //04
        // baralho.exibe

        //05
        baralho.embaralhar();

        //06
        System.out.println("Digite um valor entre 2 e 9");
        Scanner leitor = new Scanner(System.in);
        Integer var =leitor.nextInt();
        boolean fim = false;
        while(!fim){
            if(var < 2 || var >9){
                System.out.println("Valor inválido");
            }
        }



      ;//  System.out.println("Desempilhou: " + baralho.pop());
        System.out.println();


    }
}
