
import java.io.*;

public class test2 {

    public static void main(String[] args) {
        try {
            // Conteudo
            StringBuilder livros = new StringBuilder();
            livros.append("Java para leigos>").append("A culpa é daas estrelas>").append("Romeu e Julieta>").append("Omundo de Sophia");
         //   String content = "Esse aqui é o teste para ver se ta exportando para um arquivo txt mesmo";


            // Cria arquivo
            File file = new File("testeNew.txt");

            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
            }

            // Prepara para escrever no arquivo
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Escreve e fecha arquivo
            bw.write(String.valueOf(livros));
            bw.close();

            // Le o arquivo
            FileReader ler = new FileReader("teste.txt");
            BufferedReader reader = new BufferedReader(ler);
            String linha;
            while( (linha = reader.readLine()) != null ){
                System.out.println(linha);
            }

            // Imprime confirmacao
            System.out.println("Feito =D");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






