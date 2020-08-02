package br.com.bandtec.jpa4clienterest.clientes;

import br.com.bandtec.jpa4clienterest.modelos.ConversaoMoeda;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "exchangeratesapi", url = "https://api.exchangeratesapi.io")
public interface ClienteConversaoMoedas {

    // GET https://api.exchangeratesapi.io/latest?base=USD&symbols=BRL <- @RequestParam
    // GET https://api.exchangeratesapi.io/latest/USD/BRL <- @PathVariable (exemplo, mas não existe nesta API)

    @GetMapping("/latest")
    ConversaoMoeda getConversao(@RequestParam String base, @RequestParam String symbols);

    /*
    Novo método que consuma o Endpoint GET https://api.exchangeratesapi.io/2010-01-12
    (a parte final é uma data no formato yyyy-MM-dd)

    Criar um Endpoint no ConsultasController que use esse método e devolva o resultado
     */

    @GetMapping("/{data}")
    ConversaoMoeda getCotacoesDia(@PathVariable String data);
}

