package br.com.banco.api.repository;

import br.com.banco.api.model.Conta;
import br.com.banco.api.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query("SELECT t FROM Transferencia t WHERE t.conta.id = :contaId")
    List<Transferencia> findByContaId(Long contaId);

    List<Transferencia> findByConta(Conta conta);

    List<Transferencia> findByDataTransferenciaBetweenAndNomeOperadorTransacao(LocalDateTime dataInicio,
                                                                               LocalDateTime dataFim,
                                                                               String nomeOperadorTransacao);
}
