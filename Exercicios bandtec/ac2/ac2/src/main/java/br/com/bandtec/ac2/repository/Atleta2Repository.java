package br.com.bandtec.ac2.repository;

import entidades2.AtletaNew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Atleta2Repository  extends JpaRepository<AtletaNew, Integer> {
    //void deleteById(Integer id);
}
