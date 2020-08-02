package br.com.bandec.corporequisicao.modelo.modelo;

import br.com.bandec.corporequisicao.modelo.Controllers.AtvVirus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/virus")
public class VirusController {
    private AtvVirus virus;

    @PostMapping
    public ResponseEntity criaVirus(@RequestBody AtvVirus novoVirus){
        this.virus = novoVirus;
        return ResponseEntity.status(201).build();
    }
    @GetMapping
    public ResponseEntity getVirus(){
        if (this.virus == null){
            return  ResponseEntity.noContent().build();
        }else {
            return  ResponseEntity.ok(this.virus);
        }
    }
   // @GetMapping("/{id}")

}
