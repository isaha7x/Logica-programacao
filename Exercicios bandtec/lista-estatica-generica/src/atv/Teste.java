package atv;

public class Teste {
    public static void main(String[] args) {
        ListaObj<String> lista = new ListaObj(5);
        lista.adicionarVetor("elemento1");
        lista.adicionarVetor("elemento2");
        lista.adicionarVetor("elemento3");
        lista.adicionarVetor("elemento4");
        lista.adicionarVetor("elemento5");

        lista.exibe();
        System.out.println(lista.getTamanho());
        System.out.println(lista.getElemento(2));
    }
}
