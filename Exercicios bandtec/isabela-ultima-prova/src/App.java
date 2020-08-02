public class App {
    public static void main(String[] args) {

            // Cria um objeto da classe DuasPilhas
            FilaObj filaObj = new FilaObj(6);
            Estagio estagio = new Estagio("Isa", "1");
            Estagio estagio2 = new Estagio("João", "3");
            Estagio estagio3 = new Estagio("Maria", "2");
            Estagio estagio4 = new Estagio("José", "4");

            filaObj.insert(estagio);
            filaObj.insert(estagio2);
            filaObj.insert(estagio3);
            filaObj.insert(estagio4);

            filaObj.exibe();

            filaObj.poll();

            filaObj.exibe();

            while (filaObj.isEmpty() == false){
                filaObj.poll();
                filaObj.exibe();
            }
    }

}
