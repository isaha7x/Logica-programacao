package br.com.bandtec.jpa5.controladores;

import br.com.bandtec.jpa5.Repository.AlunoRepository;
import br.com.bandtec.jpa5.entidades.Aluno;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlunoControllerTest {

    @MockBean
    AlunoRepository repository;

    @Autowired
    AlunoController controller;

    @Test
    // fazer teste alt + enter que ele cria a classe de teste
    void getAlunos() {
        List<Aluno> doisAlunos = Arrays.asList(new Aluno(), new Aluno());

        Mockito .when(repository.findAll()).thenReturn(new ArrayList<>(doisAlunos));

        ResponseEntity resposta = controller.getAlunos();

        assertEquals(200,resposta.getStatusCodeValue(),"Lista com valores deve retornar 200");
        assertEquals(doisAlunos,resposta.getBody(), "Lista do endpoint deve ser fiel a Repository");

        // cenário 02
        Mockito .when(repository.findAll()).thenReturn(new ArrayList<>());

         resposta = controller.getAlunos();

        assertEquals(204,resposta.getStatusCodeValue(),"Lista com valores deve retornar 204");
        assertNull(resposta.getBody(), "Lista SEM valores deve ser retornar corpo vazio" );

    }
}