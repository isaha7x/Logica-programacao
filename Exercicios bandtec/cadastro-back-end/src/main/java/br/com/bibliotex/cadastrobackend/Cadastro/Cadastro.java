package br.com.bibliotex.cadastrobackend.Cadastro;

public class Cadastro {

        private String especie;
        private String nome;
        private boolean extinto;

        public String getEspecie() {
            return especie;
        }

        public void setEspecie(String especie) {
            this.especie = especie;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public boolean isExtinto() {
            return extinto;
        }

        public void setExtinto(boolean extinto) {
            this.extinto = extinto;
        }
    }
