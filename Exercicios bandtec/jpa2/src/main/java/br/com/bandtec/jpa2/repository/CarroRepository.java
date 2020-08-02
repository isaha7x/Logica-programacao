package br.com.bandtec.jpa2.repository;

import br.com.bandtec.jpa2.entidades.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
    List<Carro> findByMarca(String marca);

    Carro findByPlaca(String placa);

    // excluir todos os carros de uma determinada marca
    void deleteByMarca(String marca); // long retornaria a qtd de itens excluidos


    // contar quantos carros de uma certa marca
    long countByMarca(String marca);

    // existem caarros de uma certa marca?
    boolean existsByMarca(String marca);

    List<Carro> findByMarcaAndModelo(String marca, String modelo);

}
