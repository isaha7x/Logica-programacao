package br.com.bandtec.jpa6.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// a classe de testes desta classe está em src/test/java
@RestController
public class CalculadoraController {

    @GetMapping("/somar/{n1}/{n2}")
    public ResponseEntity somar(@PathVariable Double n1, @PathVariable Double n2) {
        return ResponseEntity.ok(n1+n2);
    }

    @GetMapping("/dividir/{n1}/{n2}")
    public ResponseEntity dividir(@PathVariable Double n1, @PathVariable Double n2) {
        if (n2 == 0.0) {
            return ResponseEntity.badRequest().body("Não posso dividir por 0!");
        }
        return ResponseEntity.ok(n1/n2);
    }

}
