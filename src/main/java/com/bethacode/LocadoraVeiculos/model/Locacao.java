package com.bethacode.LocadoraVeiculos.model;

import com.bethacode.LocadoraVeiculos.enterprise.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Locacao extends AbstractEntity {

    @NotNull
    private LocalDate data;
    @NotNull
    private LocalDate inicioPerido;
    private LocalDate fimPeriodo;
    @NotNull
    private TipoLocacao tipo;
    @ManyToOne
    @JoinColumn(name = "i_cliente", referencedColumnName = "ID")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "i_veiculo", referencedColumnName = "ID")
    private Veiculo veiculo;
    @ManyToOne
    @JoinColumn(name = "i_cidades_retirada", referencedColumnName = "ID")
    private Cidade cidadeRetirada;
    @ManyToOne
    @JoinColumn(name = "i_cidades_devolucao", referencedColumnName = "ID")
    private Cidade cidadeDevolucao;
    private StatusLocacao status;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getInicioPerido() {
        return inicioPerido;
    }

    public void setInicioPerido(LocalDate inicioPerido) {
        this.inicioPerido = inicioPerido;
    }

    public LocalDate getFimPeriodo() {
        return fimPeriodo;
    }

    public void setFimPeriodo(LocalDate fimPeriodo) {
        this.fimPeriodo = fimPeriodo;
    }

    public TipoLocacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoLocacao tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cidade getCidadeRetirada() {
        return cidadeRetirada;
    }

    public void setCidadeRetirada(Cidade cidadeRetirada) {
        this.cidadeRetirada = cidadeRetirada;
    }

    public Cidade getCidadeDevolucao() {
        return cidadeDevolucao;
    }

    public void setCidadeDevolucao(Cidade cidadeDevolucao) {
        this.cidadeDevolucao = cidadeDevolucao;
    }

    public StatusLocacao getStatus() {
        return status;
    }

    public void setStatus(StatusLocacao status) {
        this.status = status;
    }
}
