public class Livros {
    private String titulo;
    private String isbn;
    private String edicao;
    private String ano;
    private int paginas;
    private String editora;

    public Livros(String titulo, String isbn, String edicao, String ano, int paginas, String editora) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.edicao = edicao;
        this.ano = ano;
        this.paginas = paginas;
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    @Override
    public String toString() {
        return String.format("%7s %-10s %7s %7s %10d %7s", titulo, isbn, edicao,ano,paginas,editora);
    }
}
