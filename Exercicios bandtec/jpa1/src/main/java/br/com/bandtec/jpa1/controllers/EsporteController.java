package br.com.bandtec.jpa1.controllers;

import br.com.bandtec.jpa1.entidades.Esporte;
import br.com.bandtec.jpa1.repositorios.EsporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/esportes")
public class EsporteController {

    @Autowired // Isso INJETA uma instância de EsporteRepository, no caso
    private EsporteRepository repository;

    @PostMapping
    public ResponseEntity criarEsporte(@RequestBody Esporte novoEsporte) {
        this.repository.save(novoEsporte);

        return ResponseEntity.created(null).build(); // status 201-created
        // o null seria o URL do recurso recém criado
        // isso é muit trabalhoso e opcional. Por isso null
    }

    @GetMapping
    public ResponseEntity listarTodos() {
        if (this.repository.count() > 0) {
            return ResponseEntity.ok(this.repository.findAll()); // status 200-ok
        } else {
            return ResponseEntity.noContent().build(); // status 204-no-content
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getEsporte(@PathVariable Integer id) {

        // o findById() não retorna o objeto. Ele retorna um Optional da classe da Entidade
        // Isso serve para previnir NullPointerException
        Optional<Esporte> consultaEsporte = this.repository.findById(id);

        // o .isPresent() retorna true caso o valor no Optional não seja vazio
        // ou seja, se a consulta trouxe algo do banco
        if (consultaEsporte.isPresent()) {
            // o .get() do Optional traz o valor em sí (no caso, um Esporte)
            return ResponseEntity.ok(consultaEsporte.get()); // status 200-ok
        } else { // se o .isPresent() retornar false, significa que a consulta não trouxe nada
            return ResponseEntity.notFound().build(); // status 404-not-found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirEsporte(@PathVariable Integer id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return ResponseEntity.ok().build(); // status 200-ok
        } else {
            return ResponseEntity.notFound().build(); // status 404-not-found
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarEsporte(
            @PathVariable Integer id, @RequestBody Esporte esporteAtualizado) {

        Optional<Esporte> consultaExistente = this.repository.findById(id);

        if (consultaExistente.isPresent()) {
            Esporte esporteEncontrado = consultaExistente.get();

            esporteEncontrado.setNome(esporteAtualizado.getNome());
            esporteEncontrado.setOlimpico(esporteAtualizado.isOlimpico());

            this.repository.save(esporteEncontrado);

            return ResponseEntity.ok().build(); // status 200-ok
        } else {
            return ResponseEntity.notFound().build(); // status 404-not-found
        }

    }

}
