package com.bethacode.LocadoraVeiculos.model;

import com.bethacode.LocadoraVeiculos.enterprise.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Renda extends AbstractEntity {
    @NotNull
    private TipoRenda tipoRenda;
    @NotNull
    private LocalDate dataEntrada;
    @NotNull
    private Double valor;

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
}

