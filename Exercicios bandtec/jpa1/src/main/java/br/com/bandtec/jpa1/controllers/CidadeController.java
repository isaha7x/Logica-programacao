package br.com.bandtec.jpa1.controllers;

import br.com.bandtec.jpa1.entidades.Cidade;
import br.com.bandtec.jpa1.entidades.Esporte;
import br.com.bandtec.jpa1.repositorios.CidadeRepository;
import br.com.bandtec.jpa1.repositorios.EsporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired // injeta uma instancia de EsporteRepository
    private CidadeRepository repository;

    @PostMapping
    public ResponseEntity criarCidades(@RequestBody Cidade novaCidade) {
        this.repository.save(novaCidade);
        return ResponseEntity.created(null).build(); // stts 201
    }

    @GetMapping
    public ResponseEntity listarTodos() {
        if (this.repository.count() > 0) {
            return ResponseEntity.ok(this.repository.findAll()); // stts 200-ok
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirEsporte(@PathVariable Integer id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return ResponseEntity.ok().build(); // stts 200
        } else {
            return ResponseEntity.notFound().build(); // stts 404
        }
    }

    @GetMapping("/contagem")
    public ResponseEntity getContagem() {
        return ResponseEntity.ok(this.repository.count());
    }
}
