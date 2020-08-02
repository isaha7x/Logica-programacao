import java.util.Scanner;

public class ReservaAeronave {


    //public class ReservaAeronave {
    static int valorColuna;
    static int numeroLinha;
    static int contador;
    static int valorLinha;
    static int assento;
    static int opcao;
    static char linha;
    static String fileira;
    static Scanner leitor = new Scanner(System.in);
    static boolean[][] assentos;


    public static void main(String[] args) {

        boolean fimTryCatch = false;

        while (!fimTryCatch) {
            try {

                System.out.println("Digite a quantidade de fileiras que a aeronave tem: ");
                valorLinha = leitor.nextInt();
                System.out.println("Digite a quantidade de assentos de uma fileira");
                valorColuna = leitor.nextInt();

                //   for (int i =0; i <4 || i>9; ){


                if ((valorLinha < 4) || (valorLinha >= 9)) {
                    System.out.println("Valor inválido de fileiras! Por favor digite um valor de 4 à 9");
                }

                if ((valorColuna < 15) || (valorColuna > 20)) {
                    System.out.println("Valor inválido de assentos! Por favor digite um valor de 15 à 20");
                } else {
                    break;
                }

            } catch (Exception erro) {
                System.out.println(erro);
            }
        }


        //  while (valorLinha < 15 || valorColuna > 20);

        assentos = new boolean[valorLinha][valorColuna];

        do {
            linha = 65;
            System.out.println(
                    "\n1. Exibir o mapa de assento\n" +
                            "2. Reservar assento\n" +
                            "3. Exibir assentos livres de uma fileira\n" +
                            "4. Sair\n");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("  ");
                    for (int c = 0; c < assentos[0].length; c++) {
                        System.out.printf("%-8d", (c + 1));
                    }
                    System.out.print("\n");
                    for (boolean[] mapaDeAssento : assentos) {
                        System.out.printf("%c ", linha++);
                        for (int c = 0; c < assentos[0].length; c++) {
                            System.out.printf("%-7s ", exibe(mapaDeAssento[c]));
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("Digite a letra da fileira desejada:");
                    fileira = leitor.next();
                    numeroLinha = fileira.charAt(0) - 'A';

                    System.out.println("Digite o número do assento desejado:");
                    assento = leitor.nextInt();

                    if (exibe(assentos[numeroLinha][assento - 1]).equals("Ocupado")) {
                        System.out.println("Este assento já está ocupado");
                    } else if (exibe(assentos[numeroLinha][assento - 1]).equals("Livre")) {
                        System.out.println("A sua reserva foi efetuada com sucesso");
                        assentos[numeroLinha][assento - 1] = true;
                    }
                    break;
                case 3:
                    System.out.println("Digite a letra da fileira:");
                    fileira = leitor.next();
                    numeroLinha = fileira.charAt(0) - 'A';
                    if (numeroLinha > linha) {
                        System.out.println("Fileira inválida!");
                    } else {
                        System.out.println();
                        for (int c = 0; c < assentos[0].length; c++) {
                            if (!assentos[numeroLinha][c]) {
                                System.out.printf("%-8d", (c + 1));
                                contador++;
                            } else {
                                System.out.println("Não há assentos livres nessa fileira");
                                return;
                            }
                        }
                    }
                    break;
                case 4:
                    System.exit(0);
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (true);
    }

    private static String exibe(boolean b) {
        if (b) {
            return "Ocupado";
        } else {
            return "Livre";
        }
    }
}