package br.com.bandtec.atvvirus.Controller;

import br.com.bandtec.atvvirus.Model.Virus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/virus")
public class VirusController {
    ArrayList <Virus> virusArrayList = new ArrayList<>();

    @PostMapping
    public ResponseEntity createVirus (@RequestBody Virus virus){
        virusArrayList.add(virus);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getVirus() {
        if (virusArrayList.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.ok(virusArrayList);
        }
    }

    @GetMapping("/{id}")
    public  ResponseEntity getVirusId(@PathVariable ("id") int id){
    if(id >= virusArrayList.size()){
        return ResponseEntity.status(404).build();
    }else{
        return ResponseEntity.ok(virusArrayList.get(id));
    }
    }
}


