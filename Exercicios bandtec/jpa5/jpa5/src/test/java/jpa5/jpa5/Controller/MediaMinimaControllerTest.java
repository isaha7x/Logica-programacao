package jpa5.jpa5.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class MediaMinimaControllerTest {

    @Test
    void criarFrequencia() {
        double media= 8.0;
        double frequencia = 90.0;

     MediaMinimaController controller = new MediaMinimaController();

        ResponseEntity resposta = controller.criarFrequencia(media,frequencia);

        assertEquals(201, resposta.getStatusCodeValue(), "Tudo OK");
        assertEquals(null, resposta.getBody());

    }

    @Test
    void criarFrequencia2() {
        double media= 3;
        double frequencia = 80.0;

        MediaMinimaController controller = new MediaMinimaController();

        ResponseEntity resposta = controller.criarFrequencia(media,frequencia);

        assertEquals(400, resposta.getStatusCodeValue(), "Apenas o valor de" + media+ " inválido");
        assertEquals("A média deve ser entre 5.0 e 10.0. Você tentou com" + media, resposta.getBody());

    }

    @Test
    void criarFrequencia3() {
        double media= 8.0;
        double frequencia = 30.0;

        MediaMinimaController controller = new MediaMinimaController();

        ResponseEntity resposta = controller.criarFrequencia(media,frequencia);

        assertEquals(400, resposta.getStatusCodeValue(), "Apenas o valor de" + frequencia+ " inválida");
        assertEquals("A frequência deve ser entre 60.0 e 100.0. Você tentou com " + frequencia, resposta.getBody());

    }

    @Test
    void criarFrequencia4() {
        double media= 2.0;
        double frequencia = 10.0;

        MediaMinimaController controller = new MediaMinimaController();

        ResponseEntity resposta = controller.criarFrequencia(media,frequencia);

        assertEquals(400, resposta.getStatusCodeValue(), "Valor de" + media + "e" + frequencia+ " inválidos");
        assertEquals("Mano, sério?! Tudo errado!", resposta.getBody());

    }



}