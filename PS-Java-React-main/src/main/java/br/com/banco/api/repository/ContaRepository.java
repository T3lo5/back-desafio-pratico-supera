package br.com.banco.api.repository;

import br.com.banco.api.exception.ContaNotFoundException;
import br.com.banco.api.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    // Comentando a anotação @Query temporariamente
    //@Query("SELECT c FROM Conta c WHERE c.transferencias.id = :transferenciaId AND c.tipo = :tipo")
    //Optional<Conta> findByTransferenciasIdAndTipo(@Param("transferenciaId") Long transferenciaId, @Param("tipo") String tipo);
    default Optional<Conta> findByTransferenciasIdAndTipo(Long transferenciaId, String tipo) {
        return Optional.empty();
    }
    default Conta findByTransferenciasIdAndTipoOrThrow(Long transferenciaId, String tipo) {
        return findByTransferenciasIdAndTipo(transferenciaId, tipo)
                .orElseThrow(() -> new ContaNotFoundException("Conta de origem não encontrada"));
    }
}
