/* Representa uma classe que implementa 2 pilhas num único vetor */
public class DuasPilhas {
    private int topo1;		/* índice do topo da pilha1 */
    private int topo2;      /* índice do topo da pilha2 */
    private int[] pilha;	/* vetor que representa a pilha */

    /* Construtor - recebe a capacidade da pilha */
    public DuasPilhas(int capacidade) {
        topo1 = -1;				/* inicializa topo1 com -1 */
        topo2 = capacidade;     /* inicializa topo2 com capacidade (tamanho do vetor) */
        pilha = new int[capacidade];	/* cria o vetor da pilha */
    }

    /* Método isEmpty(int nroPilha) - recebe se é a pilha 1 ou a pilha 2
     * devolve true se a pilha nroPilha está vazia
     * e false caso contrário
     */
    public boolean isEmpty(int nroPilha) {
        if (nroPilha == 1) {
            return topo1 == -1;     // pilha 1
        } else {
            return topo2 == pilha.length;   // pilha 2
        }
    }

    /* Método isFull() - devolve true se a pilha está cheia
     * e false caso contrário
     */
    public boolean isFull() {
        return topo1 == topo2 - 1;          // pilha está cheia quando os topos "encostam"
    }


    /* Método push - Recebe se é a pilha 1 ou a 2 e a info a ser empilhada
     */
    public void push(int nroPilha, int info) {
        if (isFull()) {
            System.out.println("Pilha cheia");
        }
        else {
            if (nroPilha == 1) {
                pilha[++topo1] = info;      // Pilha 1
            }
            else {
                pilha[--topo2] = info;      // Pilha 2
            }
        }
    }

    /* Método pop - recebe se quer desempilhar da pilha 1 ou da pilha 2
     * Se a pilha estiver vazia, retorna -1
     */
    public int pop(int nroPilha) {
        if (!isEmpty(nroPilha)) {
            if (nroPilha == 1) {
                return pilha[topo1--];      // pilha 1
            }
            else {
                return pilha[topo2++];      // pilha 2
            }
        }
        return -1;  // pilha vazia
    }

    /* Método peek - Recebe se é pilha 1 ou 2
     * Retorna o elemento do topo da pilha desejada */
    public int peek(int nroPilha) {
        if(!isEmpty(nroPilha)) {
            if (nroPilha == 1) {
                return pilha[topo1];    // pilha 1
            } else {
                return pilha[topo2];    // pilha 2
            }
        }
        return -1;
    }

    /* Método exibePilha - Exibe os elementos da pilha */
    public void exibePilha() {
        if(isEmpty(1)) {
            System.out.println("Pilha 1 está vazia");
        }
        else {
            for(int i = 0; i <= topo1; i++) {
                System.out.println(pilha[i]);
            }
        }
        if(isEmpty(2)) {
            System.out.println("Pilha 2 está vazia");
        }
        else {
            for(int i = pilha.length-1; i >= topo2; i--) {
                System.out.println(pilha[i]);
            }
        }
    }
}
