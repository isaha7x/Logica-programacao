package br.com.bandtec.jpa4clienterest.modelos;

import java.time.LocalDate;
import java.util.Map;

public class ConversaoMoeda {

    private String base;
    private LocalDate date;

    private Map<String, Double> rates; // pacote 'java.util'

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
