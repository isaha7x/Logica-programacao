public class Estagio {
    // Fila para pessoas publicarem no sistema (não pode publicar todos de uma vez)
    // ver quem é o próximo da fila para publicar

    private String nome;
    private String lugarFila;

    public Estagio(String nome, String lugarFila) {
        this.nome = nome;
        this.lugarFila = lugarFila;
    }

    @Override
    public String toString() {

        return "App{" +
                "nome='" + nome + '\'' +
                ", lugarFila='" + lugarFila + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getLugarFila() {
        return lugarFila;
    }
}
