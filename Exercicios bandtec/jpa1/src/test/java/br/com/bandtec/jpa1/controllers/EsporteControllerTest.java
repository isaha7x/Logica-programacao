package br.com.bandtec.jpa1.controllers;

import br.com.bandtec.jpa1.entidades.Esporte;
import br.com.bandtec.jpa1.repositorios.EsporteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EsporteControllerTest {

    @MockBean
    EsporteRepository repository;

    @Autowired // testar notação
    EsporteController controller;

    @Test
    void getEsporte() {
        Integer id = null;

        Esporte esporte = new Esporte();
        esporte.setId(id);
        esporte.setNome("Ginástica Artistica");

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(esporte));

        ResponseEntity resposta = controller.getEsporte(id);

        assertEquals(200,resposta.getStatusCodeValue(), "Esporte encontrado retorna 200");

        assertEquals(esporte, resposta.getBody(),"Esporte que o repository retornou deve ser o mesmo do controller");

        //cenario 2
        Mockito.when(repository.findById(id)).thenReturn(Optional.empty());

        resposta = controller.getEsporte(id);

        assertEquals(404, resposta.getStatusCodeValue(), "consulta por id inválida deve retornar 404");

        assertNull(resposta.getBody(), "consulta por id inválido deve vir sem corpo");
    }

}