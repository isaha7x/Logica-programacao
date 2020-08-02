// O programa irá cadastrar os shows do Lollapalooza e quantas pessoas compraram ingresso;
// e quantas pessoas compareceram no lolla;
// E pode pesquisar por banda para ver se a banda esteve no show ou nao;


import java.util.Scanner;

public class Lollapalooza {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String[] show = new String[5];

        int n = 5;
        int v[] = new int[n];
        int i;

        for(int contador = 0; contador < show.length; contador++){
            System.out.println("Digite o nome do show:");
            show[contador] = ler.next();
            System.out.println(contador);
        }

// Entrada de Dados
        for (i=0; i<n; i++) {
            System.out.printf("Informe quantos ingressos foram vendidos do %2dº. show cadastrado:", (i+1), n);
            v[i] = ler.nextInt();
        }

// Processamento: definir o maior e o menor valor
        int soma = 0;
        int menor = v[0];
        int maior = v[0];
        for (i=0; i<n; i++) {
            soma = soma + v[i];

            if (v[i] < menor)
                menor = v[i];

            if (v[i] > maior)
                maior = v[i];
        }

// Saída (resultados)


        System.out.printf("\n");
        for (i=0; i<n; i++) {
            if (v[i] == menor)
                System.out.printf("Show[%d] = %2d <--- Show com menos pessoas\n", i,v[i]);
            else if (v[i] == maior)
                System.out.printf("Show[%d] = %2d <--- Show com mais pessoas\n", i, v[i]);
            else System.out.printf("Show[%d] = %2d\n", i, v[i]);
        }

        System.out.printf("\n Compareceram o total de %d pessoas em todo o evento\n", soma );

        System.out.println("\nPesquise por uma banda: ");
        String inputUsuario = ler.next();
        int indiceEncontrado = -1;

        for(int contador = 0; contador < show.length; contador++){
            if(inputUsuario.equals(show[contador])){
                indiceEncontrado = contador;
                break;
            }
        }


        // Procurar o valor, usando variável booleana
        boolean achou = false;
        for(int contador = 0 ; contador < show.length && !achou; contador++){
            if(inputUsuario.equals(show[contador])){
                System.out.println("Esse show está no Lolla esse ano e foi a "+ (contador +1) +"° banda a tocar");
                achou = true;
            }
        }

        if(!achou){
            System.out.println("Essse show não está no lolla esse ano :( ");
        }

    }
    }



