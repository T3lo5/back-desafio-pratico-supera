package br.com.banco.api.service;
;
import br.com.banco.api.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.banco.api.dto.ContaDTO;
import java.util.List;

@Service
public class ContaService {
    private final ContaRepository contaRepository;

    @Autowired
    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public ContaDTO criarConta(String nomeResponsavel) {
        ContaDTO conta = new ContaDTO();
        conta.setNomeResponsavel(nomeResponsavel);
        return contaRepository.save(conta);
    }

    public List<ContaDTO> listarContas() {
        return contaRepository.findAll();
    }

    public ContaDTO buscarContaPorId(int idConta) {
        return contaRepository.findById(idConta).orElse(null);
    }

    public void excluirConta(int idConta) {
        contaRepository.deleteById(idConta);
    }
}
