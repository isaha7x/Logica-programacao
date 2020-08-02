package br.com.bandtec.jpa6.controladores;

import br.com.bandtec.jpa6.entidades.Aluno;
import br.com.bandtec.jpa6.repositorios.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*
 A @SpringBootTest injeta o contexto de uma aplicação Spring Boot na classe de teste.
 Assim, podemos usar o @Autowired e anotações de Mocks, como a @MockBean.
 Usamos isso para criar testes DE INTEGRAÇÃO (ou "TESTES INTEGRADOS").
 */
@SpringBootTest
class AlunoControllerTest {

    @MockBean // esta anotação cria um Mock (doublê)
    AlunoRepository repository; // dublê (ou Mock)

    @Autowired // esta anotação em classes de teste faz com que o objeto se comporte como um DE VERDADE
    AlunoController controller;

    @Test
    void getAlunos() {
        // cenário 1: o repository retorna 2 alunos
        List<Aluno> doisAlunos = new ArrayList<>(); // dublê do tipo dummy
        doisAlunos.add(new Aluno());
        doisAlunos.add(new Aluno());

        /*
        Mockito -> biblioteca para criação de Dublês (Mock, Spy etc).
        .when() -> define O QUE um método de um Mock vai fazer
        .thenReturn() -> indica o retorno do método do Mock
         */
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>(doisAlunos));
        // new ArrayList<>(doisAlunos) -> aqui estamos 'clonando' a lista 'doisAlunos'
        // Mockito.when(repository.count()).thenReturn(50L);
        // Mockito.when(repository.getOne(10)).thenReturn(new Aluno());
        /*
        Dessa linha em diante, o repository.findAll() sempre retornará a lista 'doisAlunos'
         */

        // o getAlunos(), em sua execução, invoca o repository.findAll()
        ResponseEntity resposta = controller.getAlunos();

        assertEquals(200, resposta.getStatusCodeValue(), "Lista com valores deve retornar status 200");
        assertEquals(doisAlunos, resposta.getBody(), "Lista do endpoint deve ser fiel à do Repository");


        // cenário 2: o repositório não retorna nenhum aluno (ou seja, lista vazia)
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());

        resposta = controller.getAlunos();

        assertEquals(204, resposta.getStatusCodeValue(), "Lista SEM valores deve retornar status 204");
        assertNull(resposta.getBody(), "Lista SEM valores deve retornar corpo vazio");

    }

    @Test
    void getAlunosId(){
    Integer id = 99;

    Aluno aluno = new Aluno();
    aluno.setId(id);
    aluno.setNome("Zé ruela");

    Mockito.when(repository.findById(id)).thenReturn(Optional.of(aluno));

    ResponseEntity resposta = controller.getAlunosId(id);

    assertEquals(200,resposta.getStatusCodeValue(), "aluno encontrado retorna 200");

    assertEquals(aluno, resposta.getBody(),"aluno que o repository retornou deve ser o mesmo do controller");

    //cenario 2
        Mockito.when(repository.findById(id)).thenReturn(Optional.empty());

        resposta = controller.getAlunosId(id);

        assertEquals(404, resposta.getStatusCodeValue(), "consulta por id inválido deve retornar 404");

        assertNull(resposta.getBody(), "consulta por id inválido deve vir sem corpo");
    }

    @Test
    void excluirAluno(){
        Integer id = 99;
     List<Aluno> lista = new ArrayList<>(Arrays.asList(new Aluno(), new Aluno(), new Aluno()));

        Mockito.when(repository.findAll()).thenReturn(lista);

        ResponseEntity respostaAntes = controller.getAlunos();

        int alunosAntes = ((List) respostaAntes.getBody()).size();

        Mockito.when(repository.existsById(id)).thenReturn(true);

        Mockito.doAnswer(execucao -> lista.remove(0)).when(repository).deleteById(id);

        ResponseEntity respostaDelete = controller.excluirAluno(id);

        ResponseEntity respostaDepois = controller.getAlunos();
        int alunosDepoisDelete = ((List) respostaDepois.getBody()).size();

        assertEquals(200, respostaDelete.getStatusCodeValue());
        assertTrue(alunosDepoisDelete == alunosAntes-1);

        // cenário 2

        Mockito.when(repository.existsById(id)).thenReturn(false);

        respostaDelete = controller.excluirAluno(id);

        respostaDepois = controller.getAlunos();
        int alunosDepoisSegundoDelete = ((List) respostaDelete.getBody()).size();

        assertEquals(404, respostaDelete.getStatusCodeValue());
        assertEquals(alunosDepoisDelete, alunosDepoisSegundoDelete);



    }

}