package br.com.bandtec.jpa5.controladores;

import br.com.bandtec.jpa5.Repository.AlunoRepository;
import br.com.bandtec.jpa5.entidades.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("/alunos")
    public class AlunoController {

        @Autowired
        private AlunoRepository repository;

        @GetMapping
        public ResponseEntity getAlunos() {
            List<Aluno> lista = repository.findAll();

            if (lista.isEmpty()){
                return  ResponseEntity.noContent().build();
            }else {
            return ResponseEntity.ok(lista);
            }
        }
    }

