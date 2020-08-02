import java.util.Random;

public class Baralho {

    private PilhaObj<Carta> baralho;
    String [] faces;
    String [] naipes;


    public Baralho() {
        faces = new String[]{"Ás","2","3","4","5","6","7","8","9","10","Dama","Valete","Rei"};
        naipes = new String[]{"Ouros","Espadas","Copas","Paus"};
        baralho =  new PilhaObj<Carta>(52);
        System.out.println(naipes[3]);
        for (int i = 0; i < 4; i++) {
            for (int n = 0; n < 13; n++) {
                baralho.push(new Carta(faces[n],n+1, naipes[i]));
            }
        }
    }


    public Carta removeCarta(Integer ind ){
        PilhaObj<Carta> aux = new PilhaObj<>(ind);

        for (int i = 0; i < ind; i++){
            aux.push(baralho.pop());
        }
        Carta alvo = baralho.pop();
        while (!aux.isEmpty()){
            baralho.push(aux.pop());
        }return alvo;
    }

    public void embaralhar(){
        Random nroAleatorio = new Random();

        for (int i = 0; 52 < i; i++) {
            int indice = nroAleatorio.nextInt(52);

            if(indice != 0){
                removeCarta(indice);
            }else{
               // removeCarta()
            }

        }
//        public  Carta virarCarta(){
//
//        }


    }

}

