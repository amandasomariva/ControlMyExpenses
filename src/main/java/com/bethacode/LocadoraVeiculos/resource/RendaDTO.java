package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.model.Renda;
import com.bethacode.LocadoraVeiculos.model.TipoDespesa;
import com.bethacode.LocadoraVeiculos.model.TipoPagamento;
import com.bethacode.LocadoraVeiculos.model.TipoRenda;

import java.time.LocalDate;

public class RendaDTO {

    private String id;
    private TipoRenda tipoRenda;
    private LocalDate dataEntrada;
    private Double valor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoRenda getTipoRenda() {
        return tipoRenda;
    }

    public void setTipoRenda(TipoRenda tipoRenda) {
        this.tipoRenda = tipoRenda;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public static RendaDTO toDTO(Renda renda) {
        RendaDTO dto = new RendaDTO();
        dto.setId(renda.getId().toString());
        dto.setTipoRenda(renda.getTipoRenda());
        dto.setDataEntrada(renda.getDataEntrada());
        dto.setValor(renda.getValor());
        return dto;
    }

    public static Renda fromDTO(RendaDTO dto) {
        Renda entity = new Renda();
        entity.setId(Long.getLong(dto.getId()));
        entity.setTipoRenda(dto.getTipoRenda());
        entity.setDataEntrada(dto.getDataEntrada());
        entity.setValor(dto.getValor());

        return entity;
    }
}
