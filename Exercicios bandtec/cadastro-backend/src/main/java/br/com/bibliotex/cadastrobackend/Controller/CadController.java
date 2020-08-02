package br.com.bibliotex.cadastrobackend.Controller;

import br.com.bibliotex.cadastrobackend.Cadastro.Cadastro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro")
public class CadController {
    private Cadastro cadastro;

    @GetMapping
    public ResponseEntity getCadastro(){
        if(this.cadastro == null ){
            return  ResponseEntity.noContent().build();}
        else{
            return ResponseEntity.ok(this.cadastro);
        }
    }


    @PostMapping
    public ResponseEntity criaLeitor(@RequestBody Cadastro novoLeitor){
        this.cadastro = novoLeitor;
        return ResponseEntity.status(201).build();

    }
}
