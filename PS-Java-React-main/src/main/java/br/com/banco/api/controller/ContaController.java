package br.com.banco.api.controller;

import br.com.banco.api.dto.ContaDTO;
import br.com.banco.api.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
    private final ContaService contaService;

    @Autowired
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    public ResponseEntity<ContaDTO> criarConta(@RequestBody ContaDTO contaDTO) {
        ContaDTO novaConta = contaService.criarConta(contaDTO.getNomeResponsavel());
        return ResponseEntity.status(HttpStatus.CREATED).body(novaConta);
    }

    @GetMapping
    public ResponseEntity<List<ContaDTO>> listarContas() {
        List<ContaDTO> contas = contaService.listarContas();
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{idConta}")
    public ResponseEntity<ContaDTO> buscarContaPorId(@PathVariable int idConta) {
        ContaDTO conta = contaService.buscarContaPorId(idConta);
        if (conta != null) {
            return ResponseEntity.ok(conta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idConta}")
    public ResponseEntity<Void> excluirConta(@PathVariable int idConta) {
        contaService.excluirConta(idConta);
        return ResponseEntity.noContent().build();
    }
}
