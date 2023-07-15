package br.com.banco.api.controller;

import br.com.banco.api.dto.TransferenciaDTO;
import br.com.banco.api.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
    private final TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public ResponseEntity<TransferenciaDTO> criarTransferencia(@RequestBody TransferenciaDTO transferenciaDTO) {
        TransferenciaDTO novaTransferencia = transferenciaService.criarTransferencia(transferenciaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransferencia);
    }

    @GetMapping
    public ResponseEntity<List<TransferenciaDTO>> listarTransferencias() {
        List<TransferenciaDTO> transferencias = transferenciaService.listarTransferencias();
        return ResponseEntity.ok(transferencias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferenciaDTO> buscarTransferenciaPorId(@PathVariable Long id) {
        TransferenciaDTO transferencia = transferenciaService.buscarTransferenciaPorId(id);
        if (transferencia != null) {
            return ResponseEntity.ok(transferencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTransferencia(@PathVariable Long id) {
        transferenciaService.excluirTransferencia(id);
        return ResponseEntity.noContent().build();
    }
}
