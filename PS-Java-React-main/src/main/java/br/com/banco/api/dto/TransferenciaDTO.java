package br.com.banco.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferenciaDTO {
    private Long id;
    private LocalDateTime dataTransferencia;
    private BigDecimal valor;
    private String tipo;
    private String nomeOperadorTransacao;
    private int contaId;

    public TransferenciaDTO() {
        // Construtor padrão vazio
    }

    public TransferenciaDTO(Long id, LocalDateTime dataTransferencia, BigDecimal valor, String tipo, String nomeOperadorTransacao) {
        this.id = id;
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }

    public TransferenciaDTO(Long id, LocalDateTime dataTransferencia, BigDecimal valor, String tipo,
                            String nomeOperadorTransacao, int contaId) {
        this.id = id;
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
        this.contaId = contaId;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDateTime dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeOperadorTransacao() {
        return nomeOperadorTransacao;
    }

    public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }

    public int getContaId() {
        return contaId;
    }

    public void setContaId(int contaId) {
        this.contaId = contaId;
    }
}
