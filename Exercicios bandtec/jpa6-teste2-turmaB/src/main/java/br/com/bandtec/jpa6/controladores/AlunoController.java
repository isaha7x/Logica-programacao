package br.com.bandtec.jpa6.controladores;

import br.com.bandtec.jpa6.entidades.Aluno;
import br.com.bandtec.jpa6.repositorios.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public ResponseEntity getAlunos() {
        List<Aluno> lista = repository.findAll();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    /*
    Programe um Endpoint GET alunos/{id} no qual:
    a- Caso o id seja válido, ele retorna o Aluno encontrado e status 200
    b- Caso o id seja inválido, ele retorna o status 404
    c- Crie um método de teste para ele na AlunoControllerTest
    * */

    @GetMapping("/{id}")
    public  ResponseEntity getAlunosId(@PathVariable Integer id){
        Optional<Aluno> aluno = repository.findById(id);
        return ResponseEntity.of(aluno);
    }

    /*No AlunoController, programe um EndPoint que receba um id de aluno via DELETE 
Ele tenta excluir o aluno, caso o id esteja correto, retornando assim, 200 

- Caso o Id seja inválido, retorna 404 e, claro, não exclui o aluno da lista  
-> Teste automatizado de integração: 

 - Teste se, ao passar um id válido, retorna 200 e se o a consulta de 
 todos os alunos passa a trazer um item a menos (estou falando aqui do método getAlunos()) 

  - Teste se, ao passar um id inválido, retorna 404 e se a consulta de 
 todos os alunos continua trazendo a mesma quantidade de alunos 
(estou falando aqui do método getAlunos()) */

    @DeleteMapping("/exclui/{id}")
    public ResponseEntity excluirAluno(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build(); // stts 200
        } else {
            return ResponseEntity.notFound().build(); // stts 404
        }
    }
}
