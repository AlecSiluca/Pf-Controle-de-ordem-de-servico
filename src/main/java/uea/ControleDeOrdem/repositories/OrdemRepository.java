package uea.ControleDeOrdem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uea.ControleDeOrdem.models.Ordem;
import uea.ControleDeOrdem.repositories.ordem.OrdemRepositoryQuery;

public interface OrdemRepository extends JpaRepository<Ordem, Long>, OrdemRepositoryQuery {

}
