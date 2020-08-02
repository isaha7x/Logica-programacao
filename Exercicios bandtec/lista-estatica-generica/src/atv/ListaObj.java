package atv;

public class ListaObj <T> {
    private T[] vetor;
    private int nroElem;

    public ListaObj  (int nroElem) {
        this.vetor = (T[]) new Object [nroElem];
        this.nroElem = 0;
    }

    public boolean adicionarVetor(T elemento) {
        if (nroElem >= vetor.length) {
            return false;
        }
        vetor[nroElem++] = elemento;
        return true;
    }

    public void exibe(){
        for (int i = 0; i <nroElem ; i++) {
            System.out.println(String.format("Item %s : %s ", i,vetor[i]));
        }
    }


    public int busca(T elemento){
        int indice = -1;

        for(int i = 0; i < nroElem; i++) {
            if(vetor[i] == elemento){
                indice = i;
            }
        }

        return indice;
    }

    public boolean removePeloIndice(int indice){
        if(indice < 0 || indice > nroElem){
            return false;
        }

        vetor[indice] = null;

        for (int i = indice +1; i < nroElem; i ++) {
            vetor[i - 1] = vetor[i];
        }

        nroElem --;

        return true;
    }

    public boolean removeElemento (T elemento) {
        int indice = busca(elemento);

        boolean removeu = removePeloIndice(indice);

        return removeu;
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice){
    if (indice < 0 || indice > nroElem || indice == nroElem){
        return null;
    }else {
        return vetor[indice];
    }
    }
    public void limpa(){
        nroElem =0;
    }


}
