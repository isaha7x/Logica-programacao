package br.com.bandec.corporequisicao.modelo.Controllers;

public class AtvVirus {
   private String nomeVirus;
   private String nomePopular;
   private  double taxaMortalidade;

    public String getNomeVirus() {
        return nomeVirus;
    }

    public void setNomeVirus(String nomeVirus) {
        this.nomeVirus = nomeVirus;
    }

    public String getNomePopular() {
        return nomePopular;
    }

    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    public double getTaxaMortalidade() {
        return taxaMortalidade;
    }

    public void setTaxaMortalidade(double taxaMortalidade) {
        this.taxaMortalidade = taxaMortalidade;
    }
}
