public class Livro {
    //Esta classe terá os atributos idLivro (inteiro), titulo (String), autor (String),
    // preco (double), qtdPagina (int). Os atributos devem ser encapsulados e
    // a classe deve fornecer os getters e os setters.
    private Integer idLivro;
    private String titulo;
    private String autor;
    private double preco;
    private int qtdPagina;

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdPagina() {
        return qtdPagina;
    }

    public void setQtdPagina(int qtdPagina) {
        this.qtdPagina = qtdPagina;
    }

    public Livro(Integer idLivro, String titulo, String autor, double preco, int qtdPagina) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.qtdPagina = qtdPagina;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                ", qtdPagina=" + qtdPagina +
                '}';
    }
}
