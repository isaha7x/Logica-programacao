package br.com.bandtec.ac2.controller;

import br.com.bandtec.ac2.repository.Atleta2Repository;
import entidades2.AtletaNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/esportes")
public class AtletaController {
 //   @Autowired
 //   private  AtletaRepos
//
//    Deve ter o EndPoint POST /esportes {JSON} que permite a criação de uma esporte a partir de um JSON de esporte.
//    Ele retorna o status 201 se criado. O "id" do esporte não deve ser informado no momento da criação, pois deve ser
//    gerado automaticamente.

    @Autowired
    private Atleta2Repository repository;

    @PostMapping
    public ResponseEntity criarAtleta( AtletaNew novoAtleta){
    this.repository.save(novoAtleta);
    return ResponseEntity.created(null).build();
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

    @GetMapping("/{id}")
    public  ResponseEntity consultarAtleta(
            @PathVariable Integer id) {


        List atleta = Collections.singletonList(repository.findById(id));
        return atleta.isEmpty() ? noContent().build() : ok(atleta);
    }

   @GetMapping("/{nascimento}/{selecao}"){
       public ResponseEntity getCarroPorPlaca(@PathVariable String nascimento, selecao) {
           AtletaNew atletaNew = repository.findByAtletaNew(placa);

           if (atletaNew == null) {
               return ResponseEntity.noContent().build();
           } else {
               return ResponseEntity.ok(atletaNew);
           }
   }

    }


