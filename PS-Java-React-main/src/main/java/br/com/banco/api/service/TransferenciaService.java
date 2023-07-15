package br.com.banco.api.service;

import br.com.banco.api.dto.TransferenciaDTO;
import br.com.banco.api.exception.TransferenciaNotFoundException;
import br.com.banco.api.model.Conta;
import br.com.banco.api.model.Transferencia;
import br.com.banco.api.exception.ContaNotFoundException;
import br.com.banco.api.repository.ContaRepository;
import br.com.banco.api.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final ContaRepository contaRepository;

    @Autowired
    public TransferenciaService(TransferenciaRepository transferenciaRepository, ContaRepository contaRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.contaRepository = contaRepository;
    }

    public List<TransferenciaDTO> getTransferenciasByContaBancaria(Long contaId) {
        List<Transferencia> transferencias = transferenciaRepository.findByConta_IdConta(contaId);
        return transferencias.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<TransferenciaDTO> getTransferenciasByPeriodoENomeOperador(LocalDateTime dataInicio, LocalDateTime dataFim, String nomeOperador) {
        List<Transferencia> transferencias = transferenciaRepository.findByDataTransferenciaBetweenAndNomeOperadorTransacao(dataInicio, dataFim, nomeOperador);
        return transferencias.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private TransferenciaDTO convertToDTO(Transferencia transferencia) {
        TransferenciaDTO transferenciaDTO = new TransferenciaDTO();
        transferenciaDTO.setId(transferencia.getId());
        transferenciaDTO.setDataTransferencia(transferencia.getDataTransferencia());
        transferenciaDTO.setValor(transferencia.getValor());
        transferenciaDTO.setTipo(transferencia.getTipo());
        transferenciaDTO.setNomeOperadorTransacao(transferencia.getNomeOperadorTransacao());
        transferenciaDTO.setNomeResponsavel(getNomeResponsavel(transferencia));
        return transferenciaDTO;
    }

    private String getNomeResponsavel(Transferencia transferencia) {
        if (transferencia.getTipo().equalsIgnoreCase("TRANSFERENCIA")) {
            Conta contaDestino = contaRepository.findById(transferencia.getContaId()).orElse(null);
            return contaDestino != null ? contaDestino.getNomeResponsavel() : "";
        } else {
            Conta contaOrigem = contaRepository.findByTransferenciasIdAndTipo(transferencia.getId(), "TRANSFERENCIA")
                    .orElseThrow(ContaNotFoundException::new);
            return contaOrigem.getNomeResponsavel();
        }
    }



    public TransferenciaDTO criarTransferencia(TransferenciaDTO transferenciaDTO) {
        Transferencia transferencia = new Transferencia();
        transferencia.setDataTransferencia(LocalDateTime.now());
        transferencia.setValor(transferenciaDTO.getValor());
        transferencia.setTipo(transferenciaDTO.getTipo());
        transferencia.setNomeOperadorTransacao(transferenciaDTO.getNomeOperadorTransacao());
        transferencia.setContaId(transferenciaDTO.getContaId());

        Transferencia transferenciaCriada = transferenciaRepository.save(transferencia);
        return convertToDTO(transferenciaCriada);
    }

    public TransferenciaDTO atualizarTransferencia(Long transferenciaId, TransferenciaDTO transferenciaDTO) {
        Transferencia transferenciaExistente = transferenciaRepository.findById(transferenciaId)
                .orElseThrow(() -> new TransferenciaNotFoundException("Transferência não encontrada"));

        transferenciaExistente.setValor(transferenciaDTO.getValor());
        transferenciaExistente.setTipo(transferenciaDTO.getTipo());
        transferenciaExistente.setNomeOperadorTransacao(transferenciaDTO.getNomeOperadorTransacao());
        transferenciaExistente.setContaId(transferenciaDTO.getContaId());

        Transferencia transferenciaAtualizada = transferenciaRepository.save(transferenciaExistente);
        return convertToDTO(transferenciaAtualizada);
    }

}
