package br.com.bandtec.jpa4clienterest.entidades;

import javax.persistence.*;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer ano;

    private String obs;

    @ManyToOne
    private CategoriaFilme categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public CategoriaFilme getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFilme categoria) {
        this.categoria = categoria;
    }
}
