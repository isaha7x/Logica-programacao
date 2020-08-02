public class Carta {
    private String face;        //face da carta
    private Integer valor; // valor da carta de 1 a 13
    private String naipe;

  //  public Carta(int value, String suit )



    public Carta(String face, Integer valor, String naipe) {
        this.face = face;
        this.valor = valor;
        this.naipe = naipe;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "face='" + face + "de" + naipe + '\'' +
                ", valor=" + valor +
                ", naipe='" + naipe + '\'' +
                '}';
    }

    public String getFace() {
        return face;
    }

    public Integer getValor() {
        return valor;
    }

    public String getNaipe() {
        return naipe;
    }
}
