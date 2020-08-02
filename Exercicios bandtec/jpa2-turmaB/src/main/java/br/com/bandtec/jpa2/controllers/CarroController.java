package br.com.bandtec.jpa2.controllers;

import br.com.bandtec.jpa2.entidades.Carro;
import br.com.bandtec.jpa2.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroRepository repository;

    @GetMapping //  /carros?marca=BMW&modelo=X2   /carros?marca=VW&modelo=GOL
    public ResponseEntity getCarros(
            // marca e modelo são Parâmetros de Requisição
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo
    ) {
        List carros;

        if (marca != null && modelo != null) {
            carros = repository.findByMarcaAndModelo(marca, modelo);
        } else {
            carros = repository.findAll();
        }

        if (carros.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(carros);
        }
    }

    /*
    @GetMapping("/marca/{marca}")
    public ResponseEntity getCarroPorMarca(@PathVariable String marca) {
        List carros = repository.findByMarca(marca);

        if (carros.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(carros);
        }
    }
    */

    @GetMapping("/placa/{placa}")
    public ResponseEntity getCarroPorPlaca(@PathVariable String placa) {
        Carro carro = repository.findByPlaca(placa);

        if (carro == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(carro);
        }

    }
}
