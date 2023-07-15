package br.com.banco.api.repository;

import br.com.banco.api.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    List<Transferencia> findByConta_IdConta(Long idConta);

    List<Transferencia> findByDataTransferenciaBetweenAndNomeOperadorTransacao(LocalDateTime dataInicio,
                                                                               LocalDateTime dataFim,
                                                                               String nomeOperadorTransacao);
}
