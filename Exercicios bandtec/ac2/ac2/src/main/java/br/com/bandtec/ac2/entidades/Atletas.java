package br.com.bandtec.ac2.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Atletas {
    @Id
    @GeneratedValue
    private Integer id;
    private  String nome;
    private String dataNasc;
    private boolean selecao;

    @ManyToOne
    private Esportes esportes;

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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public boolean isSelecao() {
        return selecao;
    }

    public void setSelecao(boolean selecao) {
        this.selecao = selecao;
    }
}
