package br.com.banco.api.repository;

import br.com.banco.api.dto.ContaDTO;
import br.com.banco.api.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<ContaDTO, Integer> {
    ContaDTO findByNomeResponsavel(String nomeResponsavel);

    Conta findByIdConta(int idConta);
}
