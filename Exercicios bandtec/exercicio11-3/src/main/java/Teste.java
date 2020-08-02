public class Teste {

    public static void main(String[] args) {
        int[] v = {2, 7, -3, -50, 45, -4, 30, -21, 38};

        // Cria objeto filaPositivo para armazenar os valores positivos do vetor
        FilaObj<Integer> filaPositivo = new FilaObj<Integer>(v.length);

        // Cria objeto pilhaNegativo para armazenar os valores negativos do vetor
        Pilha pilhaNegativo = new Pilha(v.length);

        // Percorre o vetor, enfileirando os positivos na fila e empilhando os negativos na pilha
        for (int i=0; i < v.length; i++) {
            if (v[i] >= 0) {
                filaPositivo.insert(v[i]);
            }
            else {
                pilhaNegativo.push(v[i]);
            }
        }

        // Exibe os valores positivos na mesma ordem que estavam no vetor
        while (!filaPositivo.isEmpty() ) {                  // enquanto a fila de positivos não está vazia
            System.out.print(filaPositivo.poll() + "\t");   // remove da fila e exibe o valor removido
        }

        // Exibe os valores negativos na ordem inversa em que estavam no vetor
        while (!pilhaNegativo.isEmpty() ) {                 // enquanto a pilha de negativos não está vazia
            System.out.print(pilhaNegativo.pop() + "\t");   // desempilha e exibe o valor desempilhado
        }

    }
}
