import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProjetoBibliotex {

    public static void gravaLista(ListaObj<Livros> lista, boolean isCSV) {
        FileWriter arq = null;		// objeto FileWriter - representa o arquivo
        Formatter saida = null;		// objeto Formatter para executar saída formatada
        boolean deuRuim = false;	// indica se deu erro
        String nomeArquivo;			// nome do arquivo

        if (isCSV) {
            nomeArquivo= "aluno.csv";	// nome do arquivo, se for CSV
        }
        else {
            nomeArquivo= "erro";	// nome do arquivo, se for TXT
        }

        /* Abre o arquivo para escrita e de forma
         * que grave sempre no final do arquivo, sem apagar o que
         * já está gravado no arquivo (append)
         *
         * Vamos tratar esse arquivo como um objeto Formatter
         * para poder gravar usando format
         */
        try {
            arq = new FileWriter(nomeArquivo, true);  // true indica que vai fazer "append"
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);  // encerra o programa, com status de erro
        }

        // Grava no arquivo os dados dos objetos Aluno que estão na lista
        try {
            // percorre a lista de objetos Aluno
            for (int i=0; i< lista.getTamanho(); i++) {
                Livros livros = lista.getElemento(i);
                // Grava os atributos do objeto aluno no arquivo
                // O %n indica que será gravado um fim de registro
                // No Windows, o fim de registro é um \r\n
                // No Linux e no MacOS, o fim de registro é um \n
                if (isCSV) {
                    saida.format("%s;%s;%s;%s;%d;%s",livros.getTitulo(),
                            livros.getIsbn(),livros.getEdicao(), livros.getAno(), livros.getPaginas(),livros.getEditora());
                }
                else {
                    System.out.println("ERR");
                }
            }
        }
        catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim= true;
        }
        finally { // bloco finally é executado independente de dar erro ou não
            // usado para fechar os objetos saida e close.
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

    /* Método leExibeArquivo - lê e exibe os registros de um arquivo
     * Recebe true se o arquivo a ser lido é o aluno.csv e false se for o aluno.txt
     */
    public static void leExibeArquivo(boolean isCSV) {
        FileReader arq= null;		// objeto FileReader - representa o arquivo a ser lido
        Scanner entrada = null;		// objeto Scanner - para ler do arquivo
        String nomeArquivo;			// nome do arquivo
        boolean deuRuim= false;		// indica se deu erro

        if (isCSV) {
            nomeArquivo= "aluno.csv";	// nome do arquivo, se for CSV
        }
        else {
            nomeArquivo= "err";	// nome do arquivo, se for TXT
        }

        // Abre o arquivo para leitura
        try {
            arq = new FileReader(nomeArquivo);
            if (isCSV) {
                // se o arquivo for CSV, usa como delimitador de campo o ';' e o fim de registro
                entrada = new Scanner(arq).useDelimiter(";|\\r\\n");
            }
            else {
                // se o arquivo for TXT, usa como delimitador de campo o ' ' e o fim de registro
                //entrada = new Scanner(arq);
            }
        }
        catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1); // encerra o programa, com status de erro
        }

        // Lê os registros do arquivo e exibe os dados lidos na console
        try {
            // Exibe na console os títulos das colunas
            System.out.printf("%-8s%-10s%7s%7s%17s%20s\n","Título","ISBN","Edição", "Ano","Páginas", "Editora" );

            // Enquanto tem registro a ser lido
            while (entrada.hasNext()) {
                String titulo = entrada.next();				// Lê o RA
                String isbn = entrada.next();			// Lê o nome
                String edicao = entrada.next();	 	// Lê a nota
                String ano = entrada.next();	// Lê a nota
                int paginas = entrada.nextInt(); 		// Lê a nota
                String editora = entrada.next();		// Lê a nota

                System.out.printf("%7s %-10s %7s %7s %10d %7s", titulo, isbn, edicao,ano,paginas,editora);	// Exibe na console em colunas

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
        boolean fim = false;		// indica fim do programa
        String titulo;						// usado para ler o RA do aluno
        String isbn;				// usado para ler o nome do aluno
        String edicao;				// usado para ler o nome do aluno
        String ano;				// usado para ler o nome do aluno
        int paginas;				// usado para ler o nome do aluno
        String editora;				// usado para ler o nome do aluno
        int opcao;

        // Criação da lista que vai conter objetos Aluno
        ListaObj<Livros> lista = new ListaObj(6);

        while (!fim) {	// Fica num loop até que o usuário escolha Fim
            // Exibe o menu de opções para o usuário
            System.out.println("\nEscolha uma das opções:");
            System.out.println("1- Adicionar um livro");
            System.out.println("2- Exibir a lista");
          //  System.out.println("3- Gravar a lista num arquivo txt");
            System.out.println("4- Gravar a lista num arquivo csv");
         //   System.out.println("5- Ler e exibir arquivo txt");
            System.out.println("6- Ler e exibir arquivo csv");
            System.out.println("7- Fim");
            // Lê a opção digitada pelo usuário
            opcao = leitor.nextInt();

            switch(opcao) {
                // Opção 1 - Adicionar um aluno
                case 1:
                    // Solicita que o usuário digite o RA, nome e nota do aluno, e lê os valores
                    System.out.println("Digite o título do livro");
                    titulo= leitor.next();
                    System.out.println("Digite o ISBN do livro");
                    isbn= leitor.next();
                    System.out.println("Digite a edição do livro");
                    edicao= leitor.next();
                    System.out.println("Digite o ano do livro");
                    ano= leitor.next();
                    System.out.println("Digite a quantidade de páginas do livro");
                    paginas= leitor.nextInt();
                    System.out.println("Digite a editora do livro");
                    editora= leitor.next();
                    // Cria um objeto aluno inicializando os atributos com os valores digitados pelo usuário
                    Livros livros = new Livros(titulo,isbn,edicao,ano,paginas,editora);
                    // Adiciona esse objeto à lista de alunos
                    lista.adiciona(livros);
                    break;

                // Opção 2 - Exibir a lista
                case 2:
                    if (lista.getTamanho() == 0)  {
                        System.out.println("Lista vazia");
                    }
                    else {
                        lista.exibe();
                    }
                    break;

                // Opção 3 - Gravar a lista num arquivo txt
                case 3:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há o que gravar.");
                    }
                    else {
                        gravaLista(lista, false); // Chama o método gravaLista para gravar a lista num arquivo txt
                        lista.limpa();			  // Limpa a lista
                    }
                    break;

                // Opção 4 - Gravar a lista num arquivo csv
                case 4:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há o que gravar.");
                    }
                    else {
                        gravaLista(lista, true);  // Chama o método gravaLista para gravar a lista num arquivo csv
                        lista.limpa();			  // Limpa a lista
                    }
                    break;

                // Opção 5 - Ler e exibir arquivo txt
                case 5:
                    leExibeArquivo(false);
                    break;

                // Opção 6 - Ler e exibir arquivo csv
                case 6:
                    leExibeArquivo(true);
                    break;

                // Opção 7 - Fim
                case 7:
                    fim = true;
                    break;

                // Opção diferente de 1 a 7
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
