package jpa5.jpa5.Controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraControllerTest {

    @Test
    // para colocar uma frase do que vc está fazendo
    @DisplayName("A soma deve somar corretamente 2 números reais")

    void somar() {
        double n1= 10;
        double n2 = 20;
        double esperado = 30;


        CalculadoraController controller = new CalculadoraController();

        ResponseEntity resposta = controller.somar(n1,n2);

//        assert 30.0 == (Double)resposta.getBody();
        assertEquals(esperado, resposta.getBody(), "Soma entre "+n1+  "e" +n2+ " deve dar " +esperado);


        // cenário 2
        n1= 35;
        n2 = 65;
        esperado = 100;

        resposta = controller.somar(n1,n2);

        assertEquals(100.0, resposta.getBody(), "Soma entre "+n1+  "e" +n2+ " deve dar " +esperado);

    }

    @Test
    @DisplayName("Fazendo a divisão entre dois números")

    void dividir(){
        CalculadoraController controller = new CalculadoraController();

        // cenário 01 divisão
        double n1= 40;
        double n2 = 2;
        double esperado = 20;

        ResponseEntity resposta = controller.dividir(n1,n2);

        assertEquals(200, resposta.getStatusCodeValue(), "Divisão possível retorna status 200");
        assertEquals(esperado, resposta.getBody(), "Divisão entre "+n1+  "e" +n2+ " deve dar " +esperado);

        // Cenário 02
         n1= 15;
         n2 = 0;

        resposta = controller.dividir(n1,n2);
        assertEquals(400, resposta.getStatusCodeValue(), "Divisão por 0 retorna status 400");
        assertEquals("Não posso dividir por 0!", resposta.getBody());

    }
}