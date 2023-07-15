package br.com.banco.api.model;

import javax.persistence.*;

@Entity
@Table(name = "conta")
public class Conta {
    public Conta(int idConta, String nomeResponsavel) {
        this.idConta = idConta;
        this.nomeResponsavel = nomeResponsavel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private int idConta;

    @Column(name = "nome_responsavel", nullable = false)
    private String nomeResponsavel;


    // Construtores, getters e setters


    public Conta() {
    }

    public Conta(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}
