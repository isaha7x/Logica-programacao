package br.com.bandtec.ac2.repository;
//import br.com.bandtec.ac2.entidades.Atletas;

import entidades2.AtletaNew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtletaRepository  extends JpaRepository<AtletaNew, Integer> {

}
