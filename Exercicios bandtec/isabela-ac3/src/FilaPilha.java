public class FilaPilha<T> {
    private int tamanho;
    private int topo;
    private T[] filaPilha;


    public FilaPilha(int capacidade) {
        tamanho = 0;
        filaPilha = (T[]) new Object[capacidade];
    }

    public boolean isFilaEmpty()
    {
        return tamanho == 0;
    }

    public boolean isPilhaEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return tamanho == filaPilha.length;
    }

    public void insert(T info) {
        if (isFull()) {
            System.out.println("Fila cheia");
        }
        else {
            filaPilha[tamanho++] = info;
        }
    }

    public T peek() {
        return filaPilha[0];
    }

    public int pop() {
        if (!isPilhaEmpty()) {
            return (int) filaPilha[topo--];
        }
        return -1;
    }

    public T poll() {
        T primeiro = peek();     // Salva o primeiro da fila numa variável

        if (!isFilaEmpty()) {   // Se a fila não estiver vazia

            for (int i = 0; i < tamanho - 1; i++) {
                filaPilha[i] = filaPilha[i + 1];
            }

            filaPilha[tamanho - 1] = null;

            tamanho--;
        }

        return primeiro;
    }

    public void exibeFila() {
        if (isFilaEmpty()) {
            System.out.println("Fila vazia");
        } else {
            for (int i = 0; i < tamanho; i++) {
                System.out.println(filaPilha[i]);
            }
        }
    }

    public void exibePilha() {
        if(isPilhaEmpty()) {
            System.out.println("Pilha vazia");
        }
        else {
            for(int i = 0; i <= topo; i++) {
                System.out.println(filaPilha[i]);
            }
        }

    }



}
