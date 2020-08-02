package br.com.bandtec.jpa2.repository;

import br.com.bandtec.jpa2.entidades.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

    // Dymanic finders

    List<Carro> findByMarca(String marca);

    Carro findByPlaca(String placa);
    // aceitaria Optional<Carro>

    // excluir todos os carros de uma certa marca
    void deleteByMarca(String marca);
    // o retorno poderia ser long, o que devolveria a quantidade de registros excluídos

    // contar quantos carros de uma certa marca
    long countByMarca(String marca);

    // existem carros de uma certa marca?
    boolean existsByMarca(String marca);

    // recuperar todos os registros com determinados marca e modelo
    List<Carro> findByMarcaAndModelo(String marca, String modelo);
}
