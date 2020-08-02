package br.com.bandtec.jpa5.controladores;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static org.junit.jupiter.api.Assertions.*;

// testes automatizados de código em Java possuem como biblioteca padrão o JUnit
class CalculadoraControllerTest {

    @Test // torna um método um "método de teste". Sem isso o método nem é considerado nos testes
    @DisplayName("A soma deve somar corretamente 2 números reais") // dá uma descrição melhor do que simplemente o nome do método lá no painel de execução. Opcional.
    void somar() {
        CalculadoraController controller = new CalculadoraController();

        // cenário 1
        double n1 = 10;
        double n2 = 20;
        double esperado = 30;
        ResponseEntity resposta = controller.somar(n1, n2);
        // assertEquals(<valor esperado>, <valor na execução>, <mensagem em caso de falha no teste>)
        assertEquals(esperado, resposta.getBody(), "Soma entre "+n1+" e "+n2+" deve dar "+esperado);

        // cenário 2
        n1 = 35;
        n2 = 65;
        esperado = 100;
        resposta = controller.somar(n1, n2);
        assertEquals(esperado, resposta.getBody(), "Soma entre "+n1+" e "+n2+" deve dar "+esperado);
    }

    // uma classe de testes pode ter quantos métodos de teste, ou seja, anotados com @Test, forem necessários
    @Test
    void dividir() {
        CalculadoraController controller = new CalculadoraController();

        // cenário 1
        double n1 = 40;
        double n2 = 2;
        double esperado = 20;
        ResponseEntity resposta = controller.dividir(n1, n2);
        assertEquals(200, resposta.getStatusCodeValue(), "Divisão possível deve retornar status 200");
        // outra forma de fazer o mesmo teste assertEquals(HttpStatus.OK, resposta.getStatusCode(), "Divisão possível retorna status 200");
        assertEquals(esperado, resposta.getBody(), "Divisão entre "+n1+" e "+n2+" deve dar "+esperado);

        // cenário 2
        n1 = 15;
        n2 = 0;
        resposta = controller.dividir(n1, n2);
        assertEquals(400, resposta.getStatusCodeValue(), "Divisão por 0 deve retornar status 400");
        assertEquals("Não posso dividir por 0!", resposta.getBody());

    }

    @Test
    void testarConfiguracoes() throws NoSuchMethodException {
        Class classe = CalculadoraController.class;

        assertTrue(classe.isAnnotationPresent(RestController.class),
         "A controller deve estar anotada com @RestController");

        Method somar = classe.getDeclaredMethod("somar", Double.class, Double.class);
        assertTrue(somar.isAnnotationPresent(GetMapping.class),
                "o método somar() deve estar anotado com@GetMapping");

        String uriEsperada = "/somar/{n1}/{n2}";
        assertEquals(somar.getDeclaredAnnotation(GetMapping.class).value() [0],
        uriEsperada, "o endpoin em simar() deve ter a URI" + uriEsperada);

        // dividir

        Method dividir = classe.getDeclaredMethod("dividir", Double.class, Double.class);
        assertTrue(dividir.isAnnotationPresent(GetMapping.class),
                "o método dividir() deve estar anotado com@GetMapping");

         String uriEsperada2 = "/dividir/{n1}/{n2}";
        assertEquals(dividir.getDeclaredAnnotation(GetMapping.class).value() [0],
                uriEsperada2, "o endpoint em dividir() deve ter a URI" + uriEsperada);

        Parameter[] parametros = somar.getParameters();
        assertTrue(parametros[0].isAnnotationPresent(PathVariable.class),
                "O 1° parametro de somar() deve estar anotado com @PathVariable");
        assertTrue(parametros[1].isAnnotationPresent(PathVariable.class),
                "O 2° parametro de sommar() deve estar anotado com @PathVariable");
    }

    // testar o método dividir()


}