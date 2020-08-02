package br.com.bandtec.cadback0;

public class Cadastro {
    private String nome;
    private String usuario;
    private String email;
    private String telefone;
    private String senha;
    private String confirmarSenha;

    public Cadastro(String nome, String usuario, String email, String telefone, String senha, String confirmarSenha) {
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
}
