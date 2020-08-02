
 import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

    public class TesteLivro {

        public static void gravaLista(ListaObj<Livro> lista, boolean isCSV) {
            FileWriter arq = null;
            Formatter saida = null;
            boolean deuRuim = false;
            String nomeArquivo;

            if (isCSV) {
                nomeArquivo= "livro.csv";
            }
            else {
                nomeArquivo= "livro.txt";
            }

            try {
                arq = new FileWriter(nomeArquivo, true);
                saida = new Formatter(arq);
            }
            catch (IOException erro) {
                System.err.println("Erro ao abrir arquivo");
                System.exit(1);
            }

            try {

                for (int i=0; i< lista.getTamanho(); i++) {
                    Livro livro = lista.getElemento(i);

                    if (isCSV) {
                        saida.format("%d;%s;%.2f%n;%d;%s;",livro.getIdLivro(),
                              livro.getAutor(), livro.getPreco(), livro.getTitulo(), livro.getQtdPagina()  );	                   }
                    else {
                        saida.format("%d %s %.2f%n",livro.getIdLivro(),
                                livro.getAutor(), livro.getPreco(), livro.getTitulo(), livro.getQtdPagina());
                    }
                }
            }
            catch (FormatterClosedException erro) {
                System.err.println("Erro ao gravar no arquivo");
                deuRuim= true;
            }
            finally {
                saida.close();
                try {
                    arq.close();
                }
                catch (IOException erro) {
                    System.err.println("Erro ao fechar arquivo.");
                    deuRuim = true;
                }
                if (deuRuim) {
                    System.exit(1);
                }
            }
        }

        public static void leExibeArquivo(boolean isCSV) {
            FileReader arq= null;
            Scanner entrada = null;
            String nomeArquivo;
            boolean deuRuim= false;

            if (isCSV) {
                nomeArquivo= "livro.csv";
            }
            else {
                nomeArquivo= "livro.txt";
            }

            try {
                arq = new FileReader(nomeArquivo);
                if (isCSV) {
                    entrada = new Scanner(arq).useDelimiter(";|\\r\\n");
                }
                else {
                    entrada = new Scanner(arq);
                }
            }
            catch (FileNotFoundException erro) {
                System.err.println("Arquivo não encontrado");
                System.exit(1);
            }


            try {

                System.out.printf("%-8s%-10s%7s%8s%10s\n","ID","TITULO","AUTOR","PRECO", "PAGINAS" );

                while (entrada.hasNext()) {
                    int idLivro = entrada.nextInt();
                    String titulo = entrada.next();
                    String autor = entrada.next();
                    double preco =entrada.nextDouble();
                    int qtdPaginas = entrada.nextInt();
                    System.out.printf("%-8d%-10s%-10s%.2f%06d \n",idLivro,titulo,autor, preco, qtdPaginas);
                }
            }
            catch (NoSuchElementException erro)
            {
                System.err.println("Arquivo com problemas.");
                deuRuim = true;
            }
            catch (IllegalStateException erro)
            {
                System.err.println("Erro na leitura do arquivo.");
                deuRuim = true;
            }
            finally {
                entrada.close();
                try {
                    arq.close();
                }
                catch (IOException erro) {
                    System.err.println("Erro ao fechar arquivo.");
                    deuRuim = true;
                }
                if (deuRuim) {
                    System.exit(1);
                }
            }
        }

        public static void main(String[] args) {
            Scanner leitor = new Scanner(System.in);
            boolean fim = false;
            int idLivro;
            String titulo;
            String autor;
            double preco;
            int qtdPaginas;

            int opcao;


            ListaObj<Livro> lista = new ListaObj(5);

            while (!fim) {
                System.out.println("\nEscolha uma das opções:");
                System.out.println("1- Adicionar um livro");
                System.out.println("2- Exibir a lista");
                System.out.println("3- Gravar a lista num arquivo txt");
                System.out.println("4- Gravar a lista num arquivo csv");
                System.out.println("5- Ler e exibir arquivo txt");
                System.out.println("6- Ler e exibir arquivo csv");
                System.out.println("7- Fim");

                opcao= leitor.nextInt();

                switch(opcao) {

                    case 1:

                        System.out.println("Digite o Id do livro");
                        idLivro= leitor.nextInt();
                        System.out.println("Digite o título do livro");
                        titulo= leitor.next();
                        System.out.println("Digite o autor do livro");
                        autor= leitor.next();
                        System.out.println("Digite o preço do livro");
                        preco= leitor.nextDouble();
                        System.out.println("Digite a quantidade de páginas do livro");
                        qtdPaginas= leitor.nextInt();

                        Livro livro = new Livro(idLivro,titulo,autor,preco,qtdPaginas);

                        lista.adiciona(livro);
                        break;


                    case 2:
                        if (lista.getTamanho() == 0)  {
                            System.out.println("Lista vazia");
                        }
                        else {
                            lista.exibe();
                        }
                        break;


                    case 3:
                        if (lista.getTamanho() == 0) {
                            System.out.println("Lista vazia. Não há o que gravar.");
                        }
                        else {
                            gravaLista(lista, false);
                            lista.limpa();
                        }
                        break;



                    case 5:
                        leExibeArquivo(false);
                        break;


                    case 6:
                        leExibeArquivo(true);
                        break;


                    case 7:
                        fim = true;
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
        }

    }

