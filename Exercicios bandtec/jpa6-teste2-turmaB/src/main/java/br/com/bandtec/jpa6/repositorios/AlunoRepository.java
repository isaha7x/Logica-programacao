package br.com.bandtec.jpa6.repositorios;

import br.com.bandtec.jpa6.entidades.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
