package br.com.bandtec.jpa4clienterest.entidades;

import javax.persistence.*;

@Entity
public class PremioFilme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer ano;

    private String destaqueDiscurso;

    @ManyToOne
    private Filme filme;

    @ManyToOne
    private Premio premio;

    @ManyToOne
    private CategoriaPremio categoriaPremio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getDestaqueDiscurso() {
        return destaqueDiscurso;
    }

    public void setDestaqueDiscurso(String destaqueDiscurso) {
        this.destaqueDiscurso = destaqueDiscurso;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }

    public CategoriaPremio getCategoriaPremio() {
        return categoriaPremio;
    }

    public void setCategoriaPremio(CategoriaPremio categoriaPremio) {
        this.categoriaPremio = categoriaPremio;
    }
}
