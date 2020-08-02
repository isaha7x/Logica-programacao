package br.com.bandtec.jpa1.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
Mapeamento Objeto Relacional (ORM - Object Relational Mapping)
"Espelhar" ou mapear tabelas em Classes
Banco: Tabela, campo
Classe: Entidade, atributo
 */
@Entity // mapeamos esta entidade para a tabela "esporte"
public class Esporte {

    @Id // indica que campo será a PK
    @GeneratedValue // indica que será auto-incremento
    private Integer id;

    private String nome;

    private boolean olimpico;

    // o getter e setters indicam quais campos serão mapeados na entidade
    // sem get/set um atributo não é mapeado a um campo

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

    public boolean isOlimpico() {
        return olimpico;
    }

    public void setOlimpico(boolean olimpico) {
        this.olimpico = olimpico;
    }

}
