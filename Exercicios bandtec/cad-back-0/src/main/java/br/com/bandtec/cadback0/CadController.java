package br.com.bandtec.cadback0;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/cadastro")
public class CadController {
    ConexaoAzure database = new ConexaoAzure();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(database.getDataSource());



    @PostMapping("/{nome}/{usuario}/{email}/{telefone}/{senha}/{confirmarSenha}")
    public String cadastrarUsuario(
            @PathVariable("nome") String nome,
            @PathVariable("usuario") String usuario,
            @PathVariable("email") String email,
            @PathVariable("telefone") String telefone,
            @PathVariable("senha") String senha,
            @PathVariable("confirmarsenha") String confirmarSenha;
    )
}
