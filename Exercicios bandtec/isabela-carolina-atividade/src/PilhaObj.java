public class PilhaObj<T> {
    //Baralho baralho = new Baralho();

    private int topo;
    private int capacidade;
    ///  private String[] pilha;
    T[] pilha = (T[]) new Object [capacidade];

    public PilhaObj(int capacidade) {
        topo = -1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return (topo == pilha.length - 1);
    }

    public void push(T info) {
        if (!isFull()) {
            pilha[++topo] = info;
        }
        else {
            System.out.println("Pilha cheia");
        }
    }

    public T pop() {
        if (!isEmpty()) {
            return pilha[topo--];
        }
        return null;
    }

    public T peek() {
        if(!isEmpty()) {
            return pilha[topo];
        }
        return null;
    }

    public void exibe() {
        if(isEmpty()) {
            System.out.println("Pilha vazia");
        }
        else {
            for(int i = 0; i <= topo; i++) {
                System.out.println(pilha[i]);
            }
        }

    }


}



