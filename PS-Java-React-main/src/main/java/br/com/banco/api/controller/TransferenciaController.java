package br.com.banco.api.controller;

import br.com.banco.api.dto.TransferenciaDTO;
import br.com.banco.api.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping("/conta/{contaId}")
    public ResponseEntity<List<TransferenciaDTO>> getTransferenciasByContaBancaria(@PathVariable Long contaId) {
        List<TransferenciaDTO> transferencias = transferenciaService.getTransferenciasByContaBancaria(contaId);
        return ResponseEntity.ok(transferencias);
    }

    @GetMapping
    public ResponseEntity<List<TransferenciaDTO>> getTransferenciasByPeriodoENomeOperador(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dataInicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dataFim,
            @RequestParam(required = false) String nomeOperador) {
        List<TransferenciaDTO> transferencias = transferenciaService.getTransferenciasByPeriodoENomeOperador(dataInicio, dataFim, nomeOperador);
        return ResponseEntity.ok(transferencias);
    }

    @PostMapping
    public ResponseEntity<TransferenciaDTO> criarTransferencia(@RequestBody TransferenciaDTO transferenciaDTO) {
        TransferenciaDTO transferenciaCriada = transferenciaService.criarTransferencia(transferenciaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(transferenciaCriada);
    }

    @PutMapping("/{transferenciaId}")
    public ResponseEntity<TransferenciaDTO> atualizarTransferencia(
            @PathVariable Long transferenciaId, @RequestBody TransferenciaDTO transferenciaDTO) {
        TransferenciaDTO transferenciaAtualizada = transferenciaService.atualizarTransferencia(transferenciaId, transferenciaDTO);
        return ResponseEntity.ok(transferenciaAtualizada);
    }
}
