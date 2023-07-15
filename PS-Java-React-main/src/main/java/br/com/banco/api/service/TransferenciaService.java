package br.com.banco.api.service;

import br.com.banco.api.dto.TransferenciaDTO;
import br.com.banco.api.exception.TransferenciaNotFoundException;
import br.com.banco.api.model.Transferencia;
import br.com.banco.api.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferenciaService {
    private final TransferenciaRepository transferenciaRepository;

    @Autowired
    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    public TransferenciaDTO criarTransferencia(TransferenciaDTO transferenciaDTO) {
        Transferencia transferencia = new Transferencia();
        transferencia.setDataTransferencia(transferenciaDTO.getDataTransferencia());
        transferencia.setValor(transferenciaDTO.getValor());
        transferencia.setTipo(transferenciaDTO.getTipo());
        transferencia.setNomeOperadorTransacao(transferenciaDTO.getNomeOperadorTransacao());

        Transferencia transferenciaSalva = transferenciaRepository.save(transferencia);

        return new TransferenciaDTO(
                transferenciaSalva.getId(),
                transferenciaSalva.getDataTransferencia(),
                transferenciaSalva.getValor(),
                transferenciaSalva.getTipo(),
                transferenciaSalva.getNomeOperadorTransacao()
        );
    }

    public List<TransferenciaDTO> listarTransferencias() {
        List<Transferencia> transferencias = transferenciaRepository.findAll();
        return converterListaTransferenciasParaDTO(transferencias);
    }

    public TransferenciaDTO buscarTransferenciaPorId(Long id) {
        Transferencia transferencia = transferenciaRepository.findById(id)
                .orElseThrow(() -> new TransferenciaNotFoundException("Transferência não encontrada"));
        return converterTransferenciaParaDTO(transferencia);
    }

    public void excluirTransferencia(Long id) {
        transferenciaRepository.deleteById(id);
    }

    private List<TransferenciaDTO> converterListaTransferenciasParaDTO(List<Transferencia> transferencias) {
        return transferencias.stream()
                .map(this::converterTransferenciaParaDTO)
                .collect(Collectors.toList());
    }

    private TransferenciaDTO converterTransferenciaParaDTO(Transferencia transferencia) {
        return new TransferenciaDTO(
                transferencia.getId(),
                transferencia.getDataTransferencia(),
                transferencia.getValor(),
                transferencia.getTipo(),
                transferencia.getNomeOperadorTransacao()
        );
    }
}
