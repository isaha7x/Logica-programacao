public class Teste {

    public static void main(String[] args) {
        int[] v = {2, 7, -3, -50, 45, -4, 30, -21, 38};

        // Cria um objeto da classe DuasPilhas
        DuasPilhas duasPilhas = new DuasPilhas(v.length);

        // Percorre o vetor, empilhando os valores positivos na pilha 1 e os negativos na pilha 2
        for (int i=0; i < v.length; i++) {
            if (v[i] >= 0) {
                duasPilhas.push(1, v[i]);
            }
            else {
                duasPilhas.push(2, v[i]);
            }
        }

        // Exibe os valores positivos na ordem inversa em que estavam no vetor
        while (!duasPilhas.isEmpty(1) ) {                   // enquanto a pilha 1 não está vazia
            System.out.print(duasPilhas.pop(1) + "\t");     // desempilha da pilha 1 e exibe o valor desempilhado
        }

        // Exibe os valores negativos na ordem inversa em que estavam no vetor
        while (!duasPilhas.isEmpty(2) ) {                   // enquanto a pilha 2 não está vazia
            System.out.print(duasPilhas.pop(2) + "\t");     // desempilha da pilha 2 e exibe o valor desempilhado
        }

    }
}
