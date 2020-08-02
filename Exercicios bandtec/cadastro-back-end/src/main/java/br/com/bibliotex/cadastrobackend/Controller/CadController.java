package br.com.bibliotex.cadastrobackend.Controller;

import br.com.bibliotex.cadastrobackend.Cadastro.Cadastro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastros")
public class CadController {

    private Cadastro animal;

    @GetMapping
    public ResponseEntity getAnimal(){
        if(this.animal == null ){
            return  ResponseEntity.noContent().build();}
        else{
            return ResponseEntity.ok(this.animal);
        }
    }

    @PostMapping
    public  ResponseEntity criaAnimal(@RequestBody Cadastro novoAnimal){
        this.animal = novoAnimal;
        return ResponseEntity.status(201).build();
        // return  ResponseEntity.created(null).build(); (para um api pft)
    }
    //stts
    //noContent = não encontrado
    //created

    @DeleteMapping
    public ResponseEntity excluirAnimal(){
        if (this.animal == null) {
            return ResponseEntity.notFound().build();
        }else {
            this.animal =null;
            return ResponseEntity.ok().build();
        }
    }


}
