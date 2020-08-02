package br.com.bandtec.jpa1.repositorios;

import br.com.bandtec.jpa1.entidades.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade,Integer> {
}
