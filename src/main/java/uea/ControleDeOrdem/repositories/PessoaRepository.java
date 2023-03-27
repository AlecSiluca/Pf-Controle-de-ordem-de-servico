package uea.ControleDeOrdem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uea.ControleDeOrdem.models.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long>  {

}
