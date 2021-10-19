package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.model.*;

import java.time.LocalDate;

public class LocacaoDTO {

    private Long id;
    private LocalDate data;
    private LocalDate inicioPerido;
    private LocalDate fimPeriodo;
    private TipoLocacao tipo;
    private Cliente cliente;
    private Veiculo veiculo;
    private Cidade cidadeRetirada;
    private Cidade cidadeDevolucao;
    private StatusLocacao status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public static LocacaoDTO toDTO(Locacao locacao) {
        LocacaoDTO dto = new LocacaoDTO();
        dto.setId(locacao.getId());
        dto.setData(locacao.getData());
        dto.setInicioPerido(locacao.getInicioPerido());
        dto.setFimPeriodo(locacao.getFimPeriodo());
        dto.setTipo(locacao.getTipo());
        dto.setCliente(locacao.getCliente());
        dto.setVeiculo(locacao.getVeiculo());
        dto.setCidadeRetirada(locacao.getCidadeRetirada());
        dto.setCidadeDevolucao(locacao.getCidadeDevolucao());
        dto.setStatus(locacao.getStatus());
        return dto;
    }

    public static Locacao fromDTO(LocacaoDTO dto) {
        Locacao entity = new Locacao();
        entity.setId(dto.getId());
        entity.setData(dto.getData());
        entity.setInicioPerido(dto.getInicioPerido());
        entity.setFimPeriodo(dto.getFimPeriodo());
        entity.setTipo(dto.getTipo());
        entity.setCliente(dto.getCliente());
        entity.setVeiculo(dto.getVeiculo());
        entity.setCidadeRetirada(dto.getCidadeRetirada());
        entity.setCidadeDevolucao(dto.getCidadeDevolucao());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
