package br.com.bandtec.jpa1.repositorios;

import br.com.bandtec.jpa1.entidades.Esporte;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Repository é um Padrão de Projeto.
Nele, cada 'Repository' é responsável por todas as operações junto a uma Entidade (Tabela)

Numa Repository JPA indicamos: <Classe da Entidade, Classe da PK>.

A 'JpaRepository' contém todos os métodos básicos de acesso a um banco de dados.

OBS: O padrão Repository veio em substitução ao antigo DAO.
*/

public interface EsporteRepository extends JpaRepository<Esporte, Integer> {
}
