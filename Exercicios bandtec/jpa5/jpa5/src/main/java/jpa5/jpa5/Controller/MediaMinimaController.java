package jpa5.jpa5.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/media-minima")
public class MediaMinimaController {

    @PostMapping("/{media}/frequencia-minima/{frequencia}")
    public ResponseEntity criarFrequencia(@PathVariable Double media, @PathVariable Double frequencia) {

//        c.1.) Valor de {media} for menor que 5.0 ou superior a 10.0 - Nesse caso, o corpo da resposta deve ser a frase
//        "A média deve ser entre 5.0 e 10.0. Você tentou com X", onde X é o valor enviado no Endpoint.

        if ((media < 5 || media > 10) &&( frequencia < 60 || frequencia > 100)) {
            return ResponseEntity.badRequest().body("Mano, sério?! Tudo errado!");
        }

        if (media < 5 || media > 10) {
            return ResponseEntity.badRequest().body("A média deve ser entre 5.0 e 10.0. Você tentou com " + media);

        }

        if (frequencia < 60 || frequencia > 100) {
            return ResponseEntity.badRequest().body("A frequência deve ser entre 60.0 e 100.0. Você tentou com " + frequencia);

        }


        return ResponseEntity.status(201).build();
    }

}
