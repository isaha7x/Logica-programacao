public class Pilha {

    private int topo; // contém o índice do topo da pilha
   private  int[] pilha; // vetor que representa a pilha

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1 ;
    }

    public boolean isEmpty() {
        if (topo == pilha.length - 1) {
            return true;
        } return false;

    }

    public boolean isFull() {
        if (topo == topo - 1) {
            return true;
        } return false;

    }

    public void push(int inserir) {
       if(isEmpty() == true){
           topo++;
           pilha[topo] = inserir;
       }else{
           System.out.println("Não inserido. Pilha está cheia");
       }
    }

    public void pop(){
        if (isEmpty()){
            System.out.println("Pilha está vazia");
        }else{
          //  pilha[topo] = null;
            --topo;
        }
    }

    public void exibe(){
        for(int i =0; i < pilha.length -1; i++){
            System.out.println("Item" + (i+1 ) + pilha[i]);
            System.out.println("Tamanho max da Pilha" + pilha.length +"topo da pilha" + topo+1);
        }
    }

}
